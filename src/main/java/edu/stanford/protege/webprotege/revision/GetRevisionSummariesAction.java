package edu.stanford.protege.webprotege.revision;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.common.PageRequest;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.dispatch.ProjectAction;

import java.util.Objects;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 21/02/15
 */
@JsonTypeName("webprotege.history.GetRevisionSummaries")
public record GetRevisionSummariesAction(@JsonProperty(required = true) ProjectId projectId,
                                         PageRequest pageRequest) implements ProjectAction<GetRevisionSummariesResult> {

    public static final String CHANNEL = "webprotege.history.GetRevisionSummaries";

    public GetRevisionSummariesAction(@JsonProperty(required = true) ProjectId projectId, PageRequest pageRequest) {
        this.projectId = checkNotNull(projectId);
        this.pageRequest = Objects.requireNonNullElse(pageRequest, PageRequest.requestFirstPage());
    }

    @Override
    public String getChannel() {
        return CHANNEL;
    }
}
