
package edu.stanford.protege.webprotege.project;

import edu.stanford.protege.webprotege.common.ProjectId;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.startsWith;

@RunWith(MockitoJUnitRunner.class)
public class GetProjectPrefixDeclarationsAction_TestCase {

    private GetProjectPrefixDeclarationsAction action;

    private final ProjectId projectId = ProjectId.valueOf("12345678-1234-1234-1234-123456789abc");

    @Before
    public void setUp() {
        action = GetProjectPrefixDeclarationsAction.create(projectId);
    }

    @SuppressWarnings("ConstantConditions")
    @Test(expected = NullPointerException.class)
    public void shouldThrowNullPointerExceptionIf_projectId_IsNull() {
        GetProjectPrefixDeclarationsAction.create(null);
    }

    @Test
    public void shouldReturnSupplied_projectId() {
        assertThat(action.getProjectId(), is(this.projectId));
    }

    @Test
    public void shouldBeEqualToSelf() {
        assertThat(action, is(action));
    }

    @Test
    @SuppressWarnings("ObjectEqualsNull")
    public void shouldNotBeEqualToNull() {
        assertThat(action.equals(null), is(false));
    }

    @Test
    public void shouldBeEqualToOther() {
        assertThat(action, is(GetProjectPrefixDeclarationsAction.create(projectId)));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_projectId() {
        ProjectId otherProjectId = ProjectId.valueOf("12345678-abcd-abcd-abcd-123456789abc");
        assertThat(action, is(Matchers.not(GetProjectPrefixDeclarationsAction.create(otherProjectId))));
    }

    @Test
    public void shouldBeEqualToOtherHashCode() {
        assertThat(action.hashCode(), is(GetProjectPrefixDeclarationsAction.create(projectId).hashCode()));
    }

    @Test
    public void shouldImplementToString() {
        assertThat(action.toString(), startsWith("GetProjectPrefixDeclarationsAction"));
    }

}
