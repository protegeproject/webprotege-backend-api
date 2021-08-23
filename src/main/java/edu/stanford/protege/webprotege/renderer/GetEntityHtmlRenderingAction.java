package edu.stanford.protege.webprotege.renderer;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.dispatch.ProjectAction;
import org.semanticweb.owlapi.model.OWLEntity;

import javax.annotation.Nonnull;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2020-03-27
 */


@JsonTypeName("GetEntityHtmlRendering")
public record GetEntityHtmlRenderingAction(@JsonProperty("projectId") @Nonnull ProjectId projectId,
                                           @JsonProperty("term") @Nonnull OWLEntity entity) implements ProjectAction<GetEntityHtmlRenderingResult> {

    public static final String CHANNEL = "webprotege.html.GetEntityHtmlRendering";

    @Override
    public String getChannel() {
        return CHANNEL;
    }
}
