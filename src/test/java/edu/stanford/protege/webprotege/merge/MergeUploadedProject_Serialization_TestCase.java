package edu.stanford.protege.webprotege.merge;

import edu.stanford.protege.webprotege.common.ChangeRequestId;
import org.junit.Test;

import java.io.IOException;

import static edu.stanford.protege.webprotege.MockingUtils.mockDocumentId;
import static edu.stanford.protege.webprotege.MockingUtils.mockProjectId;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2021-04-07
 */
public class MergeUploadedProject_Serialization_TestCase {

    private ChangeRequestId changeRequestId = ChangeRequestId.generate();

    @Test
    public void shouldSerializeAction() throws IOException {
        var action = new MergeUploadedProjectAction(changeRequestId,
                                                    mockProjectId(),
                                                       mockDocumentId(),
                                                       "Test");
        
    }

    @Test
    public void shouldSerializeResult() throws IOException {
        var result = new MergeUploadedProjectResult();
        
    }
}