
package edu.stanford.protege.webprotege.event;

import edu.stanford.protege.webprotege.common.EventId;
import edu.stanford.protege.webprotege.permissions.PermissionsChangedEvent;
import edu.stanford.protege.webprotege.common.ProjectId;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class)
public class PermissionsChangedEvent_TestCase {

    private PermissionsChangedEvent permissionsChangedEvent;

    private ProjectId source = ProjectId.generate();

    private EventId eventId = EventId.generate();

    @Before
    public void setUp() {
        permissionsChangedEvent = new PermissionsChangedEvent(eventId, source);
    }

    @SuppressWarnings("ConstantConditions")
    @Test(expected = NullPointerException.class)
    public void shouldThrowNullPointerExceptionIf_source_IsNull() {
        new PermissionsChangedEvent(eventId, null);
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
