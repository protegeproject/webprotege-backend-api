package edu.stanford.protege.webprotege.ontology;


import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.dispatch.ProjectAction;

/**
 * Author: Matthew Horridge<br>
 * Stanford University<br>
 * Bio-Medical Informatics Research Group<br>
 * Date: 20/02/2013
 */


@JsonTypeName("webprotege.ontologies.GetRootOntologyId")
public record GetRootOntologyIdAction(ProjectId projectId) implements ProjectAction<GetRootOntologyIdResult> {

    public static final String CHANNEL = "webprotege.ontologies.GetRootOntologyId";

    @Override
    public String getChannel() {
        return CHANNEL;
    }
}

