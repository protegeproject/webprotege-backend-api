
package edu.stanford.protege.webprotege.issues.events;

import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.issues.Milestone;
import edu.stanford.protege.webprotege.common.UserId;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class IssueDemilestoned_TestCase {

    private IssueDemilestonedEvent issueDemilestoned;
    private UserId userId = new UserId("UserA");
    private final long timestamp = 1L;
    @Mock
    private Milestone milestone;

    private ProjectId projectId = ProjectId.generate();

    @Before
    public void setUp() {
        issueDemilestoned = new IssueDemilestonedEvent(projectId, userId, timestamp, milestone);
    }

    @Test(expected = NullPointerException.class)
    public void shouldThrowNullPointerExceptionIf_userId_IsNull() {
        new IssueDemilestonedEvent(projectId, null, timestamp, milestone);
    }

    @Test(expected = NullPointerException.class)
    public void shouldThrowNullPointerExceptionIf_milestone_IsNull() {
        new IssueDemilestonedEvent(projectId, userId, timestamp, null);
    }

    @Test
    public void shouldReturnSupplied_milestone() {
        MatcherAssert.assertThat(issueDemilestoned.milestone(), Matchers.is(this.milestone));
    }

    @Test
    public void shouldBeEqualToSelf() {
        MatcherAssert.assertThat(issueDemilestoned, Matchers.is(issueDemilestoned));
    }

    @Test
    public void shouldNotBeEqualToNull() {
        MatcherAssert.assertThat(issueDemilestoned.equals(null), Matchers.is(false));
    }

    @Test
    public void shouldBeEqualToOther() {
        MatcherAssert.assertThat(issueDemilestoned, Matchers.is(new IssueDemilestonedEvent(projectId, userId, timestamp, milestone)));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_userId() {
        MatcherAssert.assertThat(issueDemilestoned, Matchers.is(Matchers.not(new IssueDemilestonedEvent(projectId, new UserId("OtherUser"), timestamp, milestone))));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_timestamp() {
        MatcherAssert.assertThat(issueDemilestoned, Matchers.is(Matchers.not(new IssueDemilestonedEvent(projectId, userId, 2L, milestone))));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_milestone() {
        MatcherAssert.assertThat(issueDemilestoned, Matchers.is(Matchers.not(new IssueDemilestonedEvent(projectId, userId, timestamp, Mockito
                .mock(Milestone.class)))));
    }

    @Test
    public void shouldBeEqualToOtherHashCode() {
        MatcherAssert.assertThat(issueDemilestoned.hashCode(), Matchers.is(new IssueDemilestonedEvent(projectId, userId, timestamp, milestone).hashCode()));
    }

    @Test
    public void shouldImplementToString() {
        MatcherAssert.assertThat(issueDemilestoned.toString(), Matchers.startsWith("IssueDemilestoned"));
    }

}
