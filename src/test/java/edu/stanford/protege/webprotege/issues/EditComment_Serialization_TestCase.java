package edu.stanford.protege.webprotege.issues;

import edu.stanford.protege.webprotege.common.ProjectId;
import org.junit.Test;

import java.io.IOException;
import java.util.Optional;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2021-04-06
 */
public class EditComment_Serialization_TestCase {


    @Test
    public void shouldSerializeAction() throws IOException {
        var action = new UpdateCommentAction(ProjectId.generate(),
                                             ThreadId.create(),
                                             CommentId.create(),
                                             "Body");
    }

    @Test
    public void shouldSerializeResult() throws IOException {
        var result = new CommentResult(Optional.empty());

    }
}
