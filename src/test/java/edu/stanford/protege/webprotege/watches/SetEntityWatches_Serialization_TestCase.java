package edu.stanford.protege.webprotege.watches;

import com.google.common.collect.ImmutableSet;
import edu.stanford.protege.webprotege.common.ChangeRequestId;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static edu.stanford.protege.webprotege.MockingUtils.*;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2021-04-07
 */
public class SetEntityWatches_Serialization_TestCase {

    @Test
    public void shouldSerializeAction() throws IOException {
        var action = new SetWatchesAction(ChangeRequestId.generate(), mockProjectId(),
                mockUserId(),
                mockOWLClass(), ImmutableSet.of(
                Watch.create(mockUserId(),
                        mockOWLClass(),
                        WatchType.ENTITY)
        ));

    }

    @Test
    public void shouldSerializeResult() throws IOException {
        var result = new SetWatchesResult();

    }
}