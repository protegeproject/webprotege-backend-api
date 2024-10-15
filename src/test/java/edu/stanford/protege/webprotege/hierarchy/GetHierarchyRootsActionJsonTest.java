package edu.stanford.protege.webprotege.hierarchy;

import edu.stanford.protege.webprotege.common.ProjectId;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.json.JsonContent;
import org.springframework.boot.test.json.ObjectContent;

import static org.assertj.core.api.Assertions.assertThat;

import org.semanticweb.owlapi.model.OWLDataFactory;

import java.util.Set;

@JsonTest
public class GetHierarchyRootsActionJsonTest {

    @Autowired
    private JacksonTester<GetHierarchyRootsAction> jacksonTester;

    @Autowired
    private OWLDataFactory dataFactory;

    @Test
    void testSerializeGetHierarchyRootsAction() throws Exception {
        var projectId = ProjectId.generate();
        var rootCls = dataFactory.getOWLThing();
        var hierarchyDescriptor = new ClassHierarchyDescriptor(Set.of(rootCls));
        var action = new GetHierarchyRootsAction(projectId, hierarchyDescriptor);

        JsonContent<GetHierarchyRootsAction> json = jacksonTester.write(action);

        assertThat(json).hasJsonPath("$.projectId");
        assertThat(json).hasJsonPath("$.hierarchyDescriptor");
    }

    @Test
    void testDeserializeGetHierarchyRootsAction() throws Exception {
        var json = """
        {
            "projectId": "123e4567-e89b-12d3-a456-426614174000",
            "hierarchyDescriptor": {
                "@type": "ClassHierarchyDescriptor",
                "roots": [
                    {
                        "iri": "http://www.w3.org/2002/07/owl#Thing"
                    }
                ]
            },
            "@type": "webprotege.hierarchies.GetHierarchyRoots"
        }
        """;

        var objectContent = jacksonTester.parse(json);
        var action = objectContent.getObject();

        assertThat(action.projectId()).isNotNull();
        assertThat(action.hierarchyDescriptor()).isNotNull();
        assertThat(action.getChannel()).isEqualTo(GetHierarchyRootsAction.CHANNEL);
    }
}
