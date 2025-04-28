package edu.stanford.protege.webprotege.hierarchy;

import org.junit.jupiter.api.Test;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@JsonTest
class ObjectPropertyHierarchyDescriptorJsonTest {

    public static final String ROOT_IRI = "http://example.org/A";

    @Autowired
    private JacksonTester<ObjectPropertyHierarchyDescriptor> jacksonTester;

    @Autowired
    private OWLDataFactory dataFactory;

    @Test
    void testSerializeClassHierarchyDescriptor() throws Exception {
        var prop = dataFactory.getOWLObjectProperty(IRI.create(ROOT_IRI));
        var descriptor = new ObjectPropertyHierarchyDescriptor(Set.of(prop));
        var json = jacksonTester.write(descriptor);

        // Check for the correct JSON structure
        assertThat(json).hasJsonPathArrayValue("roots")
                .extractingJsonPathStringValue("roots[0].iri")
                .isEqualTo(ROOT_IRI);

        // Assert that the @type is correct
        assertThat(json).extractingJsonPathStringValue("['@type']")
                .isEqualTo("ObjectPropertyHierarchyDescriptor");
    }

    @Test
    void testDeserializeClassHierarchyDescriptor() throws Exception {
        // Example JSON
        var json = """
                {
                    "@type": "ObjectPropertyHierarchyDescriptor",
                    "roots": [
                        {
                            "@type" : "ObjectProperty",
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