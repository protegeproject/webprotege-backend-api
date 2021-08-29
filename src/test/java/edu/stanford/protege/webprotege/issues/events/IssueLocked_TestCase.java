
package edu.stanford.protege.webprotege.issues.events;

import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.common.UserId;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class)
public class IssueLocked_TestCase {

    private IssueLockedEvent issueLocked;

    private UserId userId = new UserId("UserA");

    private final long timestamp = 1L;

    private ProjectId projectId = ProjectId.generate();

    @Before
    public void setUp() {
        issueLocked = new IssueLockedEvent(projectId, userId, timestamp);
    }

    @SuppressWarnings("ConstantConditions")
    @Test(expected = NullPointerException.class)
    public void shouldThrowNullPointerExceptionIf_userId_IsNull() {
        new IssueLockedEvent(projectId, null, timestamp);
    }

    @Test
    public void shouldReturnSupplied_userId() {
        assertThat(issueLocked.userId(), is(this.userId));
    }

    @Test
    public void shouldReturnSupplied_timestamp() {
        assertThat(issueLocked.timestamp(), is(this.timestamp));
    }

    @Test
    public void shouldBeEqualToSelf() {
        assertThat(issueLocked, is(issueLocked));
    }

    @Test
    @SuppressWarnings("ObjectEqualsNull")
    public void shouldNotBeEqualToNull() {
        assertThat(issueLocked.equals(null), is(false));
    }

    @Test
    public void shouldBeEqualToOther() {
        assertThat(issueLocked, is(new IssueLockedEvent(projectId, userId, timestamp)));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_userId() {
        assertThat(issueLocked, is(not(new IssueLockedEvent(projectId, new UserId("OtherUser"), timestamp))));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_timestamp() {
        assertThat(issueLocked, is(not(new IssueLockedEvent(projectId, userId, 2L))));
    }

    @Test
    public void shouldBeEqualToOtherHashCode() {
        assertThat(issueLocked.hashCode(), is(new IssueLockedEvent(projectId, userId, timestamp).hashCode()));
    }

    @Test
    public void shouldImplementToString() {
        assertThat(issueLocked.toString(), startsWith("IssueLocked"));
    }

}
