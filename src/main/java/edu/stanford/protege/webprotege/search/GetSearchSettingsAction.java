package edu.stanford.protege.webprotege.search;

import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.dispatch.ProjectAction;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2020-08-17
 */


@JsonTypeName("GetSearchSettings")
public record GetSearchSettingsAction(ProjectId projectId) implements ProjectAction<GetSearchSettingsResult> {

    public static final String CHANNEL = "webprotege.search.GetSearchSettings";

    @Override
    public String getChannel() {
        return CHANNEL;
    }
}
