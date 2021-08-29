
package edu.stanford.protege.webprotege.issues.events;

import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.common.UserId;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@RunWith(MockitoJUnitRunner.class)
public class IssueSubscribed_TestCase {

    private IssueSubscribedEvent issueSubscribed;

    private UserId userId = new UserId("UserA");

    private final long timestamp = 1L;

    private UserId subscriber = new UserId("UserB");

    private ProjectId projectId = ProjectId.generate();

    @Before
    public void setUp() {
        issueSubscribed = new IssueSubscribedEvent(projectId, userId, timestamp, subscriber);
    }

    @SuppressWarnings("ConstantConditions")
    @Test(expected = NullPointerException.class)
    public void shouldThrowNullPointerExceptionIf_userId_IsNull() {
        new IssueSubscribedEvent(projectId, null, timestamp, subscriber);
    }

    @Test
    public void shouldReturnSupplied_userId() {
        assertThat(issueSubscribed.userId(), is(this.userId));
    }

    @Test
    public void shouldReturnSupplied_timestamp() {
        assertThat(issueSubscribed.timestamp(), is(this.timestamp));
    }

    @SuppressWarnings("ConstantConditions")
    @Test(expected = NullPointerException.class)
    public void shouldThrowNullPointerExceptionIf_subscriber_IsNull() {
        new IssueSubscribedEvent(projectId, userId, timestamp, null);
    }

    @Test
    public void shouldReturnSupplied_subscriber() {
        assertThat(issueSubscribed.subscriber(), is(this.subscriber));
    }

    @Test
    public void shouldBeEqualToSelf() {
        assertThat(issueSubscribed, is(issueSubscribed));
    }

    @Test
    @SuppressWarnings("ObjectEqualsNull")
    public void shouldNotBeEqualToNull() {
        assertThat(issueSubscribed.equals(null), is(false));
    }

    @Test
    public void shouldBeEqualToOther() {
        assertThat(issueSubscribed, is(new IssueSubscribedEvent(projectId, userId, timestamp, subscriber)));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_userId() {
        assertThat(issueSubscribed, is(not(new IssueSubscribedEvent(projectId, new UserId("OtherUser"), timestamp, subscriber))));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_timestamp() {
        assertThat(issueSubscribed, is(not(new IssueSubscribedEvent(projectId, userId, 2L, subscriber))));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_subscriber() {
        assertThat(issueSubscribed, is(not(new IssueSubscribedEvent(projectId, userId, timestamp, new UserId("OtherUser")))));
    }

    @Test
    public void shouldBeEqualToOtherHashCode() {
        assertThat(issueSubscribed.hashCode(), is(new IssueSubscribedEvent(projectId, userId, timestamp, subscriber).hashCode()));
    }

    @Test
    public void shouldImplementToString() {
        assertThat(issueSubscribed.toString(), startsWith("IssueSubscribed"));
    }

}
