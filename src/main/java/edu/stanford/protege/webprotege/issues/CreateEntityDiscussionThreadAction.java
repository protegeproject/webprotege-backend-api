package edu.stanford.protege.webprotege.issues;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.common.ChangeRequestId;
import edu.stanford.protege.webprotege.common.ContentChangeRequest;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.dispatch.ProjectAction;
import org.semanticweb.owlapi.model.OWLEntity;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 6 Oct 2016
 */
@JsonTypeName("webprotege.discussions.CreateEntityDiscussionThread")
public record CreateEntityDiscussionThreadAction(@JsonProperty("changeRequestId") ChangeRequestId changeRequestId,
                                                 @JsonProperty("projectId") ProjectId projectId,
                                                 @JsonProperty("entity") OWLEntity entity,
                                                 @JsonProperty("comment") String comment) implements ProjectAction<CreateEntityDiscussionThreadResult>, ContentChangeRequest {

    public static final String CHANNEL = "webprotege.discussions.CreateEntityDiscussionThread";

    @Override
    public String getChannel() {
        return CHANNEL;
    }
}
