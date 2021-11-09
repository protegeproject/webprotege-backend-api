package edu.stanford.protege.webprotege.obo;

import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.dispatch.Result;
import org.semanticweb.owlapi.model.OWLEntity;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 22 Jun 2017
 */
@JsonTypeName("webprotege.obo.GetOboTermId")
public record GetOboTermIdResult(OWLEntity term,
                                OBOTermId termId) implements Result {

    public GetOboTermIdResult(OWLEntity term, OBOTermId termId) {
        this.term = checkNotNull(term);
        this.termId = checkNotNull(termId);
    }
}
