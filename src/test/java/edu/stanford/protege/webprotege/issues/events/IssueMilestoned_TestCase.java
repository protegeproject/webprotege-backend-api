
package edu.stanford.protege.webprotege.issues.events;

import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.issues.Milestone;
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
public class IssueMilestoned_TestCase {

    private IssueMilestonedEvent issueMilestoned;

    private UserId userId = new UserId("UserA");

    private final long timestamp = 1L;

    @Mock
    private Milestone milestone;

    private ProjectId projectId = ProjectId.generate();

    @Before
    public void setUp() {
        issueMilestoned = new IssueMilestonedEvent(projectId, userId, timestamp, milestone);
    }

    @Test(expected = NullPointerException.class)
    public void shouldThrowNullPointerExceptionIf_userId_IsNull() {
        new IssueMilestonedEvent(projectId, null, timestamp, milestone);
    }

    @Test(expected = NullPointerException.class)
    public void shouldThrowNullPointerExceptionIf_milestone_IsNull() {
        new IssueMilestonedEvent(projectId, userId, timestamp, null);
    }

    @Test
    public void shouldReturnSupplied_milestone() {
        assertThat(issueMilestoned.milestone(), is(this.milestone));
    }

    @Test
    public void shouldBeEqualToSelf() {
        assertThat(issueMilestoned, is(issueMilestoned));
    }

    @Test
    public void shouldNotBeEqualToNull() {
        assertThat(issueMilestoned.equals(null), is(false));
    }

    @Test
    public void shouldBeEqualToOther() {
        assertThat(issueMilestoned, is(new IssueMilestonedEvent(projectId, userId, timestamp, milestone)));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_userId() {
        assertThat(issueMilestoned, is(not(new IssueMilestonedEvent(projectId, new UserId("OtherUser"), timestamp, milestone))));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_timestamp() {
        assertThat(issueMilestoned, is(not(new IssueMilestonedEvent(projectId, userId, 2L, milestone))));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_milestone() {
        assertThat(issueMilestoned, is(not(new IssueMilestonedEvent(projectId, userId, timestamp, mock(Milestone.class)))));
    }

    @Test
    public void shouldBeEqualToOtherHashCode() {
        assertThat(issueMilestoned.hashCode(), is(new IssueMilestonedEvent(projectId, userId, timestamp, milestone).hashCode()));
    }

    @Test
    public void shouldImplementToString() {
        assertThat(issueMilestoned.toString(), startsWith("IssueMilestoned"));
    }

}
