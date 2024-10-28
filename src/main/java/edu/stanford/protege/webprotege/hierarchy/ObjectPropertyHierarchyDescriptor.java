package edu.stanford.protege.webprotege.hierarchy;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.semanticweb.owlapi.vocab.OWLRDFVocabulary;
import uk.ac.manchester.cs.owl.owlapi.OWLObjectPropertyImpl;

import java.util.Set;

@JsonTypeName("ObjectPropertyHierarchyDescriptor")
public record ObjectPropertyHierarchyDescriptor(@JsonProperty("roots") Set<OWLObjectProperty> roots) implements HierarchyDescriptor {

    public ObjectPropertyHierarchyDescriptor(Set<OWLObjectProperty> roots) {
        this.roots = Set.copyOf(roots);
    }

    public static ObjectPropertyHierarchyDescriptor create() {
        return new ObjectPropertyHierarchyDescriptor(Set.of(new OWLObjectPropertyImpl(OWLRDFVocabulary.OWL_TOP_OBJECT_PROPERTY.getIRI())));
    }
}
