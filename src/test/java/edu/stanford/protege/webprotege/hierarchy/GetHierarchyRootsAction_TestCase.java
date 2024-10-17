
package edu.stanford.protege.webprotege.hierarchy;

import edu.stanford.protege.webprotege.common.ProjectId;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class)
public class GetHierarchyRootsAction_TestCase {

    private GetHierarchyRootsAction action;
    private ProjectId projectId = ProjectId.generate();
    private HierarchyDescriptor hierarchyDescriptor = ClassHierarchyDescriptor.create();

    @Before
    public void setUp() {
        action = new GetHierarchyRootsAction(projectId, hierarchyDescriptor);
    }

    @SuppressWarnings("ConstantConditions")
    @Test(expected = NullPointerException.class)
    public void shouldThrowNullPointerExceptionIf_projectId_IsNull() {
        new GetHierarchyRootsAction(null, hierarchyDescriptor);
    }

    @Test
    public void shouldReturnSupplied_projectId() {
        assertThat(action.projectId(), is(this.projectId));
    }

    @SuppressWarnings("ConstantConditions")
    @Test(expected = NullPointerException.class)
    public void shouldThrowNullPointerExceptionIf_hierarchyId_IsNull() {
        new GetHierarchyRootsAction(projectId, null);
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
        assertThat(action, is(new GetHierarchyRootsAction(projectId, hierarchyDescriptor)));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_projectId() {
        assertThat(action, is(not(new GetHierarchyRootsAction(ProjectId.generate(), hierarchyDescriptor))));
    }

    @Test
    public void shouldBeEqualToOtherHashCode() {
        assertThat(action.hashCode(), is(new GetHierarchyRootsAction(projectId, hierarchyDescriptor).hashCode()));
    }

    @Test
    public void shouldImplementToString() {
        assertThat(action.toString(), startsWith("GetHierarchyRootsAction"));
    }

}
