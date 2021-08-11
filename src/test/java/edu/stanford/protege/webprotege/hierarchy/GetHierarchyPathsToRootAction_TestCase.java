
package edu.stanford.protege.webprotege.hierarchy;

import edu.stanford.protege.webprotege.common.ProjectId;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.semanticweb.owlapi.model.OWLEntity;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class)
public class GetHierarchyPathsToRootAction_TestCase {

    private GetHierarchyPathsToRootAction action;

    private ProjectId projectId = ProjectId.generate();

    @Mock
    private OWLEntity entity;

    @Mock
    private HierarchyId hierarchyId;

    @Before
    public void setUp() {
        action = new GetHierarchyPathsToRootAction(projectId, entity, hierarchyId);
    }

    @SuppressWarnings("ConstantConditions")
    @Test(expected = NullPointerException.class)
    public void shouldThrowNullPointerExceptionIf_projectId_IsNull() {
        new GetHierarchyPathsToRootAction(null, entity, hierarchyId);
    }

    @Test
    public void shouldReturnSupplied_projectId() {
        assertThat(action.projectId(), is(this.projectId));
    }

    @SuppressWarnings("ConstantConditions")
    @Test(expected = NullPointerException.class)
    public void shouldThrowNullPointerExceptionIf_entity_IsNull() {
        new GetHierarchyPathsToRootAction(projectId, null, hierarchyId);
    }

    @Test
    public void shouldReturnSupplied_entity() {
        assertThat(action.entity(), is(this.entity));
    }

    @SuppressWarnings("ConstantConditions")
    @Test(expected = NullPointerException.class)
    public void shouldThrowNullPointerExceptionIf_hierarchyId_IsNull() {
        new GetHierarchyPathsToRootAction(projectId, entity, null);
    }

    @Test
    public void shouldReturnSupplied_hierarchyId() {
        assertThat(action.hierarchyId(), is(this.hierarchyId));
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
        assertThat(action, is(new GetHierarchyPathsToRootAction(projectId, entity, hierarchyId)));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_projectId() {
        assertThat(action, is(not(new GetHierarchyPathsToRootAction(ProjectId.generate(), entity, hierarchyId))));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_entity() {
        assertThat(action, is(not(new GetHierarchyPathsToRootAction(projectId, mock(OWLEntity.class), hierarchyId))));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_hierarchyId() {
        assertThat(action, is(not(new GetHierarchyPathsToRootAction(projectId, entity, mock(HierarchyId.class)))));
    }

    @Test
    public void shouldBeEqualToOtherHashCode() {
        assertThat(action.hashCode(), is(new GetHierarchyPathsToRootAction(projectId, entity, hierarchyId).hashCode()));
    }

    @Test
    public void shouldImplementToString() {
        assertThat(action.toString(), startsWith("GetHierarchyPathsToRootAction"));
    }

}
