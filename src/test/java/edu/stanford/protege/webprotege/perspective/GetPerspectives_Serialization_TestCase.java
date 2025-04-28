package edu.stanford.protege.webprotege.perspective;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static edu.stanford.protege.webprotege.MockingUtils.mockProjectId;
import static edu.stanford.protege.webprotege.MockingUtils.mockUserId;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2021-04-07
 */
public abstract class GetPerspectives_Serialization_TestCase {

    @Test
    public void shouldSerializeAction() throws IOException {
        var action = new GetPerspectivesAction(mockProjectId(),
                mockUserId());

    }

    @Test
    public void shouldSerializeResult() throws IOException {
        var result = new GetPerspectivesResult(ImmutableList.of(), ImmutableSet.of());

    }
}