package edu.stanford.protege.webprotege.change.description;

import com.google.auto.value.AutoValue;
import org.semanticweb.owlapi.model.OWLEntity;

import javax.annotation.Nonnull;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2018-12-10
 */
@AutoValue
public abstract class AddedParent implements StructuredChangeDescription {

    public static AddedParent get(@Nonnull OWLEntity child,
                                    @Nonnull OWLEntity parent) {
        return new AutoValue_AddedParent(child, parent);
    }

    @Nonnull
    @Override
    public String getTypeName() {
        return "AddedParent";
    }

    @Nonnull
    public abstract OWLEntity getChild();

    @Nonnull
    public abstract OWLEntity getParent();
}
