package edu.stanford.protege.webprotege.hierarchy;

import edu.stanford.protege.webprotege.common.ProjectId;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLEntity;
import uk.ac.manchester.cs.owl.owlapi.OWLClassImpl;

import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.startsWith;
import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class)
class GetHierarchyParentsActionTest {


    private GetHierarchyParentsAction action;

    private final ProjectId projectId = ProjectId.generate();

    @Mock
    private OWLEntity entity;

    private HierarchyDescriptor hierarchyDescriptor;

    @Before
    public void setUp() {
        hierarchyDescriptor = ClassHierarchyDescriptor.create();
        action = new GetHierarchyParentsAction(projectId, entity, hierarchyDescriptor);
    }

    @AfterEach
    void tearDown() {
    }

    @SuppressWarnings("ConstantConditions")
    @Test(expected = NullPointerException.class)
    public void shouldThrowNullPointerExceptionIf_projectId_IsNull() {
        new GetHierarchyParentsAction(null, entity, hierarchyDescriptor);
    }

    @Test
    public void shouldReturnSupplied_projectId() {
        assertThat(action.projectId(), is(this.projectId));
    }

    @SuppressWarnings("ConstantConditions")
    @Test(expected = NullPointerException.class)
    public void shouldThrowNullPointerExceptionIf_entity_IsNull() {
        new GetHierarchyParentsAction(projectId, null, hierarchyDescriptor);
    }


    @Test
    public void shouldReturnSupplied_entity() {
        assertThat(action.entity(), is(this.entity));
    }


    @SuppressWarnings("ConstantConditions")
    @Test(expected = NullPointerException.class)
    public void shouldThrowNullPointerExceptionIf_hierarchyId_IsNull() {
        new GetHierarchyParentsAction(projectId, entity, null);
    }

    @Test
    public void shouldBeEqualToOther() {
        assertThat(action, is(new GetHierarchyParentsAction(projectId, entity, hierarchyDescriptor)));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_projectId() {
        assertThat(action, is(not(new GetHierarchyParentsAction(ProjectId.generate(), entity, hierarchyDescriptor))));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_entity() {
        assertThat(action, is(not(new GetHierarchyParentsAction(projectId, mock(OWLEntity.class), hierarchyDescriptor))));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_hierarchyId() {
        assertThat(action, is(not(new GetHierarchyParentsAction(projectId, entity, ClassHierarchyDescriptor.create(Set.of(new OWLClassImpl(IRI.create("http://example.org/A"))))))));
    }

    @Test
    public void shouldBeEqualToOtherHashCode() {
        assertThat(action.hashCode(), is(new GetHierarchyParentsAction(projectId, entity, hierarchyDescriptor).hashCode()));
    }

    @Test
    public void shouldImplementToString() {
        assertThat(action.toString(), startsWith("GetHierarchyParentsAction"));
    }
}