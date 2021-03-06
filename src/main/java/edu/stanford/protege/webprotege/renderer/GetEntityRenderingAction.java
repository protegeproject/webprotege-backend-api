package edu.stanford.protege.webprotege.renderer;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.dispatch.ProjectAction;
import org.semanticweb.owlapi.model.OWLEntity;

/**
 * @author Matthew Horridge, Stanford University, Bio-Medical Informatics Research Group, Date: 25/02/2014
 */


@JsonTypeName("webprotege.entities.GetEntityRendering")
public record GetEntityRenderingAction(@JsonProperty("projectId") ProjectId projectId,
                                       @JsonProperty("entity") OWLEntity entity) implements ProjectAction<GetEntityRenderingResult> {

    public static final String CHANNEL = "webprotege.entities.GetEntityRendering";

    @Override
    public String getChannel() {
        return CHANNEL;
    }
}
