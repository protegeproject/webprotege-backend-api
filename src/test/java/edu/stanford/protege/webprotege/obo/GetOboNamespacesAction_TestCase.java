
package edu.stanford.protege.webprotege.obo;

import edu.stanford.protege.webprotege.common.ProjectId;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class)
public class GetOboNamespacesAction_TestCase {

    private GetOboNamespacesAction getOboNamespacesAction;
    private ProjectId projectId = ProjectId.generate();

    @Before
    public void setUp() {
        getOboNamespacesAction = new GetOboNamespacesAction(projectId);
    }

    @SuppressWarnings("ConstantConditions")
    @Test(expected = NullPointerException.class)
    public void shouldThrowNullPointerExceptionIf_projectId_IsNull() {
        new GetOboNamespacesAction(null);
    }

    @Test
    public void shouldReturnSupplied_projectId() {
        assertThat(getOboNamespacesAction.projectId(), is(this.projectId));
    }

    @Test
    public void shouldBeEqualToSelf() {
        assertThat(getOboNamespacesAction, is(getOboNamespacesAction));
    }

    @Test
    @SuppressWarnings("ObjectEqualsNull")
    public void shouldNotBeEqualToNull() {
        assertThat(getOboNamespacesAction.equals(null), is(false));
    }

    @Test
    public void shouldBeEqualToOther() {
        assertThat(getOboNamespacesAction, is(new GetOboNamespacesAction(projectId)));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_projectId() {
        assertThat(getOboNamespacesAction, is(not(new GetOboNamespacesAction(ProjectId.generate()))));
    }

    @Test
    public void shouldBeEqualToOtherHashCode() {
        assertThat(getOboNamespacesAction.hashCode(), is(new GetOboNamespacesAction(projectId).hashCode()));
    }

    @Test
    public void shouldImplementToString() {
        assertThat(getOboNamespacesAction.toString(), Matchers.startsWith("GetOboNamespacesAction"));
    }
}
