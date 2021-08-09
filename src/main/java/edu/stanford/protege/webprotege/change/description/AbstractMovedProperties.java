package edu.stanford.protege.webprotege.change.description;

import com.google.common.collect.ImmutableSet;

import org.semanticweb.owlapi.model.OWLProperty;

import javax.annotation.Nonnull;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2018-12-10
 */
public abstract class AbstractMovedProperties implements StructuredChangeDescription {

    @Nonnull
    public abstract ImmutableSet<? extends OWLProperty> getProperties();

    @Nonnull
    public abstract ImmutableSet<? extends OWLProperty> getFrom();

    @Nonnull
    public abstract OWLProperty getTo();

}
