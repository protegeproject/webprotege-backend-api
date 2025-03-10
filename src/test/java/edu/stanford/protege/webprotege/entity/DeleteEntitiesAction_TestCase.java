package edu.stanford.protege.webprotege.entity;

import com.google.common.collect.ImmutableSet;
import edu.stanford.protege.webprotege.common.ChangeRequestId;
import edu.stanford.protege.webprotege.common.ProjectId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.semanticweb.owlapi.model.OWLEntity;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
public class DeleteEntitiesAction_TestCase {

    private final ImmutableSet<OWLEntity> entities = ImmutableSet.of(mock(OWLEntity.class));

    private final ProjectId projectId = ProjectId.generate();

    private final ChangeRequestId changeRequestId = ChangeRequestId.generate();

    private DeleteEntitiesAction deleteEntitiesAction;

    @BeforeEach
    public void setUp() {
        deleteEntitiesAction = new DeleteEntitiesAction(changeRequestId, projectId, entities);
    }

    @SuppressWarnings("ConstantConditions")
    public void shouldThrowNullPointerExceptionIf_projectId_IsNull() {
        assertThrows(NullPointerException.class, () -> {
            new DeleteEntitiesAction(changeRequestId, null, entities);
        });
    }

    @Test
    public void shouldReturnSupplied_projectId() {
        assertThat(deleteEntitiesAction.projectId(), is(this.projectId));
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
        assertThat(deleteEntitiesAction, is(new DeleteEntitiesAction(changeRequestId, projectId, entities)));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_projectId() {
        assertThat(deleteEntitiesAction, is(not(new DeleteEntitiesAction(changeRequestId, ProjectId.generate(), entities))));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_entities() {
        assertThat(deleteEntitiesAction, is(not(new DeleteEntitiesAction(changeRequestId, projectId, ImmutableSet.of()))));
    }

    @Test
    public void shouldBeEqualToOtherHashCode() {
        assertThat(deleteEntitiesAction.hashCode(), is(new DeleteEntitiesAction(changeRequestId, projectId, entities).hashCode()));
    }

    @Test
    public void shouldImplementToString() {
        assertThat(deleteEntitiesAction.toString(), startsWith("DeleteEntitiesAction"));
    }

}
