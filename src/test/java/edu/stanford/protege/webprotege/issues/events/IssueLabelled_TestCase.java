
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
public class IssueLabelled_TestCase {

    private IssueLabelledEvent issueLabelled;

    private UserId userId = new UserId("UserA");

    private final long timestamp = 1L;

    private final String label = "The label";

    private ProjectId projectId = ProjectId.generate();

    @Before
    public void setUp() {
        issueLabelled = new IssueLabelledEvent(projectId, userId, timestamp, label);
    }

    @Test(expected = NullPointerException.class)
    public void shouldThrowNullPointerExceptionIf_userId_IsNull() {
        new IssueLabelledEvent(projectId, null, timestamp, label);
    }

    @Test(expected = NullPointerException.class)
    public void shouldThrowNullPointerExceptionIf_label_IsNull() {
        new IssueLabelledEvent(projectId, userId, timestamp, null);
    }

    @Test
    public void shouldReturnSupplied_label() {
        assertThat(issueLabelled.label(), is(this.label));
    }

    @Test
    public void shouldBeEqualToSelf() {
        assertThat(issueLabelled, is(issueLabelled));
    }

    @Test
    public void shouldNotBeEqualToNull() {
        assertThat(issueLabelled.equals(null), is(false));
    }

    @Test
    public void shouldBeEqualToOther() {
        assertThat(issueLabelled, is(new IssueLabelledEvent(projectId, userId, timestamp, label)));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_userId() {
        assertThat(issueLabelled, is(not(new IssueLabelledEvent(projectId, new UserId("OtherUser"), timestamp, label))));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_timestamp() {
        assertThat(issueLabelled, is(not(new IssueLabelledEvent(projectId, userId, 2L, label))));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_label() {
        assertThat(issueLabelled, is(not(new IssueLabelledEvent(projectId, userId, timestamp, "String-727db00a-257f-4e33-aba5-8290d93a2dc8"))));
    }

    @Test
    public void shouldBeEqualToOtherHashCode() {
        assertThat(issueLabelled.hashCode(), is(new IssueLabelledEvent(projectId, userId, timestamp, label).hashCode()));
    }

    @Test
    public void shouldImplementToString() {
        assertThat(issueLabelled.toString(), startsWith("IssueLabelled"));
    }

}
