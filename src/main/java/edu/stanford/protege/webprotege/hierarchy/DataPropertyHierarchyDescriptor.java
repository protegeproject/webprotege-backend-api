package edu.stanford.protege.webprotege.hierarchy;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import org.semanticweb.owlapi.model.OWLDataProperty;
import org.semanticweb.owlapi.vocab.OWLRDFVocabulary;
import uk.ac.manchester.cs.owl.owlapi.OWLDataPropertyImpl;
import uk.ac.manchester.cs.owl.owlapi.OWLObjectPropertyImpl;

import java.util.Set;

@JsonTypeName("DataPropertyHierarchyDescriptor")
public record DataPropertyHierarchyDescriptor(@JsonProperty("roots") Set<OWLDataProperty> roots) implements HierarchyDescriptor {

    public DataPropertyHierarchyDescriptor(Set<OWLDataProperty> roots) {
        this.roots = Set.copyOf(roots);
    }

    public static DataPropertyHierarchyDescriptor create() {
        return new DataPropertyHierarchyDescriptor(Set.of(new OWLDataPropertyImpl(OWLRDFVocabulary.OWL_TOP_DATA_PROPERTY.getIRI())));
    }
}
