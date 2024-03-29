
package edu.stanford.protege.webprotege.project;

import edu.stanford.protege.webprotege.common.ProjectId;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@RunWith(MockitoJUnitRunner.class)
public class GetProjectDetailsAction_TestCase {

    private GetProjectDetailsAction action;
    private ProjectId projectId = ProjectId.generate();

    @Before
    public void setUp()
    {
        action = new GetProjectDetailsAction(projectId);
    }

    @Test(expected = NullPointerException.class)
    public void shouldThrowNullPointerExceptionIf_projectId_IsNull() {
        new GetProjectDetailsAction(null);
    }

    @Test
    public void shouldReturnSupplied_projectId() {
        assertThat(action.projectId(), is(this.projectId));
    }

    @Test
    public void shouldBeEqualToSelf() {
        assertThat(action, is(action));
    }

    @Test
    public void shouldNotBeEqualToNull() {
        assertThat(action.equals(null), is(false));
    }

    @Test
    public void shouldBeEqualToOther() {
        assertThat(action, is(new GetProjectDetailsAction(projectId)));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_projectId() {
        assertThat(action, is(not(new GetProjectDetailsAction(ProjectId.generate()))));
    }

    @Test
    public void shouldBeEqualToOtherHashCode() {
        assertThat(action.hashCode(), is(new GetProjectDetailsAction(projectId).hashCode()));
    }

    @Test
    public void shouldImplementToString() {
        assertThat(action.toString(), startsWith("GetProjectDetailsAction"));
    }

}
