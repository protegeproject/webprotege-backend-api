
package edu.stanford.protege.webprotege.issues.events;

import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.common.UserId;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(org.mockito.runners.MockitoJUnitRunner.class)
public class IssueClosed_TestCase {

    private IssueClosedEvent issueClosed;

    private UserId userId = new UserId("UserA");

    private final long timestamp = 1L;

    private ProjectId projectId = ProjectId.generate();

    @Before
    public void setUp() {
        issueClosed = new IssueClosedEvent(projectId, userId, timestamp);
    }

    @Test(expected = NullPointerException.class)
    public void shouldThrowNullPointerExceptionIf_userId_IsNull() {
        new IssueClosedEvent(projectId, null, timestamp);
    }

    @Test
    public void shouldBeEqualToSelf() {
        MatcherAssert.assertThat(issueClosed, Matchers.is(issueClosed));
    }

    @Test
    public void shouldNotBeEqualToNull() {
        MatcherAssert.assertThat(issueClosed.equals(null), Matchers.is(false));
    }

    @Test
    public void shouldBeEqualToOther() {
        MatcherAssert.assertThat(issueClosed, Matchers.is(new IssueClosedEvent(projectId, userId, timestamp)));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_userId() {
        MatcherAssert.assertThat(issueClosed, Matchers.is(Matchers.not(new IssueClosedEvent(projectId, new UserId("OtherUser"), timestamp))));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_timestamp() {
        MatcherAssert.assertThat(issueClosed, Matchers.is(Matchers.not(new IssueClosedEvent(projectId, userId, 2L))));
    }

    @Test
    public void shouldBeEqualToOtherHashCode() {
        MatcherAssert.assertThat(issueClosed.hashCode(), Matchers.is(new IssueClosedEvent(projectId, userId, timestamp).hashCode()));
    }

    @Test
    public void shouldImplementToString() {
        MatcherAssert.assertThat(issueClosed.toString(), Matchers.startsWith("IssueClosed"));
    }

}
