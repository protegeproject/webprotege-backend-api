package edu.stanford.protege.webprotege.hierarchy;

import static org.junit.jupiter.api.Assertions.assertThrows;


import edu.stanford.protege.webprotege.common.ProjectId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLEntity;
import uk.ac.manchester.cs.owl.owlapi.OWLClassImpl;

import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class GetHierarchyPathsToRootAction_TestCase {

    private final ProjectId projectId = ProjectId.generate();

    private final HierarchyDescriptor hierarchyDescriptor = ClassHierarchyDescriptor.create();

    private GetHierarchyPathsToRootAction action;

    @Mock
    private OWLEntity entity;

    @BeforeEach
    public void setUp() {
        action = new GetHierarchyPathsToRootAction(projectId, entity, hierarchyDescriptor);
    }

    @SuppressWarnings("ConstantConditions")
    public void shouldThrowNullPointerExceptionIf_projectId_IsNull() {
        assertThrows(NullPointerException.class, () -> {
            new GetHierarchyPathsToRootAction(null, entity, hierarchyDescriptor);
        });
    }

    @Test
    public void shouldReturnSupplied_projectId() {
        assertThat(action.projectId(), is(this.projectId));
    }

    @SuppressWarnings("ConstantConditions")
    public void shouldThrowNullPointerExceptionIf_entity_IsNull() {
        assertThrows(NullPointerException.class, () -> {
            new GetHierarchyPathsToRootAction(projectId, null, hierarchyDescriptor);
        });
    }

    @Test
    public void shouldReturnSupplied_entity() {
        assertThat(action.entity(), is(this.entity));
    }

    @SuppressWarnings("ConstantConditions")
    public void shouldThrowNullPointerExceptionIf_hierarchyId_IsNull() {
        assertThrows(NullPointerException.class, () -> {
            new GetHierarchyPathsToRootAction(projectId, entity, null);
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
        assertThat(action, is(new GetHierarchyPathsToRootAction(projectId, entity, hierarchyDescriptor)));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_projectId() {
        assertThat(action, is(not(new GetHierarchyPathsToRootAction(ProjectId.generate(), entity, hierarchyDescriptor))));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_entity() {
        assertThat(action, is(not(new GetHierarchyPathsToRootAction(projectId, mock(OWLEntity.class), hierarchyDescriptor))));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_hierarchyId() {
        assertThat(action, is(not(new GetHierarchyPathsToRootAction(projectId, entity, ClassHierarchyDescriptor.create(Set.of(new OWLClassImpl(IRI.create("http://example.org"))))))));
    }

    @Test
    public void shouldBeEqualToOtherHashCode() {
        assertThat(action.hashCode(), is(new GetHierarchyPathsToRootAction(projectId, entity, hierarchyDescriptor).hashCode()));
    }

    @Test
    public void shouldImplementToString() {
        assertThat(action.toString(), startsWith("GetHierarchyPathsToRootAction"));
    }

}
