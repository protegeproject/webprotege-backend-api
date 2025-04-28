package edu.stanford.protege.webprotege.bulkop;

import com.google.common.collect.ImmutableSet;
import edu.stanford.protege.webprotege.common.ChangeRequestId;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static edu.stanford.protege.webprotege.MockingUtils.mockOWLClass;
import static edu.stanford.protege.webprotege.MockingUtils.mockProjectId;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2021-04-07
 */
public class MoveEntitiesToParent_Serialization_TestCase {

    @Test
    public void shouldSerializeAction() throws IOException {
        var action = new MoveEntitiesToParentAction(ChangeRequestId.generate(), mockProjectId(), ImmutableSet.of(),
                mockOWLClass(),
                "Test");

    }

    @Test
    public void shouldSerializeResult() throws IOException {
        var result = new MoveEntitiesToParentResult();

    }
}