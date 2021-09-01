package edu.stanford.protege.webprotege.revision;

import com.fasterxml.jackson.annotation.JsonProperty;
import edu.stanford.protege.webprotege.common.PageRequest;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.dispatch.ProjectAction;

import java.util.Objects;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 21/02/15
 */
public record GetRevisionSummariesAction(@JsonProperty(required = true) ProjectId projectId,
                                         PageRequest pageRequest) implements ProjectAction<GetRevisionSummariesResult> {

    public static final String CHANNEL = "webprotege.history.GetRevisionSummaries";

    public GetRevisionSummariesAction(@JsonProperty(required = true) ProjectId projectId, PageRequest pageRequest) {
        this.projectId = projectId;
        this.pageRequest = Objects.requireNonNullElse(pageRequest, PageRequest.requestFirstPage());
    }

    @Override
    public String getChannel() {
        return CHANNEL;
    }
}
