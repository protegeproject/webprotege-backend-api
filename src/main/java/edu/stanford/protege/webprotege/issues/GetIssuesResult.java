package edu.stanford.protege.webprotege.issues;

import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.dispatch.Result;
import edu.stanford.protege.webprotege.project.HasProjectId;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 27 Jul 16
 */
@JsonTypeName("webprotege.issues.GetIssues")
public class GetIssuesResult implements Result, HasProjectId {

    private ProjectId projectId;

    private List<Issue> issues;

    private GetIssuesResult() {
    }

    public GetIssuesResult(ProjectId projectId, List<Issue> issueCurClients) {
        this.projectId = projectId;
        this.issues = new ArrayList<>(issueCurClients);
    }

    @Nonnull
    @Override
    public ProjectId projectId() {
        return projectId;
    }

    public List<Issue> getIssues() {
        return new ArrayList<>(issues);
    }
}
