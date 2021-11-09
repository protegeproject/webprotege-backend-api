package edu.stanford.protege.webprotege.obo;


import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.dispatch.ProjectAction;
import org.semanticweb.owlapi.model.OWLEntity;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 21 Jun 2017
 */
@JsonTypeName("webprotege.obo.GetOboTermDefinition")
public record GetOboTermDefinitionAction(ProjectId projectId,
                                         OWLEntity term) implements ProjectAction<GetOboTermDefinitionResult> {

    public static final String CHANNEL = "webprotege.obo.GetOboTermDefinition";

    @Override
    public String getChannel() {
        return CHANNEL;
    }

    public GetOboTermDefinitionAction(ProjectId projectId, OWLEntity term) {
        this.projectId = checkNotNull(projectId);
        this.term = checkNotNull(term);
    }
}
