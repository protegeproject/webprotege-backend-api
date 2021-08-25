package edu.stanford.protege.webprotege.issues;

import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.dispatch.Action;
import edu.stanford.protege.webprotege.project.HasProjectId;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 28 Sep 2016
 */
public record AddIssueCommentAction(ProjectId projectId,
                                    int issueNumber,
                                    Comment comment) implements Action<AddIssueCommentResult>, HasProjectId {


    public static final String CHANNEL = "webprotege.discussions.AddIssueComment";

    @Override
    public String getChannel() {
        return CHANNEL;
    }
}
