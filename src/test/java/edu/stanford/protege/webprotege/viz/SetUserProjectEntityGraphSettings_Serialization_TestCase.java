package edu.stanford.protege.webprotege.viz;

import com.google.common.collect.ImmutableList;
import edu.stanford.protege.webprotege.common.ChangeRequestId;
import edu.stanford.protege.webprotege.dispatch.Action;
import edu.stanford.protege.webprotege.dispatch.Result;

import org.junit.Test;

import java.io.IOException;


import static edu.stanford.protege.webprotege.MockingUtils.*;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2021-04-07
 */
public abstract class SetUserProjectEntityGraphSettings_Serialization_TestCase {

    @Test
    public void shouldSerializeAction() throws IOException {
        var action = new SetUserProjectEntityGraphSettingsAction(ChangeRequestId.generate(),
                                                                 mockProjectId(),
                                                                 mockUserId(),
                                                                 EntityGraphSettings.get(
                                                                            ImmutableList.of(),
                                                                            2
                                                                    ));

    }

    @Test
    public void shouldSerializeResult() throws IOException {
        var result = new SetUserProjectEntityGraphSettingsResult();

    }
}