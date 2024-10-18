package edu.stanford.protege.webprotege.hierarchy;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import org.semanticweb.owlapi.model.OWLAnnotationProperty;
import org.semanticweb.owlapi.vocab.OWLRDFVocabulary;
import uk.ac.manchester.cs.owl.owlapi.OWLAnnotationPropertyImpl;
import uk.ac.manchester.cs.owl.owlapi.OWLObjectPropertyImpl;

import java.util.Set;

@JsonTypeName("AnnotationPropertyHierarchyDescriptor")
public record AnnotationPropertyHierarchyDescriptor(@JsonProperty("roots") Set<OWLAnnotationProperty> roots) implements HierarchyDescriptor {

    public AnnotationPropertyHierarchyDescriptor(@JsonProperty("roots") Set<OWLAnnotationProperty> roots) {
        this.roots = Set.copyOf(roots);
    }

    public static AnnotationPropertyHierarchyDescriptor create() {
        return new AnnotationPropertyHierarchyDescriptor(Set.of());
    }
}
