
package edu.stanford.protege.webprotege.change;

import edu.stanford.protege.webprotege.common.ChangeRequestId;
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
public class RevertRevisionAction_TestCase {

    private RevertRevisionAction revertRevisionAction;

    private ProjectId projectId = ProjectId.generate();

    private ChangeRequestId changeRequestId = ChangeRequestId.generate();

    @Mock
    private RevisionNumber revisionNumber;

    @Before
    public void setUp()
        throws Exception
    {
        revertRevisionAction = new RevertRevisionAction(changeRequestId, projectId, revisionNumber);
    }

    @Test
    public void shouldReturnSupplied_projectId() {
        MatcherAssert.assertThat(revertRevisionAction.projectId(), Matchers.is(this.projectId));
    }

    @Test
    public void shouldReturnSupplied_revisionNumber() {
        MatcherAssert.assertThat(revertRevisionAction.revisionNumber(), Matchers.is(this.revisionNumber));
    }

    @Test
    public void shouldBeEqualToSelf() {
        MatcherAssert.assertThat(revertRevisionAction, Matchers.is(revertRevisionAction));
    }

    @Test
    public void shouldNotBeEqualToNull() {
        MatcherAssert.assertThat(revertRevisionAction.equals(null), Matchers.is(false));
    }

    @Test
    public void shouldBeEqualToOther() {
        MatcherAssert.assertThat(revertRevisionAction, Matchers.is(new RevertRevisionAction(changeRequestId, projectId, revisionNumber)));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_projectId() {
        MatcherAssert.assertThat(revertRevisionAction, Matchers.is(Matchers.not(new RevertRevisionAction(changeRequestId, ProjectId.generate(), revisionNumber))));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_revisionNumber() {
        MatcherAssert.assertThat(revertRevisionAction, Matchers.is(Matchers.not(new RevertRevisionAction(changeRequestId, projectId, Mockito.mock(RevisionNumber.class)))));
    }

    @Test
    public void shouldBeEqualToOtherHashCode() {
        MatcherAssert.assertThat(revertRevisionAction.hashCode(), Matchers.is(new RevertRevisionAction(changeRequestId, projectId, revisionNumber)
                                                                                                  .hashCode()));
    }

    @Test
    public void shouldImplementToString() {
        MatcherAssert.assertThat(revertRevisionAction.toString(), Matchers.startsWith("RevertRevisionAction"));
    }


}
