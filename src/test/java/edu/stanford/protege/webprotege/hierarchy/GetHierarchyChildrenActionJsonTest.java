package edu.stanford.protege.webprotege.hierarchy;

import edu.stanford.protege.webprotege.common.PageRequest;
import edu.stanford.protege.webprotege.common.ProjectId;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;

import static org.assertj.core.api.Assertions.assertThat;

import org.semanticweb.owlapi.model.OWLDataFactory;

import java.util.Set;

@JsonTest
public class GetHierarchyChildrenActionJsonTest {

    @Autowired
    private JacksonTester<GetHierarchyChildrenAction> jacksonTester;

    @Autowired
    private OWLDataFactory dataFactory;  // Auto-wired OWLDataFactory

    @Test
    void testSerializeGetHierarchyChildrenAction() throws Exception {
        var projectId = ProjectId.generate();
        var owlClass = dataFactory.getOWLThing();
        var hierarchyDescriptor = new ClassHierarchyDescriptor(Set.of(owlClass));
        var pageRequest = PageRequest.requestFirstPage();

        var action = new GetHierarchyChildrenAction(projectId, owlClass, hierarchyDescriptor, pageRequest);

        var json = jacksonTester.write(action);

        assertThat(json).hasJsonPath("$.projectId");
        assertThat(json).hasJsonPath("$.entity.iri");
        assertThat(json).hasJsonPath("$.hierarchyDescriptor");
        assertThat(json).hasJsonPath("$.pageRequest");
    }

    @Test
    void testDeserializeGetHierarchyChildrenAction() throws Exception {
        var json = """
        {
            "projectId": "123e4567-e89b-12d3-a456-426614174000",
            "entity": {
                "iri": "http://www.w3.org/2002/07/owl#Thing",
                "@type": "Class"
            },
            "hierarchyDescriptor": {
                "@type": "ClassHierarchyDescriptor",
                "roots": [
                    {
                        "iri": "http://www.w3.org/2002/07/owl#Thing"
                    }
                ]
            },
            "pageRequest": {
                "pageNumber": 1,
                "pageSize": 10
            },
            "@type": "webprotege.hierarchies.GetHierarchyChildren"
        }
        """;

        // Deserialize from JSON
        var objectContent = jacksonTester.parse(json);

        var action = objectContent.getObject();

        assertThat(action.projectId()).isNotNull();
        assertThat(action.entity()).isNotNull();
        assertThat(action.hierarchyDescriptor()).isNotNull();
        assertThat(action.pageRequest()).isNotNull();
        assertThat(action.getChannel()).isEqualTo(GetHierarchyChildrenAction.CHANNEL);
    }
}


