package edu.stanford.protege.webprotege.entity;

import com.google.common.collect.ImmutableSet;
import edu.stanford.protege.webprotege.common.ChangeRequestId;
import edu.stanford.protege.webprotege.common.ProjectId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.semanticweb.owlapi.model.OWLEntity;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
public class MergeEntitiesAction_TestCase {

    private final ImmutableSet<OWLEntity> sourceEntities = ImmutableSet.of(mock(OWLEntity.class));

    private final MergedEntityTreatment treatment = MergedEntityTreatment.DELETE_MERGED_ENTITY;

    private final String commitMessage = "The commit message";

    private final ChangeRequestId changeRequestId = ChangeRequestId.generate();

    private final ProjectId projectId = ProjectId.generate();

    private MergeEntitiesAction action;

    @Mock
    private OWLEntity targetEntity;

    @BeforeEach
    public void setUp() {
        action = new MergeEntitiesAction(changeRequestId,
                projectId, sourceEntities, targetEntity, treatment, commitMessage);
    }

    @SuppressWarnings("ConstantConditions")
    public void shouldThrowNullPointerExceptionIf_projectId_IsNull() {
        assertThrows(NullPointerException.class, () -> {
            new MergeEntitiesAction(changeRequestId, null, sourceEntities, targetEntity, treatment, commitMessage);
        });
    }

    @Test
    public void shouldReturnSupplied_projectId() {
        assertThat(action.projectId(), is(this.projectId));
    }

    @SuppressWarnings("ConstantConditions")
    public void shouldThrowNullPointerExceptionIf_sourceEntity_IsNull() {
        assertThrows(NullPointerException.class, () -> {
            new MergeEntitiesAction(changeRequestId, projectId, null, targetEntity, treatment, commitMessage);
        });
    }

    @Test
    public void shouldReturnSupplied_sourceEntity() {
        assertThat(action.sourceEntities(), is(this.sourceEntities));
    }

    @SuppressWarnings("ConstantConditions")
    public void shouldThrowNullPointerExceptionIf_targetEntity_IsNull() {
        assertThrows(NullPointerException.class, () -> {
            new MergeEntitiesAction(changeRequestId, projectId, sourceEntities, null, treatment, commitMessage);
        });
    }

    @Test
    public void shouldReturnSupplied_targetEntity() {
        assertThat(action.targetEntity(), is(this.targetEntity));
    }

    @SuppressWarnings("ConstantConditions")
    public void shouldThrowNullPointerExceptionIf_treatment_IsNull() {
        assertThrows(NullPointerException.class, () -> {
            new MergeEntitiesAction(changeRequestId, projectId, sourceEntities, targetEntity, null, commitMessage);
        });
    }

    @Test
    public void shouldReturnSupplied_treatment() {
        assertThat(action.treatment(), is(this.treatment));
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
        assertThat(action, is(new MergeEntitiesAction(changeRequestId,
                projectId, sourceEntities, targetEntity, treatment, commitMessage)));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_projectId() {
        assertThat(action, is(not(new MergeEntitiesAction(changeRequestId,
                ProjectId.generate(), sourceEntities, targetEntity, treatment, commitMessage))));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_sourceEntity() {
        assertThat(action, is(not(new MergeEntitiesAction(changeRequestId,
                projectId, ImmutableSet.of(mock(OWLEntity.class)), targetEntity, treatment, commitMessage))));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_targetEntity() {
        assertThat(action, is(not(new MergeEntitiesAction(changeRequestId,
                projectId, sourceEntities, mock(OWLEntity.class), treatment, commitMessage))));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_treatment() {
        assertThat(action, is(not(new MergeEntitiesAction(changeRequestId,
                projectId, sourceEntities, targetEntity, MergedEntityTreatment.DEPRECATE_MERGED_ENTITY, commitMessage))));
    }

    @Test
    public void shouldBeEqualToOtherHashCode() {
        assertThat(action.hashCode(), is(new MergeEntitiesAction(changeRequestId,
                projectId, sourceEntities, targetEntity, treatment, commitMessage)
                .hashCode()));
    }

    @Test
    public void shouldImplementToString() {
        assertThat(action.toString(), startsWith("MergeEntitiesAction"));
    }

    @Test
    public void should_createMergeEntitiesAction() {
        assertThat(new MergeEntitiesAction(changeRequestId,
                projectId, sourceEntities, targetEntity, treatment, commitMessage), is(action));
    }

}
