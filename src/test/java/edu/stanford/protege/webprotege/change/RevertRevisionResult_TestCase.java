
package edu.stanford.protege.webprotege.change;

import edu.stanford.protege.webprotege.event.EventList;
import edu.stanford.protege.webprotege.event.ProjectEvent;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.revision.RevisionNumber;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;

@RunWith(org.mockito.runners.MockitoJUnitRunner.class)
public class RevertRevisionResult_TestCase {

    private RevertRevisionResult revertRevisionResult;

    private ProjectId projectId = ProjectId.generate();

    @Mock
    private EventList<ProjectEvent> eventList;

    @Mock
    private RevisionNumber revisionNumber;

    @Before
    public void setUp() {
        revertRevisionResult = new RevertRevisionResult(projectId, revisionNumber, eventList);
    }

    @Test(expected = java.lang.NullPointerException.class)
    public void shouldThrowNullPointerExceptionIf_projectId_IsNull() {
        new RevertRevisionResult(null, revisionNumber, eventList);
    }

    @Test
    public void shouldReturnSupplied_projectId() {
        MatcherAssert.assertThat(revertRevisionResult.projectId(), Matchers.is(this.projectId));
    }

    @Test(expected = java.lang.NullPointerException.class)
    public void shouldThrowNullPointerExceptionIf_eventList_IsNull() {
        new RevertRevisionResult(projectId, revisionNumber, null);
    }

    @Test
    public void shouldReturnSupplied_eventList() {
        MatcherAssert.assertThat(revertRevisionResult.eventList(), Matchers.is(this.eventList));
    }

    @Test
    public void shouldBeEqualToSelf() {
        MatcherAssert.assertThat(revertRevisionResult, Matchers.is(revertRevisionResult));
    }

    @Test
    public void shouldNotBeEqualToNull() {
        MatcherAssert.assertThat(revertRevisionResult.equals(null), Matchers.is(false));
    }

    @Test
    public void shouldBeEqualToOther() {
        MatcherAssert.assertThat(revertRevisionResult, Matchers.is(new RevertRevisionResult(projectId, revisionNumber, eventList)));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_projectId() {
        MatcherAssert.assertThat(revertRevisionResult, Matchers.is(Matchers.not(new RevertRevisionResult(ProjectId.generate(), revisionNumber, eventList))));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_eventList() {
        MatcherAssert.assertThat(revertRevisionResult, Matchers.is(Matchers.not(new RevertRevisionResult(projectId, revisionNumber, Mockito.mock(EventList.class)))));
    }

    @Test
    public void shouldBeEqualToOtherHashCode() {
        MatcherAssert.assertThat(revertRevisionResult.hashCode(), Matchers.is(new RevertRevisionResult(projectId, revisionNumber, eventList).hashCode()));
    }

    @Test
    public void shouldImplementToString() {
        MatcherAssert.assertThat(revertRevisionResult.toString(), Matchers.startsWith("RevertRevisionResult"));
    }
}
