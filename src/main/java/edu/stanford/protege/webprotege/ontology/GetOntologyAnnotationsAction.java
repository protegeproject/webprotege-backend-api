package edu.stanford.protege.webprotege.ontology;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.dispatch.ProjectAction;
import org.semanticweb.owlapi.model.OWLOntologyID;

import javax.annotation.Nonnull;
import java.util.Optional;

/**
 * Author: Matthew Horridge<br>
 * Stanford University<br>
 * Bio-Medical Informatics Research Group<br>
 * Date: 21/02/2013
 */


@JsonTypeName("GetOntologyAnnotations")
public record GetOntologyAnnotationsAction(@JsonProperty("projectId") @Nonnull ProjectId projectId,
                                           @JsonProperty("ontologyId") @Nonnull Optional<OWLOntologyID> ontologyId) implements ProjectAction<GetOntologyAnnotationsResult> {

    public static final String CHANNEL = "webprotege.ontologies.GetOntologyAnnotations";

    @Override
    public String getChannel() {
        return CHANNEL;
    }
}
