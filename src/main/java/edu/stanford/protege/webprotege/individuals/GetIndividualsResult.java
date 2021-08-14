package edu.stanford.protege.webprotege.individuals;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.dispatch.Result;
import edu.stanford.protege.webprotege.entity.EntityNode;
import edu.stanford.protege.webprotege.entity.OWLClassData;
import edu.stanford.protege.webprotege.common.Page;

import java.util.Optional;

/**
 * Author: Matthew Horridge<br>
 * Stanford University<br>
 * Bio-Medical Informatics Research Group<br>
 * Date: 12/09/2013
 */


@JsonTypeName("GetIndividuals")
public record GetIndividualsResult(@JsonProperty("type") Optional<OWLClassData> type,
                                   @JsonProperty("individuals") Page<EntityNode> result) implements Result {
}
