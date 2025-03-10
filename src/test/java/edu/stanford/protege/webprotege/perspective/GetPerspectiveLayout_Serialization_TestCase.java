package edu.stanford.protege.webprotege.perspective;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static edu.stanford.protege.webprotege.MockingUtils.mockProjectId;
import static edu.stanford.protege.webprotege.MockingUtils.mockUserId;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2021-04-07
 */
public class GetPerspectiveLayout_Serialization_TestCase {

    @Test
    public void shouldSerializeAction() throws IOException {
        var action = new GetPerspectiveLayoutAction(mockProjectId(),
                mockUserId(),
                PerspectiveId.generate());

    }

    @Test
    public void shouldSerializeResult() throws IOException {
        var result = new GetPerspectiveLayoutResult(PerspectiveLayout.get(PerspectiveId.generate()));

    }
}