
package edu.stanford.protege.webprotege.hierarchy;

import edu.stanford.protege.webprotege.common.PageRequest;
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
public class GetHierarchyChildrenAction_TestCase {

    private GetHierarchyChildrenAction action;

    private ProjectId projectId = ProjectId.generate();

    @Mock
    private OWLEntity entity;

    @Mock
    private HierarchyId hierarchyId;

    @Before
    public void setUp() {
        action = new GetHierarchyChildrenAction(projectId, entity, hierarchyId, PageRequest.requestFirstPage());
    }

    @SuppressWarnings("ConstantConditions")
    @Test(expected = NullPointerException.class)
    public void shouldThrowNullPointerExceptionIf_projectId_IsNull() {
        new GetHierarchyChildrenAction(null, entity, hierarchyId, PageRequest.requestFirstPage());
    }

    @Test
    public void shouldReturnSupplied_projectId() {
        assertThat(action.projectId(), is(this.projectId));
    }

    @SuppressWarnings("ConstantConditions")
    @Test(expected = NullPointerException.class)
    public void shouldThrowNullPointerExceptionIf_entity_IsNull() {
        new GetHierarchyChildrenAction(projectId, null, hierarchyId, PageRequest.requestFirstPage());
    }

    @Test
    public void shouldReturnSupplied_entity() {
        assertThat(action.entity(), is(this.entity));
    }

    @SuppressWarnings("ConstantConditions")
    @Test(expected = NullPointerException.class)
    public void shouldThrowNullPointerExceptionIf_hierarchyId_IsNull() {
        new GetHierarchyChildrenAction(projectId, entity, null, PageRequest.requestFirstPage());
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
        assertThat(action, is(new GetHierarchyChildrenAction(projectId, entity, hierarchyId, PageRequest.requestFirstPage())));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_projectId() {
        assertThat(action, is(not(new GetHierarchyChildrenAction(ProjectId.generate(), entity, hierarchyId, PageRequest.requestFirstPage()))));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_entity() {
        assertThat(action, is(not(new GetHierarchyChildrenAction(projectId, mock(OWLEntity.class), hierarchyId, PageRequest.requestFirstPage()))));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_hierarchyId() {
        assertThat(action, is(not(new GetHierarchyChildrenAction(projectId, entity, mock(HierarchyId.class), PageRequest.requestFirstPage()))));
    }

    @Test
    public void shouldBeEqualToOtherHashCode() {
        assertThat(action.hashCode(), is(new GetHierarchyChildrenAction(projectId, entity, hierarchyId, PageRequest.requestFirstPage()).hashCode()));
    }

    @Test
    public void shouldImplementToString() {
        assertThat(action.toString(), startsWith("GetHierarchyChildrenAction"));
    }

}
