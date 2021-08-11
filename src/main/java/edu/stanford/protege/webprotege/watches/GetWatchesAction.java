package edu.stanford.protege.webprotege.watches;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.dispatch.ProjectAction;
import edu.stanford.protege.webprotege.user.UserId;
import org.semanticweb.owlapi.model.OWLEntity;

/**
 * Author: Matthew Horridge<br>
 * Stanford University<br>
 * Bio-Medical Informatics Research Group<br>
 * Date: 20/03/2013
 */


@JsonTypeName("GetWatches")
public record GetWatchesAction(@JsonProperty("projectId") ProjectId projectId,
                               @JsonProperty("userId") UserId userId,
                               @JsonProperty("term") OWLEntity entity) implements ProjectAction<GetWatchesResult> {
}
