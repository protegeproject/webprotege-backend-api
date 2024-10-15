package edu.stanford.protege.webprotege.hierarchy;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.vocab.OWLRDFVocabulary;
import uk.ac.manchester.cs.owl.owlapi.OWLClassImpl;

import java.util.Set;

@JsonTypeName("ClassHierarchyDescriptor")
public record ClassHierarchyDescriptor(@JsonProperty("roots") Set<OWLClass> roots) implements HierarchyDescriptor {

    public ClassHierarchyDescriptor(Set<OWLClass> roots) {
        this.roots = Set.copyOf(roots);
    }

    @JsonCreator
    public static ClassHierarchyDescriptor create(@JsonProperty("roots") Set<OWLClass> roots) {
        return new ClassHierarchyDescriptor(roots);
    }

    public static ClassHierarchyDescriptor create() {
        return create(Set.of(new OWLClassImpl(OWLRDFVocabulary.OWL_THING.getIRI())));
    }
}
