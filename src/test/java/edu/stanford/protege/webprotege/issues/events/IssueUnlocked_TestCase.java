
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
public class IssueUnlocked_TestCase {

    private IssueUnlockedEvent issueUnlocked;

    private UserId userId = new UserId("UserA");

    private final long timestamp = 1L;

    private ProjectId projectId = ProjectId.generate();

    @Before
    public void setUp() {
        issueUnlocked = new IssueUnlockedEvent(projectId, userId, timestamp);
    }

    @SuppressWarnings("ConstantConditions")
    @Test(expected = NullPointerException.class)
    public void shouldThrowNullPointerExceptionIf_userId_IsNull() {
        new IssueUnlockedEvent(projectId, null, timestamp);
    }

    @Test
    public void shouldReturnSupplied_userId() {
        assertThat(issueUnlocked.userId(), is(this.userId));
    }

    @Test
    public void shouldReturnSupplied_timestamp() {
        assertThat(issueUnlocked.timestamp(), is(this.timestamp));
    }

    @Test
    public void shouldBeEqualToSelf() {
        assertThat(issueUnlocked, is(issueUnlocked));
    }

    @Test
    @SuppressWarnings("ObjectEqualsNull")
    public void shouldNotBeEqualToNull() {
        assertThat(issueUnlocked.equals(null), is(false));
    }

    @Test
    public void shouldBeEqualToOther() {
        assertThat(issueUnlocked, is(new IssueUnlockedEvent(projectId, userId, timestamp)));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_userId() {
        assertThat(issueUnlocked, is(not(new IssueUnlockedEvent(projectId, new UserId("OtherUser"), timestamp))));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_timestamp() {
        assertThat(issueUnlocked, is(not(new IssueUnlockedEvent(projectId, userId, 2L))));
    }

    @Test
    public void shouldBeEqualToOtherHashCode() {
        assertThat(issueUnlocked.hashCode(), is(new IssueUnlockedEvent(projectId, userId, timestamp).hashCode()));
    }

    @Test
    public void shouldImplementToString() {
        assertThat(issueUnlocked.toString(), startsWith("IssueUnlocked"));
    }

}
