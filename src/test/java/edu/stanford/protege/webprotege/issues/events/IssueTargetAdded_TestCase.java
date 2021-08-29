
package edu.stanford.protege.webprotege.issues.events;

import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.common.UserId;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.semanticweb.owlapi.model.OWLEntity;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@RunWith(MockitoJUnitRunner.class)
public class IssueTargetAdded_TestCase {

    private IssueTargetAddedEvent issueTargetAdded;

    private UserId userId = new UserId("UserA");

    private final long timestamp = 1L;

    @Mock
    private OWLEntity targetEntity;

    private ProjectId projectId = ProjectId.generate();

    @Before
    public void setUp()
            throws Exception {
        issueTargetAdded = new IssueTargetAddedEvent(projectId, userId, timestamp, targetEntity);
    }

    @SuppressWarnings("ConstantConditions" )
    @Test(expected = NullPointerException.class)
    public void shouldThrowNullPointerExceptionIf_userId_IsNull() {
        new IssueTargetAddedEvent(projectId, null, timestamp, targetEntity);
    }

    @Test
    public void shouldReturnSupplied_userId() {
        assertThat(issueTargetAdded.userId(), is(this.userId));
    }

    @Test
    public void shouldReturnSupplied_timestamp() {
        assertThat(issueTargetAdded.timestamp(), is(this.timestamp));
    }

    @SuppressWarnings("ConstantConditions" )
    @Test(expected = NullPointerException.class)
    public void shouldThrowNullPointerExceptionIf_targetEntity_IsNull() {
        new IssueTargetAddedEvent(projectId, userId, timestamp, null);
    }

    @Test
    public void shouldReturnSupplied_targetEntity() {
        assertThat(issueTargetAdded.targetEntity(), is(this.targetEntity));
    }

    @Test
    public void shouldBeEqualToSelf() {
        assertThat(issueTargetAdded, is(issueTargetAdded));
    }

    @Test
    @SuppressWarnings("ObjectEqualsNull" )
    public void shouldNotBeEqualToNull() {
        assertThat(issueTargetAdded.equals(null), is(false));
    }

    @Test
    public void shouldBeEqualToOther() {
        assertThat(issueTargetAdded, is(new IssueTargetAddedEvent(projectId, userId, timestamp, targetEntity)));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_userId() {
        assertThat(issueTargetAdded,
                   is(not(new IssueTargetAddedEvent(projectId, new UserId("OtherUser"), timestamp, targetEntity))));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_timestamp() {
        assertThat(issueTargetAdded, is(not(new IssueTargetAddedEvent(projectId, userId, 2L, targetEntity))));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_targetEntity() {
        assertThat(issueTargetAdded,
                   is(not(new IssueTargetAddedEvent(projectId, userId, timestamp, Mockito.mock(OWLEntity.class)))));
    }

    @Test
    public void shouldBeEqualToOtherHashCode() {
        assertThat(issueTargetAdded.hashCode(),
                   is(new IssueTargetAddedEvent(projectId, userId, timestamp, targetEntity).hashCode()));
    }

    @Test
    public void shouldImplementToString() {
        assertThat(issueTargetAdded.toString(), startsWith("IssueEntityTargetAdded" ));
    }

}
