package edu.stanford.protege.webprotege.event;

import edu.stanford.protege.webprotege.common.EventId;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.permissions.PermissionsChangedEvent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class PermissionsChangedEvent_TestCase {

    private final ProjectId source = ProjectId.generate();

    private final EventId eventId = EventId.generate();

    private PermissionsChangedEvent permissionsChangedEvent;

    @BeforeEach
    public void setUp() {
        permissionsChangedEvent = new PermissionsChangedEvent(eventId, source);
    }

    @SuppressWarnings("ConstantConditions")
    public void shouldThrowNullPointerExceptionIf_source_IsNull() {
        assertThrows(NullPointerException.class, () -> {
            new PermissionsChangedEvent(eventId, null);
        });
    }

    @Test
    public void shouldReturnSupplied_source() {
        assertThat(permissionsChangedEvent.projectId(), is(this.source));
    }

    @Test
    public void shouldBeEqualToSelf() {
        assertThat(permissionsChangedEvent, is(permissionsChangedEvent));
    }

    @Test
    @SuppressWarnings("ObjectEqualsNull")
    public void shouldNotBeEqualToNull() {
        assertThat(permissionsChangedEvent.equals(null), is(false));
    }

    @Test
    public void shouldBeEqualToOther() {
        assertThat(permissionsChangedEvent, is(new PermissionsChangedEvent(eventId, source)));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_source() {
        assertThat(permissionsChangedEvent, is(not(new PermissionsChangedEvent(eventId, ProjectId.generate()))));
    }

    @Test
    public void shouldBeEqualToOtherHashCode() {
        assertThat(permissionsChangedEvent.hashCode(), is(new PermissionsChangedEvent(eventId, source).hashCode()));
    }

    @Test
    public void shouldImplementToString() {
        assertThat(permissionsChangedEvent.toString(), startsWith("PermissionsChangedEvent"));
    }
}
