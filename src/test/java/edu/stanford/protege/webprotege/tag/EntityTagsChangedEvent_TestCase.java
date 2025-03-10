package edu.stanford.protege.webprotege.tag;

import edu.stanford.protege.webprotege.common.EventId;
import edu.stanford.protege.webprotege.common.ProjectId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.semanticweb.owlapi.model.OWLEntity;

import java.util.Collection;
import java.util.Collections;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
public class EntityTagsChangedEvent_TestCase {

    private final ProjectId projectId = ProjectId.generate();

    private final EventId eventId = EventId.generate();

    private EntityTagsChangedEvent event;

    @Mock
    private OWLEntity entity;

    @Mock
    private Collection<Tag> tags;

    @BeforeEach
    public void setUp() {
        tags = Collections.singleton(mock(Tag.class));
        event = new EntityTagsChangedEvent(eventId, projectId, entity, tags);
    }

    @SuppressWarnings("ConstantConditions")
    public void shouldThrowNullPointerExceptionIf_projectId_IsNull() {
        assertThrows(NullPointerException.class, () -> {
            new EntityTagsChangedEvent(eventId, null, entity, tags);
        });
    }

    @Test
    public void shouldReturnSupplied_projectId() {
        assertThat(event.projectId(), is(this.projectId));
    }

    @SuppressWarnings("ConstantConditions")
    public void shouldThrowNullPointerExceptionIf_entity_IsNull() {
        assertThrows(NullPointerException.class, () -> {
            new EntityTagsChangedEvent(eventId, projectId, null, tags);
        });
    }

    @Test
    public void shouldReturnSupplied_entity() {
        assertThat(event.entity(), is(this.entity));
    }

    @SuppressWarnings("ConstantConditions")
    public void shouldThrowNullPointerExceptionIf_tags_IsNull() {
        assertThrows(NullPointerException.class, () -> {
            new EntityTagsChangedEvent(eventId, projectId, entity, null);
        });
    }

    @Test
    public void shouldReturnSupplied_tags() {
        assertThat(event.tags(), is(this.tags));
    }

    @Test
    public void shouldBeEqualToSelf() {
        assertThat(event, is(event));
    }

    @Test
    @SuppressWarnings("ObjectEqualsNull")
    public void shouldNotBeEqualToNull() {
        assertThat(event.equals(null), is(false));
    }

    @Test
    public void shouldBeEqualToOther() {
        assertThat(event, is(new EntityTagsChangedEvent(eventId, projectId, entity, tags)));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_projectId() {
        assertThat(event, is(not(new EntityTagsChangedEvent(eventId, ProjectId.generate(), entity, tags))));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_entity() {
        assertThat(event, is(not(new EntityTagsChangedEvent(eventId, projectId, mock(OWLEntity.class), tags))));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_tags() {
        assertThat(event, is(not(new EntityTagsChangedEvent(eventId, projectId, entity, Collections.singleton(mock(Tag.class))))));
    }

    @Test
    public void shouldBeEqualToOtherHashCode() {
        assertThat(event.hashCode(), is(new EntityTagsChangedEvent(eventId, projectId, entity, tags).hashCode()));
    }

    @Test
    public void shouldImplementToString() {
        assertThat(event.toString(), startsWith("EntityTagsChangedEvent"));
    }
}
