package edu.stanford.protege.webprotege.individuals;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.common.PageRequest;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.dispatch.ProjectAction;
import org.semanticweb.owlapi.model.OWLClass;

/**
 * Author: Matthew Horridge<br>
 * Stanford University<br>
 * Bio-Medical Informatics Research Group<br>
 * Date: 12/09/2013
 */
@JsonTypeName("webprotege.entities.GetIndividuals")
public record GetIndividualsAction(@JsonProperty("projectId") ProjectId projectId,
                                  @JsonProperty("type") OWLClass type,
                                  @JsonProperty("pageRequest") PageRequest pageRequest,
                                  @JsonProperty("searchString") String searchString,
                                  @JsonProperty("instanceRetrievalMode") InstanceRetrievalMode instanceRetrievalMode) implements ProjectAction<GetIndividualsResult> {

    public static final String CHANNEL = "webprotege.entities.GetIndividuals";

    @Override
    public String getChannel() {
        return CHANNEL;
    }
}
