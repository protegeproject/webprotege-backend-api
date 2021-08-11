
package edu.stanford.protege.webprotege.entity;

import com.google.common.collect.ImmutableSet;
import edu.stanford.protege.webprotege.common.ProjectId;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.semanticweb.owlapi.model.OWLEntity;

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.mock;

@RunWith(org.mockito.runners.MockitoJUnitRunner.class)
public class DeleteEntitiesAction_TestCase {

    private DeleteEntitiesAction deleteEntitiesAction;

    private ProjectId projectId = ProjectId.generate();

    private final ImmutableSet<OWLEntity> entities = ImmutableSet.of(mock(OWLEntity.class));

    @Before
    public void setUp() {
        deleteEntitiesAction = new DeleteEntitiesAction(projectId, entities);
    }

    @SuppressWarnings("ConstantConditions")
    @Test(expected = NullPointerException.class)
    public void shouldThrowNullPointerExceptionIf_projectId_IsNull() {
        new DeleteEntitiesAction(null, entities);
    }

    @Test
    public void shouldReturnSupplied_projectId() {
        assertThat(deleteEntitiesAction.projectId(), is(this.projectId));
    }

    @SuppressWarnings("ConstantConditions")
    @Test(expected = NullPointerException.class)
    public void shouldThrowNullPointerExceptionIf_entities_IsNull() {
        new DeleteEntitiesAction(projectId, null);
    }

    @Test
    public void shouldReturnSupplied_entities() {
        assertThat(deleteEntitiesAction.entities(), is(this.entities));
    }

    @Test
    public void shouldBeEqualToSelf() {
        assertThat(deleteEntitiesAction, is(deleteEntitiesAction));
    }

    @Test
    @SuppressWarnings("ObjectEqualsNull")
    public void shouldNotBeEqualToNull() {
        assertThat(deleteEntitiesAction.equals(null), is(false));
    }

    @Test
    public void shouldBeEqualToOther() {
        assertThat(deleteEntitiesAction, is(new DeleteEntitiesAction(projectId, entities)));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_projectId() {
        assertThat(deleteEntitiesAction, is(not(new DeleteEntitiesAction(ProjectId.generate(), entities))));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_entities() {
        assertThat(deleteEntitiesAction, is(not(new DeleteEntitiesAction(projectId, ImmutableSet.of()))));
    }

    @Test
    public void shouldBeEqualToOtherHashCode() {
        assertThat(deleteEntitiesAction.hashCode(), is(new DeleteEntitiesAction(projectId, entities).hashCode()));
    }

    @Test
    public void shouldImplementToString() {
        assertThat(deleteEntitiesAction.toString(), startsWith("DeleteEntitiesAction"));
    }

}
