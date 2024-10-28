package edu.stanford.protege.webprotege.hierarchy;


import com.google.common.collect.ImmutableList;
import edu.stanford.protege.webprotege.common.EventId;
import edu.stanford.protege.webprotege.common.ProjectId;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.json.JsonContent;
import org.springframework.boot.test.json.ObjectContent;

import static org.assertj.core.api.Assertions.assertThat;

import org.semanticweb.owlapi.vocab.OWLRDFVocabulary;
import uk.ac.manchester.cs.owl.owlapi.OWLClassImpl;
import org.semanticweb.owlapi.model.OWLClass;

import java.util.Set;

@JsonTest
public class EntityHierarchyChangedEventJsonTest {

    public static final String PROJECT_ID = "00000000-1111-2222-3333-444444444444";

    public static final String EVENT_ID = "event-id";
    @Autowired
    private JacksonTester<EntityHierarchyChangedEvent> jacksonTester;

    @Test
    void testSerializeEntityHierarchyChangedEvent() throws Exception {
        // Create sample objects
        var eventId = new EventId(EVENT_ID);
        var projectId = new ProjectId(PROJECT_ID);

        // Sample HierarchyDescriptor (using ClassHierarchyDescriptor as an example)
        OWLClass owlClass = new OWLClassImpl(OWLRDFVocabulary.OWL_THING.getIRI());
        HierarchyDescriptor hierarchyDescriptor = new ClassHierarchyDescriptor(Set.of(owlClass));

        // Sample GraphModelChangedEvent (you need to provide a concrete instance of this class)
        var changeEvent = GraphModelChangedEvent.create(ImmutableList.of(new AddEdge<>(new GraphEdge<>(new GraphNode<>("A"), new GraphNode<>("B")))));

        // Create an EntityHierarchyChangedEvent instance
        EntityHierarchyChangedEvent event = new EntityHierarchyChangedEvent(eventId, projectId, hierarchyDescriptor, changeEvent);

        // Serialize to JSON
        JsonContent<EntityHierarchyChangedEvent> json = jacksonTester.write(event);

        // Assert the JSON structure and values
        assertThat(json).extractingJsonPathStringValue("$.eventId").isEqualTo(EVENT_ID);
        assertThat(json).extractingJsonPathStringValue("$.projectId").isEqualTo(PROJECT_ID);

        // Check hierarchyDescriptor and changeEvent fields
        assertThat(json).hasJsonPathMapValue("$.hierarchyDescriptor");
        assertThat(json).hasJsonPathMapValue("$.changeEvent");

        // Check the channel
        assertThat(json).extractingJsonPathStringValue("$.['@type']").isEqualTo(EntityHierarchyChangedEvent.CHANNEL);
    }

    @Test
    void testDeserializeEntityHierarchyChangedEvent() throws Exception {
        // Example JSON
        String json = """
        {
        
            "@type": "webprotege.events.hierarchies.EntityHierarchyChanged",
            "eventId": "event-id",
            "projectId": "00000000-1111-2222-3333-444444444444",
            "hierarchyDescriptor": {
                "@type": "ClassHierarchyDescriptor",
                "roots": [
                    {
                        "iri": "http://www.w3.org/2002/07/owl#Thing"
                    }
                ]
            },
            "changeEvent": {
                "changes" : []
            }
        }
        """;

        // Deserialize from JSON
        ObjectContent<EntityHierarchyChangedEvent> objectContent = jacksonTester.parse(json);

        // Get the result
        EntityHierarchyChangedEvent event = objectContent.getObject();

        // Assert deserialized object
        assertThat(event).isNotNull();
        assertThat(event.eventId().id()).isEqualTo(EVENT_ID);
        assertThat(event.projectId().id()).isEqualTo(PROJECT_ID);

        // Assert HierarchyDescriptor
        assertThat(event.hierarchyDescriptor()).isInstanceOf(ClassHierarchyDescriptor.class);

        // Assert changeEvent
        assertThat(event.changeEvent().getChanges()).isEmpty();

        // Assert the channel
        assertThat(event.getChannel()).isEqualTo(EntityHierarchyChangedEvent.CHANNEL);
    }
}
