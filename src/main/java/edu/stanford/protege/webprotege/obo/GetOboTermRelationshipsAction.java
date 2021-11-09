package edu.stanford.protege.webprotege.obo;

import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.dispatch.ProjectAction;
import org.semanticweb.owlapi.model.OWLClass;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 22 Jun 2017
 */
@JsonTypeName("webprotege.obo.GetOboTermRelationships")
public record GetOboTermRelationshipsAction(ProjectId projectId,
                                           OWLClass term) implements ProjectAction<GetOboTermRelationshipsResult> {

    public static final String CHANNEL = "webprotege.obo.GetOboTermRelationships";

    @Override
    public String getChannel() {
        return CHANNEL;
    }

    public GetOboTermRelationshipsAction(ProjectId projectId, OWLClass term) {
        this.projectId = checkNotNull(projectId);
        this.term = checkNotNull(term);
    }
}
