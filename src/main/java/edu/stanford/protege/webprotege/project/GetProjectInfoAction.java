package edu.stanford.protege.webprotege.project;


import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.dispatch.ProjectAction;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 21 Aug 2018
 */
@JsonTypeName("webprotege.projects.GetProjectInfo")
public record GetProjectInfoAction(ProjectId projectId) implements ProjectAction<GetProjectInfoResult> {

    public static final String CHANNEL = "webprotege.projects.GetProjectInfo";

    @Override
    public String getChannel() {
        return CHANNEL;
    }
}
