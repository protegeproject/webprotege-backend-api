package edu.stanford.protege.webprotege.change.description;

import com.google.auto.value.AutoValue;
import com.google.common.collect.ImmutableSet;

import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLNamedIndividual;

import javax.annotation.Nonnull;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2018-12-10
 */
@AutoValue
public abstract class CreatedIndividuals implements StructuredChangeDescription {

    public static CreatedIndividuals get(@Nonnull ImmutableSet<OWLNamedIndividual> individuals,
                                         @Nonnull ImmutableSet<OWLClass> types) {
        return new AutoValue_CreatedIndividuals(individuals, types);
    }

    @Nonnull
    public abstract ImmutableSet<OWLNamedIndividual> getIndividuals();

    @Nonnull
    public abstract ImmutableSet<OWLClass> getTypes();

    @Nonnull
    @Override
    public String getTypeName() {
        return "CreatedIndividuals";
    }

}
