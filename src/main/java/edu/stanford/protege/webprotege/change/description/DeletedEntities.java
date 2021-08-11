package edu.stanford.protege.webprotege.change.description;

import com.google.auto.value.AutoValue;
import com.google.common.collect.ImmutableSet;
import org.semanticweb.owlapi.model.OWLEntity;

import javax.annotation.Nonnull;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2018-12-10
 */
@AutoValue
public abstract class DeletedEntities implements StructuredChangeDescription {

    public static DeletedEntities get(@Nonnull ImmutableSet<OWLEntity> entities) {
        return new AutoValue_DeletedEntities(entities);
    }

    @Nonnull
    public abstract ImmutableSet<OWLEntity> getEntities();

    @Nonnull
    @Override
    public String getTypeName() {
        return "DeletedEntities";
    }

}
