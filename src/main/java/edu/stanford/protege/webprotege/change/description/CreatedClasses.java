package edu.stanford.protege.webprotege.change.description;

import com.google.auto.value.AutoValue;
import com.google.common.collect.ImmutableSet;
import org.semanticweb.owlapi.model.OWLClass;

import javax.annotation.Nonnull;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2018-12-10
 */
@AutoValue
public abstract class CreatedClasses implements StructuredChangeDescription {

    private static final String CREATED_CLASSES = "CreatedClasses";

    public static String getAssociatedTypeName() {
        return CREATED_CLASSES;
    }

    @Nonnull
    public static CreatedClasses get(@Nonnull ImmutableSet<OWLClass> classes,
                                     @Nonnull ImmutableSet<OWLClass> parentClasses) {
        return new AutoValue_CreatedClasses(classes, parentClasses);
    }

    @Nonnull
    public abstract ImmutableSet<OWLClass> getClasses();

    @Nonnull
    public abstract ImmutableSet<OWLClass> getParentClasses();


    @Nonnull
    @Override
    public String getTypeName() {
        return getAssociatedTypeName();
    }

}
