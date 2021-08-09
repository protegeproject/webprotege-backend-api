package edu.stanford.protege.webprotege.change.description;

import com.google.auto.value.AutoValue;

import org.semanticweb.owlapi.model.OWLDataProperty;

import javax.annotation.Nonnull;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2018-12-10
 */
@AutoValue
public abstract class SetDataPropertyFunctional implements StructuredChangeDescription {

    public static SetDataPropertyFunctional get(@Nonnull OWLDataProperty property) {
        return new AutoValue_SetDataPropertyFunctional(property);
    }

    @Nonnull
    public abstract OWLDataProperty getProperty();

    @Nonnull
    @Override
    public String getTypeName() {
        return "SetDataPropertyFunctional";
    }

}
