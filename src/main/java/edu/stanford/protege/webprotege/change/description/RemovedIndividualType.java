package edu.stanford.protege.webprotege.change.description;

import com.google.auto.value.AutoValue;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLIndividual;

import javax.annotation.Nonnull;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2018-12-10
 */
@AutoValue
public abstract class RemovedIndividualType implements StructuredChangeDescription {

    public static RemovedIndividualType get(@Nonnull OWLIndividual individual,
                                            @Nonnull OWLClass type) {
        return new AutoValue_RemovedIndividualType(individual, type);
    }

    @Nonnull
    public abstract OWLIndividual getIndividual();

    @Nonnull
    public abstract OWLClass getType();

    @Nonnull
    @Override
    public String getTypeName() {
        return "RemovedIndividualType";
    }

}
