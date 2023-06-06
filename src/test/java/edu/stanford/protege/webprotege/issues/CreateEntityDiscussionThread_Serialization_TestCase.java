package edu.stanford.protege.webprotege.issues;

import com.google.common.collect.ImmutableList;
import edu.stanford.protege.webprotege.MockingUtils;
import edu.stanford.protege.webprotege.common.ChangeRequestId;
import edu.stanford.protege.webprotege.common.ProjectId;
import org.junit.Test;

import java.io.IOException;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2021-04-06
 */
public class CreateEntityDiscussionThread_Serialization_TestCase {

    private ChangeRequestId changeRequestId = ChangeRequestId.generate();

    @Test
    public void shouldSerializeAction() throws IOException {
        var action = new CreateEntityDiscussionThreadAction(changeRequestId, ProjectId.generate(), MockingUtils.mockOWLClass(),
                                                            "The comment");

    }

    @Test
    public void shouldSerializeResult() throws IOException {
        var result = new CreateEntityDiscussionThreadResult(ImmutableList.of());

    }
}
