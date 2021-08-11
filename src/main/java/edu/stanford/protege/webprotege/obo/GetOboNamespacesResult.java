package edu.stanford.protege.webprotege.obo;

import edu.stanford.protege.webprotege.dispatch.Result;

import java.util.Set;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 22 Jun 2017
 */
public record GetOboNamespacesResult(Set<OBONamespace> namespaces) implements Result {

}
