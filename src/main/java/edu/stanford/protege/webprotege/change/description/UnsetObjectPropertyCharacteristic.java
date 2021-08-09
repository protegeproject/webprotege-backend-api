package edu.stanford.protege.webprotege.change.description;

import com.google.auto.value.AutoValue;
import edu.stanford.protege.webprotege.frame.ObjectPropertyCharacteristic;

import org.semanticweb.owlapi.model.OWLObjectProperty;

import javax.annotation.Nonnull;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2018-12-10
 */
@AutoValue
public abstract class UnsetObjectPropertyCharacteristic implements StructuredChangeDescription {

    public UnsetObjectPropertyCharacteristic get(@Nonnull OWLObjectProperty property,
                                                 @Nonnull ObjectPropertyCharacteristic characteristic) {
        return new AutoValue_UnsetObjectPropertyCharacteristic(property, characteristic);
    }

    @Nonnull
    public abstract OWLObjectProperty getProperty();

    @Nonnull
    public abstract ObjectPropertyCharacteristic getCharacteristic();

    @Nonnull
    @Override
    public String getTypeName() {
        return "UnsetObjectPropertyCharacteristic";
    }

}
