package edu.stanford.protege.webprotege.hierarchy;

import edu.stanford.protege.webprotege.common.ChangeRequestId;
import org.junit.Test;

import java.io.IOException;

import static edu.stanford.protege.webprotege.MockingUtils.mockOWLClassNode;
import static edu.stanford.protege.webprotege.MockingUtils.mockProjectId;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2021-04-07
 */
public class MoveHierarchyNode_Serialization_TestCase {

    private ChangeRequestId changeRequestId = ChangeRequestId.generate();

    @Test
    public void shouldSerializeAction() throws IOException {
        var action = new MoveHierarchyNodeAction(changeRequestId, mockProjectId(),
                                                 HierarchyId.CLASS_HIERARCHY, Path.asPath(mockOWLClassNode()),
                                                 Path.emptyPath(),
                                                 DropType.ADD);
        
    }

    @Test
    public void shouldSerializeResult() throws IOException {
        var result = new MoveHierarchyNodeResult(true);
        
    }
}