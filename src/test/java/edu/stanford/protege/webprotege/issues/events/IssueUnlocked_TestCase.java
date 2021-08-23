
package edu.stanford.protege.webprotege.issues.events;

import edu.stanford.protege.webprotege.common.UserId;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class)
public class IssueUnlocked_TestCase {

    private IssueUnlocked issueUnlocked;

    private UserId userId = new UserId("UserA");

    private final long timestamp = 1L;

    @Before
    public void setUp() {
        issueUnlocked = new IssueUnlocked(userId, timestamp);
    }

    @SuppressWarnings("ConstantConditions")
    @Test(expected = NullPointerException.class)
    public void shouldThrowNullPointerExceptionIf_userId_IsNull() {
        new IssueUnlocked(null, timestamp);
    }

    @Test
    public void shouldReturnSupplied_userId() {
        assertThat(issueUnlocked.getUserId(), is(this.userId));
    }

    @Test
    public void shouldReturnSupplied_timestamp() {
        assertThat(issueUnlocked.getTimestamp(), is(this.timestamp));
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
        assertThat(issueUnlocked, is(new IssueUnlocked(userId, timestamp)));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_userId() {
        assertThat(issueUnlocked, is(not(new IssueUnlocked(new UserId("OtherUser"), timestamp))));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_timestamp() {
        assertThat(issueUnlocked, is(not(new IssueUnlocked(userId, 2L))));
    }

    @Test
    public void shouldBeEqualToOtherHashCode() {
        assertThat(issueUnlocked.hashCode(), is(new IssueUnlocked(userId, timestamp).hashCode()));
    }

    @Test
    public void shouldImplementToString() {
        assertThat(issueUnlocked.toString(), startsWith("IssueUnlocked"));
    }

}
