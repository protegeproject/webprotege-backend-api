package edu.stanford.protege.webprotege.obo;

import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.dispatch.Result;

import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 22 Jun 2017
 */
@JsonTypeName("webprotege.obo.GetOboTermSynonyms")
public record GetOboTermSynonymsResult(List<OBOTermSynonym> synonyms) implements Result {

    public GetOboTermSynonymsResult(List<OBOTermSynonym> synonyms) {
        this.synonyms = checkNotNull(synonyms);
    }
}
