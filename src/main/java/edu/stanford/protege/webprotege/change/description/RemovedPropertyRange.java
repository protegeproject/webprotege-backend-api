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
public abstract class RemovedPropertyRange implements StructuredChangeDescription {

    public static RemovedPropertyRange get(@Nonnull OWLProperty property,
                                             @Nonnull OWLObject range) {
        return new AutoValue_RemovedPropertyRange(property, range);
    }

    @Nonnull
    public abstract OWLProperty getProperty();

    @Nonnull
    public abstract OWLObject getRange();

    @Nonnull
    @Override
    public String getTypeName() {
        return "RemovedPropertyRange";
    }

}
