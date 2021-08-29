
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
public class IssueReopened_TestCase {

    private IssueReopenedEvent issueReopened;

    private UserId userId = new UserId("UserA");

    private final long timestamp = 1L;

    private ProjectId projectId = ProjectId.generate();

    @Before
    public void setUp() {
        issueReopened = new IssueReopenedEvent(projectId, userId, timestamp);
    }

    @SuppressWarnings("ConstantConditions")
    @Test(expected = NullPointerException.class)
    public void shouldThrowNullPointerExceptionIf_userId_IsNull() {
        new IssueReopenedEvent(projectId, null, timestamp);
    }

    @Test
    public void shouldReturnSupplied_userId() {
        assertThat(issueReopened.userId(), is(this.userId));
    }

    @Test
    public void shouldReturnSupplied_timestamp() {
        assertThat(issueReopened.timestamp(), is(this.timestamp));
    }

    @Test
    public void shouldBeEqualToSelf() {
        assertThat(issueReopened, is(issueReopened));
    }

    @Test
    @SuppressWarnings("ObjectEqualsNull")
    public void shouldNotBeEqualToNull() {
        assertThat(issueReopened.equals(null), is(false));
    }

    @Test
    public void shouldBeEqualToOther() {
        assertThat(issueReopened, is(new IssueReopenedEvent(projectId, userId, timestamp)));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_userId() {
        assertThat(issueReopened, is(not(new IssueReopenedEvent(projectId, new UserId("OtherUser"), timestamp))));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_timestamp() {
        assertThat(issueReopened, is(not(new IssueReopenedEvent(projectId, userId, 2L))));
    }

    @Test
    public void shouldBeEqualToOtherHashCode() {
        assertThat(issueReopened.hashCode(), is(new IssueReopenedEvent(projectId, userId, timestamp).hashCode()));
    }

    @Test
    public void shouldImplementToString() {
        assertThat(issueReopened.toString(), startsWith("IssueReopened"));
    }

}
