package edu.stanford.protege.webprotege.perspective;

import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static edu.stanford.protege.webprotege.MockingUtils.mockProjectId;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2021-04-07
 */
public class GetPerspectiveDetails_Serialization_TestCase {

    @Test
    public void shouldSerializeAction() throws IOException {
        var action = new GetPerspectiveDetailsAction(mockProjectId());

    }

    @Test
    public void shouldSerializeResult() throws IOException {
        var result = new GetPerspectiveDetailsResult(ImmutableList.of());

    }
}