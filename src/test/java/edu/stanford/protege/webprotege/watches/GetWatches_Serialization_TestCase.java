package edu.stanford.protege.webprotege.watches;

import com.google.common.collect.ImmutableSet;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static edu.stanford.protege.webprotege.MockingUtils.*;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2021-04-07
 */
public class GetWatches_Serialization_TestCase {

    @Test
    public void shouldSerializeAction() throws IOException {
        var action = new GetWatchesAction(mockProjectId(),
                mockUserId(),
                mockOWLClass());

    }

    @Test
    public void shouldSerializeResult() throws IOException {
        var result = new GetWatchesResult(ImmutableSet.of());

    }
}