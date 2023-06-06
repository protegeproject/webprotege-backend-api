package edu.stanford.protege.webprotege.change;

import edu.stanford.protege.webprotege.common.ChangeRequestId;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.revision.RevisionNumber;
import org.junit.Test;

import java.io.IOException;

import static edu.stanford.protege.webprotege.MockingUtils.mockProjectId;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2021-04-07
 */
public class RevertRevision_Serialization_TestCase {

    private final ChangeRequestId changeRequestId = ChangeRequestId.generate();

    private final ProjectId projectId = mockProjectId();

    @Test
    public void shouldSerializeAction() throws IOException {
        var action = new RevertRevisionAction(changeRequestId, projectId,
                                              RevisionNumber.getHeadRevisionNumber());
        
    }

    @Test
    public void shouldSerializeResult() throws IOException {
        var result = new RevertRevisionResult(mockProjectId(),
                                                 RevisionNumber.getHeadRevisionNumber());
        
    }
}