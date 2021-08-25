package edu.stanford.protege.webprotege.issues;

import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.dispatch.ProjectAction;

import javax.annotation.Nonnull;
import java.util.Objects;

import static com.google.common.base.MoreObjects.toStringHelper;
import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 27 Jul 16
 */
public record GetIssuesAction(ProjectId projectId) implements ProjectAction<GetIssuesResult> {

    public static final String CHANNEL = "webprotege.issues.GetIssues";

    @Override
    public String getChannel() {
        return CHANNEL;
    }
}
