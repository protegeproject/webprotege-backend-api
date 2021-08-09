package edu.stanford.protege.webprotege.change.description;

import com.google.auto.value.AutoValue;

import org.semanticweb.owlapi.model.OWLObject;
import org.semanticweb.owlapi.model.OWLProperty;

import javax.annotation.Nonnull;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2018-12-10
 */
@AutoValue
public abstract class AddedPropertyDomain implements StructuredChangeDescription {

    public static AddedPropertyDomain get(@Nonnull OWLProperty property,
                                         @Nonnull OWLObject range) {
        return new AutoValue_AddedPropertyDomain(property, range);
    }

    @Nonnull
    @Override
    public String getTypeName() {
        return "AddedPropertyDomain";
    }

    @Nonnull
    public abstract OWLProperty getProperty();

    @Nonnull
    public abstract OWLObject getDomain();

}
