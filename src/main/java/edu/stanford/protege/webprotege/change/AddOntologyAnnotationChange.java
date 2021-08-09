package edu.stanford.protege.webprotege.change;

import com.google.auto.value.AutoValue;
import org.semanticweb.owlapi.change.AddOntologyAnnotationData;
import org.semanticweb.owlapi.change.OWLOntologyChangeRecord;
import org.semanticweb.owlapi.model.OWLAnnotation;
import org.semanticweb.owlapi.model.OWLOntologyID;

import javax.annotation.Nonnull;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2019-08-26
 */
@AutoValue
public abstract class AddOntologyAnnotationChange implements OntologyAnnotationChange {

    @Nonnull
    public static AddOntologyAnnotationChange of(@Nonnull OWLOntologyID ontologyId,
                                                 @Nonnull OWLAnnotation annotation) {
        return new AutoValue_AddOntologyAnnotationChange(ontologyId, annotation);
    }

    @Nonnull
    @Override
    public AddOntologyAnnotationChange replaceOntologyId(@Nonnull OWLOntologyID ontologyId) {
        if(getOntologyId().equals(ontologyId)) {
            return this;
        }
        else {
            return AddOntologyAnnotationChange.of(ontologyId, getAnnotation());
        }
    }

    @Nonnull
    @Override
    public OWLOntologyChangeRecord toOwlOntologyChangeRecord() {
        return new OWLOntologyChangeRecord(getOntologyId(), new AddOntologyAnnotationData(getAnnotation()));
    }

    @Override
    public boolean isAddOntologyAnnotation() {
        return true;
    }

    @Override
    public void accept(@Nonnull OntologyChangeVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public <R> R accept(@Nonnull OntologyChangeVisitorEx<R> visitorEx) {
        return visitorEx.visit(this);
    }

    @Nonnull
    @Override
    public RemoveOntologyAnnotationChange getInverseChange() {
        return RemoveOntologyAnnotationChange.of(getOntologyId(), getAnnotation());
    }
}
