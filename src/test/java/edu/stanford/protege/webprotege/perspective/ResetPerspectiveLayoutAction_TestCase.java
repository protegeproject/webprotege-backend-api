
package edu.stanford.protege.webprotege.perspective;

import edu.stanford.protege.webprotege.common.ChangeRequestId;
import edu.stanford.protege.webprotege.common.ProjectId;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class)
public class ResetPerspectiveLayoutAction_TestCase {

    private ResetPerspectiveLayoutAction resetPerspectiveLayoutAction;
    private ProjectId projectId = ProjectId.generate();
    @Mock
    private PerspectiveId perspectiveId;

    private ChangeRequestId changeRequestId = ChangeRequestId.generate();

    @Before
    public void setUp()
        throws Exception
    {
        resetPerspectiveLayoutAction = new ResetPerspectiveLayoutAction(changeRequestId, projectId, perspectiveId);
    }

    @SuppressWarnings("ConstantConditions")
    @Test(expected = NullPointerException.class)
    public void shouldThrowNullPointerExceptionIf_projectId_IsNull() {
        new ResetPerspectiveLayoutAction(changeRequestId, null, perspectiveId);
    }

    @Test
    public void shouldReturnSupplied_projectId() {
        assertThat(resetPerspectiveLayoutAction.projectId(), is(this.projectId));
    }

    @SuppressWarnings("ConstantConditions")
    @Test(expected = NullPointerException.class)
    public void shouldThrowNullPointerExceptionIf_perspectiveId_IsNull() {
        new ResetPerspectiveLayoutAction(changeRequestId, projectId, null);
    }

    @Test
    public void shouldReturnSupplied_perspectiveId() {
        assertThat(resetPerspectiveLayoutAction.perspectiveId(), is(this.perspectiveId));
    }

    @Test
    public void shouldBeEqualToSelf() {
        assertThat(resetPerspectiveLayoutAction, is(resetPerspectiveLayoutAction));
    }

    @Test
    @SuppressWarnings("ObjectEqualsNull")
    public void shouldNotBeEqualToNull() {
        assertThat(resetPerspectiveLayoutAction.equals(null), is(false));
    }

    @Test
    public void shouldBeEqualToOther() {
        assertThat(resetPerspectiveLayoutAction, is(new ResetPerspectiveLayoutAction(changeRequestId,
                                                                                     projectId, perspectiveId)));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_projectId() {
        assertThat(resetPerspectiveLayoutAction, is(not(new ResetPerspectiveLayoutAction(changeRequestId,
                                                                                         ProjectId.generate(), perspectiveId))));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_perspectiveId() {
        assertThat(resetPerspectiveLayoutAction, is(not(new ResetPerspectiveLayoutAction(changeRequestId,
                                                                                         projectId, mock(PerspectiveId.class)))));
    }

    @Test
    public void shouldBeEqualToOtherHashCode() {
        assertThat(resetPerspectiveLayoutAction.hashCode(), is(new ResetPerspectiveLayoutAction(changeRequestId,
                                                                                                projectId, perspectiveId)
                                                                                           .hashCode()));
    }

    @Test
    public void shouldImplementToString() {
        assertThat(resetPerspectiveLayoutAction.toString(), Matchers.startsWith("ResetPerspectiveLayoutAction"));
    }
}
