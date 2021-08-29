
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
public class IssueUnlabelled_TestCase {

    private IssueUnlabelledEvent issueUnlabelled;
    private UserId userId = new UserId("UserA");
    private final long timestamp = 1L;
    private final String label = "The label";

    private ProjectId projectId = ProjectId.generate();

    @Before
    public void setUp()
    {
        issueUnlabelled = new IssueUnlabelledEvent(projectId, userId, timestamp, label);
    }

    @SuppressWarnings("ConstantConditions")
    @Test(expected = NullPointerException.class)
    public void shouldThrowNullPointerExceptionIf_userId_IsNull() {
        new IssueUnlabelledEvent(projectId, null, timestamp, label);
    }

    @Test
    public void shouldReturnSupplied_userId() {
        assertThat(issueUnlabelled.userId(), is(this.userId));
    }

    @Test
    public void shouldReturnSupplied_timestamp() {
        assertThat(issueUnlabelled.timestamp(), is(this.timestamp));
    }

    @SuppressWarnings("ConstantConditions")
    @Test(expected = NullPointerException.class)
    public void shouldThrowNullPointerExceptionIf_label_IsNull() {
        new IssueUnlabelledEvent(projectId, userId, timestamp, null);
    }

    @Test
    public void shouldReturnSupplied_label() {
        assertThat(issueUnlabelled.label(), is(this.label));
    }

    @Test
    public void shouldBeEqualToSelf() {
        assertThat(issueUnlabelled, is(issueUnlabelled));
    }

    @Test
    @SuppressWarnings("ObjectEqualsNull")
    public void shouldNotBeEqualToNull() {
        assertThat(issueUnlabelled.equals(null), is(false));
    }

    @Test
    public void shouldBeEqualToOther() {
        assertThat(issueUnlabelled, is(new IssueUnlabelledEvent(projectId, userId, timestamp, label)));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_userId() {
        assertThat(issueUnlabelled, is(not(new IssueUnlabelledEvent(projectId, new UserId("OtherUser"), timestamp, label))));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_timestamp() {
        assertThat(issueUnlabelled, is(not(new IssueUnlabelledEvent(projectId, userId, 2L, label))));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_label() {
        assertThat(issueUnlabelled, is(not(new IssueUnlabelledEvent(projectId, userId, timestamp, "String-65c6368f-d20c-42f1-bd84-3ae113d74ac1"))));
    }

    @Test
    public void shouldBeEqualToOtherHashCode() {
        assertThat(issueUnlabelled.hashCode(), is(new IssueUnlabelledEvent(projectId, userId, timestamp, label).hashCode()));
    }

    @Test
    public void shouldImplementToString() {
        assertThat(issueUnlabelled.toString(), startsWith("IssueUnlabelled"));
    }

}
