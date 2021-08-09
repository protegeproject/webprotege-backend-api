package edu.stanford.protege.webprotege.change.description;

import com.google.common.collect.ImmutableSet;

import org.semanticweb.owlapi.model.OWLProperty;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2018-12-10
 */
public abstract class AbstractCreatedProperties implements StructuredChangeDescription {


    public abstract ImmutableSet<? extends OWLProperty> getProperties();

    public abstract ImmutableSet<? extends OWLProperty> getParentProperties();

}
