package edu.stanford.protege.webprotege.hierarchy;

import edu.stanford.protege.webprotege.common.ChangeRequestId;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.entity.EntityNode;
import org.junit.jupiter.api.Test;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.json.JsonContent;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@JsonTest
public class MoveHierarchyNodeActionJsonTest {

    @Autowired
    private JacksonTester<MoveHierarchyNodeAction> jacksonTester;

    @Autowired
    private OWLDataFactory dataFactory;

    @Test
    void testSerializeMoveHierarchyNodeAction() throws Exception {
        var changeRequestId = ChangeRequestId.generate();
        var projectId = ProjectId.generate();
        var owlClass = dataFactory.getOWLThing();
        var hierarchyDescriptor = new ClassHierarchyDescriptor(Set.of(owlClass));
        var fromNodePath = Path.<EntityNode>emptyPath();
        var toNodeParentPath = Path.<EntityNode>emptyPath();
        var dropType = DropType.MOVE;

        var action = new MoveHierarchyNodeAction(
                changeRequestId, projectId, hierarchyDescriptor, fromNodePath, toNodeParentPath, dropType
        );

        JsonContent<MoveHierarchyNodeAction> json = jacksonTester.write(action);

        assertThat(json).hasJsonPathStringValue("$.changeRequestId");
        assertThat(json).hasJsonPathStringValue("$.projectId");
        assertThat(json).hasJsonPathMapValue("$.hierarchyDescriptor");
        assertThat(json).hasJsonPathArrayValue("$.fromNodePath");
        assertThat(json).hasJsonPathArrayValue("$.toNodeParentPath");
        assertThat(json).hasJsonPathStringValue("$.dropType");
    }

    @Test
    void testDeserializeMoveHierarchyNodeAction() throws Exception {
        var json = """
                {
                    "changeRequestId": "123e4567-e89b-12d3-a456-426614174000",
                    "projectId": "123e4567-e89b-12d3-a456-426614174000",
                    "hierarchyDescriptor": {
                        "@type": "ClassHierarchyDescriptor",
                        "roots": [
                            {
                                "iri": "http://www.w3.org/2002/07/owl#Thing"
                            }
                        ]
                    },
                    "fromNodePath": [],
                    "toNodeParentPath": [],
                    "dropType": "MOVE",
                    "@type": "webprotege.hierarchies.MoveHierarchyNode"
                }
                """;

        var objectContent = jacksonTester.parse(json);
        var action = objectContent.getObject();

        assertThat(action.changeRequestId()).isNotNull();
        assertThat(action.projectId()).isNotNull();
        assertThat(action.hierarchyDescriptor()).isNotNull();
        assertThat(action.fromNodePath()).isNotNull();
        assertThat(action.toNodeParentPath()).isNotNull();
        assertThat(action.dropType()).isNotNull();
        assertThat(action.getChannel()).isEqualTo(MoveHierarchyNodeAction.CHANNEL);
    }
}
