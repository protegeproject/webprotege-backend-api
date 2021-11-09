
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
public class IssueTargetRemoved_TestCase {

    private IssueTargetRemovedEvent issueTargetRemoved;

    private UserId userId = new UserId("UserA");

    private final long timestamp = 1L;

    @Mock
    private OWLEntity entity;

    private ProjectId projectId = ProjectId.generate();

    @Before
    public void setUp()
            throws Exception {
        issueTargetRemoved = new IssueTargetRemovedEvent(projectId, userId, timestamp, entity);
    }

    @SuppressWarnings("ConstantConditions" )
    @Test(expected = NullPointerException.class)
    public void shouldThrowNullPointerExceptionIf_userId_IsNull() {
        new IssueTargetRemovedEvent(projectId, null, timestamp, entity);
    }

    @Test
    public void shouldReturnSupplied_userId() {
        assertThat(issueTargetRemoved.userId(), is(this.userId));
    }

    @Test
    public void shouldReturnSupplied_timestamp() {
        assertThat(issueTargetRemoved.timestamp(), is(this.timestamp));
    }

    @SuppressWarnings("ConstantConditions" )
    @Test(expected = NullPointerException.class)
    public void shouldThrowNullPointerExceptionIf_entity_IsNull() {
        new IssueTargetRemovedEvent(projectId, userId, timestamp, null);
    }

    @Test
    public void shouldReturnSupplied_entity() {
        assertThat(issueTargetRemoved.entity(), is(this.entity));
    }

    @Test
    public void shouldBeEqualToSelf() {
        assertThat(issueTargetRemoved, is(issueTargetRemoved));
    }

    @Test
    @SuppressWarnings("ObjectEqualsNull" )
    public void shouldNotBeEqualToNull() {
        assertThat(issueTargetRemoved.equals(null), is(false));
    }

    @Test
    public void shouldBeEqualToOther() {
        assertThat(issueTargetRemoved, is(new IssueTargetRemovedEvent(projectId, userId, timestamp, entity)));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_userId() {
        assertThat(issueTargetRemoved,
                   is(not(new IssueTargetRemovedEvent(projectId, new UserId("OtherUser"), timestamp, entity))));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_timestamp() {
        assertThat(issueTargetRemoved, is(not(new IssueTargetRemovedEvent(projectId, userId, 2L, entity))));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_entity() {
        assertThat(issueTargetRemoved,
                   is(not(new IssueTargetRemovedEvent(projectId, userId, timestamp, Mockito.mock(OWLEntity.class)))));
    }

    @Test
    public void shouldBeEqualToOtherHashCode() {
        assertThat(issueTargetRemoved.hashCode(),
                   is(new IssueTargetRemovedEvent(projectId, userId, timestamp, entity).hashCode()));
    }

    @Test
    public void shouldImplementToString() {
        assertThat(issueTargetRemoved.toString(), startsWith("IssueTargetRemoved" ));
    }

}
