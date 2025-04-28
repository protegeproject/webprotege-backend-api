package edu.stanford.protege.webprotege.hierarchy;

import edu.stanford.protege.webprotege.common.ProjectId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class GetHierarchyRootsAction_TestCase {

    private final ProjectId projectId = ProjectId.generate();

    private final HierarchyDescriptor hierarchyDescriptor = ClassHierarchyDescriptor.create();

    private GetHierarchyRootsAction action;

    @BeforeEach
    public void setUp() {
        action = new GetHierarchyRootsAction(projectId, hierarchyDescriptor);
    }

    @SuppressWarnings("ConstantConditions")
    public void shouldThrowNullPointerExceptionIf_projectId_IsNull() {
        assertThrows(NullPointerException.class, () -> {
            new GetHierarchyRootsAction(null, hierarchyDescriptor);
        });
    }

    @Test
    public void shouldReturnSupplied_projectId() {
        assertThat(action.projectId(), is(this.projectId));
    }

    @SuppressWarnings("ConstantConditions")
    public void shouldThrowNullPointerExceptionIf_hierarchyId_IsNull() {
        assertThrows(NullPointerException.class, () -> {
            new GetHierarchyRootsAction(projectId, null);
        });
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
