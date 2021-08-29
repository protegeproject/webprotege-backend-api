
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
public class IssueUnassigned_TestCase {

    private IssueUnassignedEvent issueUnassigned;

    private UserId userId = new UserId("UserA");

    private final long timestamp = 1L;

    private UserId assignee = new UserId("UserB");

    private ProjectId projectId = ProjectId.generate();

    @Before
    public void setUp() {
        issueUnassigned = new IssueUnassignedEvent(projectId, userId, timestamp, assignee);
    }

    @SuppressWarnings("ConstantConditions")
    @Test(expected = NullPointerException.class)
    public void shouldThrowNullPointerExceptionIf_userId_IsNull() {
        new IssueUnassignedEvent(projectId, null, timestamp, assignee);
    }

    @Test
    public void shouldReturnSupplied_userId() {
        assertThat(issueUnassigned.userId(), is(this.userId));
    }

    @Test
    public void shouldReturnSupplied_timestamp() {
        assertThat(issueUnassigned.timestamp(), is(this.timestamp));
    }

    @SuppressWarnings("ConstantConditions")
    @Test(expected = NullPointerException.class)
    public void shouldThrowNullPointerExceptionIf_assignee_IsNull() {
        new IssueUnassignedEvent(projectId, userId, timestamp, null);
    }

    @Test
    public void shouldReturnSupplied_assignee() {
        assertThat(issueUnassigned.assignee(), is(this.assignee));
    }

    @Test
    public void shouldBeEqualToSelf() {
        assertThat(issueUnassigned, is(issueUnassigned));
    }

    @Test
    @SuppressWarnings("ObjectEqualsNull")
    public void shouldNotBeEqualToNull() {
        assertThat(issueUnassigned.equals(null), is(false));
    }

    @Test
    public void shouldBeEqualToOther() {
        assertThat(issueUnassigned, is(new IssueUnassignedEvent(projectId, userId, timestamp, assignee)));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_userId() {
        assertThat(issueUnassigned, is(not(new IssueUnassignedEvent(projectId, new UserId("OtherUser"), timestamp, assignee))));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_timestamp() {
        assertThat(issueUnassigned, is(not(new IssueUnassignedEvent(projectId, userId, 2L, assignee))));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_assignee() {
        assertThat(issueUnassigned, is(not(new IssueUnassignedEvent(projectId, userId, timestamp, new UserId("OtherUser")))));
    }

    @Test
    public void shouldBeEqualToOtherHashCode() {
        assertThat(issueUnassigned.hashCode(), is(new IssueUnassignedEvent(projectId, userId, timestamp, assignee).hashCode()));
    }

    @Test
    public void shouldImplementToString() {
        assertThat(issueUnassigned.toString(), startsWith("IssueUnassigned"));
    }
}
