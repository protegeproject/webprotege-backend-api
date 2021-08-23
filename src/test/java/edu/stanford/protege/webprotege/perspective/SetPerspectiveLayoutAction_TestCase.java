
package edu.stanford.protege.webprotege.perspective;

import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.common.UserId;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class)
public class SetPerspectiveLayoutAction_TestCase {

    private SetPerspectiveLayoutAction setPerspectiveLayoutAction;
    private ProjectId projectId = ProjectId.generate();
    private UserId userId = new UserId("UserA");
    @Mock
    private PerspectiveLayout layout;

    @Before
    public void setUp()
        throws Exception
    {
        setPerspectiveLayoutAction = new SetPerspectiveLayoutAction(projectId, userId, layout);
    }

    @Test(expected = NullPointerException.class)
    public void shouldThrowNullPointerExceptionIf_projectId_IsNull() {
        new SetPerspectiveLayoutAction(null, userId, layout);
    }

    @Test
    public void shouldReturnSupplied_projectId() {
        assertThat(setPerspectiveLayoutAction.projectId(), is(this.projectId));
    }

    @Test(expected = NullPointerException.class)
    public void shouldThrowNullPointerExceptionIf_userId_IsNull() {
        new SetPerspectiveLayoutAction(projectId, null, layout);
    }

    @Test
    public void shouldReturnSupplied_userId() {
        assertThat(setPerspectiveLayoutAction.userId(), is(this.userId));
    }

    @Test(expected = NullPointerException.class)
    public void shouldThrowNullPointerExceptionIf_layout_IsNull() {
        new SetPerspectiveLayoutAction(projectId, userId, null);
    }

    @Test
    public void shouldReturnSupplied_layout() {
        assertThat(setPerspectiveLayoutAction.layout(), is(this.layout));
    }

    @Test
    public void shouldBeEqualToSelf() {
        assertThat(setPerspectiveLayoutAction, is(setPerspectiveLayoutAction));
    }

    @Test
    public void shouldNotBeEqualToNull() {
        assertThat(setPerspectiveLayoutAction.equals(null), is(false));
    }

    @Test
    public void shouldBeEqualToOther() {
        assertThat(setPerspectiveLayoutAction, is(new SetPerspectiveLayoutAction(projectId, userId, layout)));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_projectId() {
        assertThat(setPerspectiveLayoutAction, is(Matchers.not(new SetPerspectiveLayoutAction(ProjectId.generate(), userId, layout))));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_userId() {
        assertThat(setPerspectiveLayoutAction, is(Matchers.not(new SetPerspectiveLayoutAction(projectId, new UserId("OtherUser"), layout))));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_layout() {
        assertThat(setPerspectiveLayoutAction, is(Matchers.not(new SetPerspectiveLayoutAction(projectId, userId, mock(PerspectiveLayout.class)))));
    }

    @Test
    public void shouldBeEqualToOtherHashCode() {
        assertThat(setPerspectiveLayoutAction.hashCode(), is(new SetPerspectiveLayoutAction(projectId, userId, layout)
                                                                                       .hashCode()));
    }

    @Test
    public void shouldImplementToString() {
        assertThat(setPerspectiveLayoutAction.toString(), Matchers.startsWith("SetPerspectiveLayoutAction"));
    }

}
