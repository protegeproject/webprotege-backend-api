package edu.stanford.protege.webprotege.issues;

import edu.stanford.protege.webprotege.common.ChangeRequestId;
import edu.stanford.protege.webprotege.common.ProjectId;
import org.junit.jupiter.api.Test;

import java.io.IOException;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2021-04-06
 */
public class DeleteEntityComment_Serialization_TestCase {


    private final ChangeRequestId changeRequestId = ChangeRequestId.generate();

    @Test
    public void shouldSerializeAction() throws IOException {
        var action = new DeleteCommentAction(changeRequestId, ProjectId.generate(),
                CommentId.create());

    }

    @Test
    public void shouldSerializeResult() throws IOException {
        var result = new DeleteCommentResult(CommentId.create(),
                true);

    }


}
