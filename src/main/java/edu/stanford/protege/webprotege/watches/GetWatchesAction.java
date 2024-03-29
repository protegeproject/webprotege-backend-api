package edu.stanford.protege.webprotege.watches;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.common.UserId;
import edu.stanford.protege.webprotege.dispatch.ProjectAction;
import org.semanticweb.owlapi.model.OWLEntity;

/**
 * Author: Matthew Horridge<br>
 * Stanford University<br>
 * Bio-Medical Informatics Research Group<br>
 * Date: 20/03/2013
 */


@JsonTypeName("webprotege.watches.GetWatches")
public record GetWatchesAction(@JsonProperty("projectId") ProjectId projectId,
                               @JsonProperty("userId") UserId userId,
                               @JsonProperty("entity") OWLEntity entity) implements ProjectAction<GetWatchesResult> {

    public static final String CHANNEL = "webprotege.watches.GetWatches";

    @Override
    public String getChannel() {
        return CHANNEL;
    }
}
