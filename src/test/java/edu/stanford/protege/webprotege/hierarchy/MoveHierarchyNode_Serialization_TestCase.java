package edu.stanford.protege.webprotege.hierarchy;

import edu.stanford.protege.webprotege.common.ChangeRequestId;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static edu.stanford.protege.webprotege.MockingUtils.mockOWLClassNode;
import static edu.stanford.protege.webprotege.MockingUtils.mockProjectId;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2021-04-07
 */
public class MoveHierarchyNode_Serialization_TestCase {

    private final ChangeRequestId changeRequestId = ChangeRequestId.generate();

    @Test
    public void shouldSerializeAction() throws IOException {
        var action = new MoveHierarchyNodeAction(changeRequestId, mockProjectId(),
                ClassHierarchyDescriptor.create(),
                Path.asPath(mockOWLClassNode()),
                Path.emptyPath(),
                DropType.ADD);

    }

    @Test
    public void shouldSerializeResult() throws IOException {
        var result = new MoveHierarchyNodeResult(true);

    }
}