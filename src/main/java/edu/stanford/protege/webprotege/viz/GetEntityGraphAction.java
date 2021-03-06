package edu.stanford.protege.webprotege.viz;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.dispatch.ProjectAction;
import org.semanticweb.owlapi.model.OWLEntity;

import javax.annotation.Nonnull;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 11 Oct 2018
 */


@JsonTypeName("webprotege.graphs.GetEntityGraph")
public record GetEntityGraphAction(@JsonProperty("projectId") @Nonnull ProjectId projectId,
                                   @JsonProperty("entity") @Nonnull OWLEntity entity) implements ProjectAction<GetEntityGraphResult> {

    public static final String CHANNEL = "webprotege.graphs.GetEntityGraph";

    @Override
    public String getChannel() {
        return CHANNEL;
    }
}
