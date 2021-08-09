package edu.stanford.protege.webprotege.bulkop;

import com.google.auto.value.AutoValue;
import org.semanticweb.owlapi.model.OWLAnnotationProperty;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Optional;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 26 Sep 2018
 */
@AutoValue

public abstract class AnnotationSimpleMatchingCriteria {

    public static AnnotationSimpleMatchingCriteria get(@Nullable OWLAnnotationProperty property,
                                                       boolean matchValue,
                                                       @Nonnull String value,
                                                       boolean regEx,
                                                       boolean matchLangTag,
                                                       String langTag) {
        return new AutoValue_AnnotationSimpleMatchingCriteria(property,
                                                              matchValue,
                                                              value,
                                                              regEx,
                                                              matchLangTag,
                                                              langTag);
    }

    @Nullable
    protected abstract OWLAnnotationProperty getProp();

    public Optional<OWLAnnotationProperty> getProperty() {
        return Optional.ofNullable(getProp());
    }

    public abstract boolean isMatchValue();

    @Nonnull
    public abstract String getValue();

    public abstract boolean isValueRegularExpression();

    public abstract boolean isMatchLangTag();

    @Nonnull
    public abstract String getLangTag();
}