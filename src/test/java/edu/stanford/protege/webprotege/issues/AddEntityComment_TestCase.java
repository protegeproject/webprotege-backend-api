package edu.stanford.protege.webprotege.issues;

import com.google.common.collect.ImmutableList;
import edu.stanford.protege.webprotege.dispatch.Action;
import edu.stanford.protege.webprotege.dispatch.Result;

import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.common.UserId;
import org.junit.Test;

import java.io.IOException;
import java.util.Optional;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2021-04-05
 */
public class AddEntityComment_TestCase {

    private static final String THE_COMMENT = "The comment";

    private final ProjectId projectId = ProjectId.generate();

    private final ThreadId threadId = ThreadId.create();

    @Test
    public void shouldSerializeAction() throws IOException {
        var action = AddEntityCommentAction.addComment(projectId, threadId, THE_COMMENT);

    }

    @Test
    public void shouldSerializeResult() throws IOException {
        var result = new AddEntityCommentResult(projectId,
                                                   threadId,
                                                   new Comment(CommentId.create(), UserId.valueOf("TheUser"),
                                                               1000, Optional.empty(),
                                                               THE_COMMENT,
                                                               THE_COMMENT),
                                                   THE_COMMENT);

    }
}
