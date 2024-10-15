package edu.stanford.protege.webprotege.hierarchy;

import org.junit.jupiter.api.Test;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Set;

@JsonTest
public class ClassHierarchyDescriptorJsonTest {

    public static final String ROOT_IRI = "http://example.org/A";
    @Autowired
    private JacksonTester<ClassHierarchyDescriptor> jacksonTester;

    @Autowired
    private OWLDataFactory dataFactory;

    @Test
    void testSerializeClassHierarchyDescriptor() throws Exception {
        var cls = dataFactory.getOWLClass(IRI.create(ROOT_IRI));
        var descriptor = new ClassHierarchyDescriptor(Set.of(cls));
        var json = jacksonTester.write(descriptor);

        // Check for the correct JSON structure
        assertThat(json).hasJsonPathArrayValue("roots")
                .extractingJsonPathStringValue("roots[0].iri")
                .isEqualTo(ROOT_IRI);

        // Assert that the @type is correct
        assertThat(json).extractingJsonPathStringValue("['@type']")
                .isEqualTo("ClassHierarchyDescriptor");
    }

    @Test
    void testDeserializeClassHierarchyDescriptor() throws Exception {
        // Example JSON
        var json = """
        {
            "@type": "ClassHierarchyDescriptor",
            "roots": [
                {
                    "@type" : "Class",
                    "iri": "http://example.org/A"
                }
            ]
        }
        """;

        var objectContent = jacksonTester.parse(json);
        var descriptor = objectContent.getObject();

        assertThat(descriptor).isNotNull();
        assertThat(descriptor.roots()).hasSize(1);
        var rootClass = descriptor.roots().iterator().next();
        assertThat(rootClass.getIRI().toString()).isEqualTo(ROOT_IRI);
    }
}
