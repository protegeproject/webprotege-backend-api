package edu.stanford.protege.webprotege.change.description;

import com.google.auto.value.AutoValue;

import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLAnnotationProperty;
import org.semanticweb.owlapi.model.OWLAnnotationValue;

import javax.annotation.Nonnull;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2018-12-10
 */
@AutoValue
public abstract class SwitchedAnnotationProperty implements StructuredChangeDescription {

    @Nonnull
    public static SwitchedAnnotationProperty get(@Nonnull IRI subject,
                                                 @Nonnull OWLAnnotationProperty fromProperty,
                                                 @Nonnull OWLAnnotationProperty toProperty,
                                                 @Nonnull OWLAnnotationValue value) {
        return new AutoValue_SwitchedAnnotationProperty(subject,
                                                        fromProperty,
                                                        toProperty,
                                                        value);
    }

    @Nonnull
    public abstract IRI getSubject();

    @Nonnull
    public abstract OWLAnnotationProperty getFromProperty();

    @Nonnull
    public abstract OWLAnnotationProperty getToProperty();

    @Nonnull
    public abstract OWLAnnotationValue getValue();

    @Nonnull
    @Override
    public String getTypeName() {
        return "SwitchedAnnotationProperty";
    }

}
