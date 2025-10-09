package edu.stanford.protege.webprotege.hierarchy;

import com.google.common.collect.ImmutableList;
import edu.stanford.protege.webprotege.common.ChangeRequestId;
import edu.stanford.protege.webprotege.common.EventId;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.jackson.WebProtegeJacksonApplication;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.context.annotation.Import;

import java.io.IOException;
import java.io.StringReader;

import static org.assertj.core.api.Assertions.assertThat;

@JsonTest
@Import(WebProtegeJacksonApplication.class)
class EntityHierarchyChangedEventTest {

    @Autowired
    private JacksonTester<EntityHierarchyChangedEvent> tester;

    @BeforeEach
    void setUp() throws IOException {

    }

    @Test
    void shouldSerializeToJson() throws IOException {
        var event = new EntityHierarchyChangedEvent(EventId.generate(),
                ProjectId.generate(),
                ClassHierarchyDescriptor.create(),
                GraphModelChangedEvent.create(ImmutableList.of()),
                ChangeRequestId.generate());
        var json = tester.write(event);
        assertThat(json).hasJsonPathStringValue("projectId");
        assertThat(json).hasJsonPathStringValue("changeRequestId");
        assertThat(json).hasJsonPathStringValue("eventId");
        assertThat(json).hasJsonPathMapValue("hierarchyDescriptor");
    }

    @Test
    void shouldDeserializeFromJson() throws IOException {
        var json = """
                {"@type":"webprotege.events.hierarchies.EntityHierarchyChanged","eventId":"08adfb16-60cf-49f9-b82b-689302d11e91","projectId":"bd6b3b60-735c-42ee-8aa9-df6fcca6b0ee","changeRequestId":"30776dce-44a0-4a4e-98c5-022f70ca34b8","hierarchyDescriptor":{"@type":"ClassHierarchyDescriptor","roots":[{"@type":"Class","iri":"http://www.w3.org/2002/07/owl#Thing"}]},"changeEvent":{"changes":[]}}
                """;
        var obj = tester.read(new StringReader(json));
        var event = obj.getObject();
        assertThat(event.eventId().id()).isEqualTo("08adfb16-60cf-49f9-b82b-689302d11e91");
        assertThat(event.projectId().id()).isEqualTo("bd6b3b60-735c-42ee-8aa9-df6fcca6b0ee");
        assertThat(event.changeRequestId().id()).isEqualTo("30776dce-44a0-4a4e-98c5-022f70ca34b8");
        assertThat(event.hierarchyDescriptor()).isNotNull();
    }
}