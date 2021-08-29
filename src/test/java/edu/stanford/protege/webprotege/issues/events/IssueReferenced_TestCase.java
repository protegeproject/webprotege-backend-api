
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
public class IssueReferenced_TestCase {

    private IssueReferencedEvent issueReferenced;

    private UserId userId = new UserId("UserA");

    private final long timestamp = 1L;

    private final int issueNumber = 1;

    private final int referencedByIssueNumber = 2;

    private ProjectId projectId = ProjectId.generate();

    @Before
    public void setUp()
            throws Exception {
        issueReferenced = new IssueReferencedEvent(projectId, userId, timestamp, issueNumber, referencedByIssueNumber);
    }

    @SuppressWarnings("ConstantConditions")
    @Test(expected = java.lang.NullPointerException.class)
    public void shouldThrowNullPointerExceptionIf_userId_IsNull() {
        new IssueReferencedEvent(projectId, null, timestamp, issueNumber, referencedByIssueNumber);
    }

    @Test
    public void shouldReturnSupplied_userId() {
        assertThat(issueReferenced.userId(), is(this.userId));
    }

    @Test
    public void shouldReturnSupplied_timestamp() {
        assertThat(issueReferenced.timestamp(), is(this.timestamp));
    }

    @Test
    public void shouldReturnSupplied_issueNumber() {
        assertThat(issueReferenced.issueNumber(), is(this.issueNumber));
    }

    @Test
    public void shouldReturnSupplied_referencedByIssueNumber() {
        assertThat(issueReferenced.referencedByIssueNumber(), is(this.referencedByIssueNumber));
    }

    @Test
    public void shouldBeEqualToSelf() {
        assertThat(issueReferenced, is(issueReferenced));
    }

    @Test
    @SuppressWarnings("ObjectEqualsNull")
    public void shouldNotBeEqualToNull() {
        assertThat(issueReferenced.equals(null), is(false));
    }

    @Test
    public void shouldBeEqualToOther() {
        assertThat(issueReferenced, is(new IssueReferencedEvent(projectId, userId, timestamp, issueNumber, referencedByIssueNumber)));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_userId() {
        assertThat(issueReferenced, is(not(new IssueReferencedEvent(projectId, new UserId("OtherUser"), timestamp, issueNumber, referencedByIssueNumber))));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_timestamp() {
        assertThat(issueReferenced, is(not(new IssueReferencedEvent(projectId, userId, 2L, issueNumber, referencedByIssueNumber))));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_issueNumber() {
        assertThat(issueReferenced, is(not(new IssueReferencedEvent(projectId, userId, timestamp, 3, referencedByIssueNumber))));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_referencedByIssueNumber() {
        assertThat(issueReferenced, is(not(new IssueReferencedEvent(projectId, userId, timestamp, issueNumber, 4))));
    }

    @Test
    public void shouldBeEqualToOtherHashCode() {
        assertThat(issueReferenced.hashCode(), is(new IssueReferencedEvent(projectId, userId, timestamp, issueNumber, referencedByIssueNumber).hashCode()));
    }

    @Test
    public void shouldImplementToString() {
        assertThat(issueReferenced.toString(), startsWith("IssueReferenced"));
    }

}
