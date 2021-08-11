package edu.stanford.protege.webprotege.obo;

import edu.stanford.protege.webprotege.dispatch.Result;

import java.util.List;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 22 Jun 2017
 */
public record GetOboTermSynonymsResult(List<OBOTermSynonym> synonyms) implements Result {

}
