package edu.stanford.protege.webprotege.obo;

import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.dispatch.ProjectAction;
import org.semanticweb.owlapi.model.OWLEntity;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 22 Jun 2017
 */


@JsonTypeName("webprotege.obo.GetOboTermId")
public record GetOboTermIdAction(ProjectId projectId,
                                 OWLEntity term) implements ProjectAction<GetOboTermIdResult> {

    public static final String CHANNEL = "webprotege.obo.GetOboTermId";

    @Override
    public String getChannel() {
        return CHANNEL;
    }
}
