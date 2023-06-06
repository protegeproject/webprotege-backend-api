package edu.stanford.protege.webprotege.perspective;

import edu.stanford.protege.webprotege.common.ChangeRequestId;
import org.junit.Test;

import java.io.IOException;

import static edu.stanford.protege.webprotege.MockingUtils.mockProjectId;
import static edu.stanford.protege.webprotege.MockingUtils.mockUserId;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2021-04-07
 */
public class SetPerspectiveLayout_Serialization_TestCase {

    @Test
    public void shouldSerializeAction() throws IOException {
        var action = new SetPerspectiveLayoutAction(ChangeRequestId.generate(),
                                                    mockProjectId(),
                                                    mockUserId(),
                                                    PerspectiveLayout.get(PerspectiveId.generate()));

    }

    @Test
    public void shouldSerializeResult() throws IOException {
        var result = new SetPerspectiveLayoutResult();

    }
}