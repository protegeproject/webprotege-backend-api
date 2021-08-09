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
public abstract class AddedLanguageTag implements StructuredChangeDescription {

    @Nonnull
    public static AddedLanguageTag get(@Nonnull IRI subject,
                                       @Nonnull OWLAnnotationProperty property,
                                       @Nonnull OWLAnnotationValue value,
                                       @Nonnull String languageTag) {
        return new AutoValue_AddedLanguageTag(subject,
                                              property,
                                              value,
                                              languageTag);
    }

    public abstract IRI getSubject();

    public abstract OWLAnnotationProperty getProperty();

    public abstract OWLAnnotationValue getValue();

    public abstract String getLanguageTag();

    @Nonnull
    @Override
    public String getTypeName() {
        return "AddedLanguageTag";
    }

}
