package edu.stanford.protege.webprotege.criteria;

import org.semanticweb.owlapi.model.OWLPrimitive;

import javax.annotation.Nonnull;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2019-12-04
 */
public interface RelationshipValueEqualsCriteria extends RelationshipValueCriteria {

    @Nonnull
    OWLPrimitive getValue();
}
