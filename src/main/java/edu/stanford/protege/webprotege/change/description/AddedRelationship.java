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
public abstract class AddedRelationship implements StructuredChangeDescription {

    public static AddedRelationship get(@Nonnull OWLObject subject,
                                        @Nonnull OWLProperty property,
                                        @Nonnull OWLObject value) {
        return new AutoValue_AddedRelationship(subject, property, value);
    }

    @Nonnull
    @Override
    public String getTypeName() {
        return "AddedRelationship";
    }

    @Nonnull
    public abstract OWLObject getSubject();

    @Nonnull
    public abstract OWLProperty getProperty();

    @Nonnull
    public abstract OWLObject getValue();
}
