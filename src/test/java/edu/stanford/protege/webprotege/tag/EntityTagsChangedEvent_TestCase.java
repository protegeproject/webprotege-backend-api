
package edu.stanford.protege.webprotege.tag;

import edu.stanford.protege.webprotege.common.EventId;
import edu.stanford.protege.webprotege.common.ProjectId;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.semanticweb.owlapi.model.OWLEntity;

import java.util.Collection;
import java.util.Collections;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class)
public class EntityTagsChangedEvent_TestCase {

    private EntityTagsChangedEvent event;

    private ProjectId projectId = ProjectId.generate();

    @Mock
    private OWLEntity entity;

    @Mock
    private Collection<Tag> tags;

    private EventId eventId = EventId.generate();

    @Before
    public void setUp() {
        tags = Collections.singleton(mock(Tag.class));
        event = new EntityTagsChangedEvent(eventId, projectId, entity, tags);
    }

    @SuppressWarnings("ConstantConditions")
    @Test(expected = NullPointerException.class)
    public void shouldThrowNullPointerExceptionIf_projectId_IsNull() {
        new EntityTagsChangedEvent(eventId, null, entity, tags);
    }

    @Test
    public void shouldReturnSupplied_projectId() {
        assertThat(event.projectId(), is(this.projectId));
    }

    @SuppressWarnings("ConstantConditions")
    @Test(expected = NullPointerException.class)
    public void shouldThrowNullPointerExceptionIf_entity_IsNull() {
        new EntityTagsChangedEvent(eventId, projectId, null, tags);
    }

    @Test
    public void shouldReturnSupplied_entity() {
        assertThat(event.entity(), is(this.entity));
    }

    @SuppressWarnings("ConstantConditions")
    @Test(expected = NullPointerException.class)
    public void shouldThrowNullPointerExceptionIf_tags_IsNull() {
        new EntityTagsChangedEvent(eventId, projectId, entity, null);
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
