package edu.stanford.protege.webprotege.event;

import org.semanticweb.owlapi.model.OWLOntologyID;

import java.io.Serializable;
import java.util.Objects;
import java.util.Optional;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Author: Matthew Horridge<br>
 * Stanford University<br>
 * Bio-Medical Informatics Research Group<br>
 * Date: 18/12/2012
 */
public class OntologyBrowserTextChangedEvent extends WebProtegeEvent implements Serializable {

    private OWLOntologyID ontologyID;

    private String oldValue;

    private String newValue;

    /**
     * Constructs an OntologyBrowserTextChangedEvent.
     * @param ontologyID The id of the ontology whose browser text has changed.  Not {@code null}.
     * @param oldValue The old browser text.  Not {@code null}.  May be empty.
     * @param newValue The new browser text.  Not {@code null}.  May be empty.
     * @throws NullPointerException if any parameters are {@code null}.
     */
    public OntologyBrowserTextChangedEvent(OWLOntologyID ontologyID, String oldValue, String newValue) {
        checkNotNull(ontologyID);
        checkNotNull(oldValue);
        checkNotNull(newValue);
        this.ontologyID = ontologyID;
        this.oldValue = oldValue;
        this.newValue = newValue;
    }

    /**
     * Serialization purposes only
     */
    private OntologyBrowserTextChangedEvent() {

    }

    public OWLOntologyID getOntologyID() {
        return ontologyID;
    }

    public Optional<String> getOldValue() {
        return Optional.of(oldValue);
    }

    public Optional<String> getNewValue() {
        return Optional.of(newValue);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof OntologyBrowserTextChangedEvent)) {
            return false;
        }
        OntologyBrowserTextChangedEvent that = (OntologyBrowserTextChangedEvent) o;
        return Objects.equals(ontologyID, that.ontologyID) && Objects.equals(oldValue, that.oldValue) && Objects.equals(
                newValue,
                that.newValue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ontologyID, oldValue, newValue);
    }
}
