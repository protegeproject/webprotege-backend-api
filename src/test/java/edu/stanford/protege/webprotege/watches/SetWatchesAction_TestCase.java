package edu.stanford.protege.webprotege.watches;

import com.google.common.collect.ImmutableSet;
import edu.stanford.protege.webprotege.common.ChangeRequestId;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.common.UserId;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.semanticweb.owlapi.model.OWLEntity;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
public class SetWatchesAction_TestCase {

    private final ProjectId projectId = ProjectId.generate();

    private final UserId userId = new UserId("UserA");

    private final ChangeRequestId changeRequestId = ChangeRequestId.generate();

    private SetWatchesAction setWatchesAction;

    @Mock
    private OWLEntity entity;

    @Mock
    private ImmutableSet watches;

    @BeforeEach
    public void setUp() {
        setWatchesAction = new SetWatchesAction(changeRequestId, projectId, userId, entity, watches);
    }

    public void shouldThrowNullPointerExceptionIf_projectId_IsNull() {
        assertThrows(NullPointerException.class, () -> {
            new SetWatchesAction(changeRequestId, null, userId, entity, watches);
        });
    }

    @Test
    public void shouldReturnSupplied_projectId() {
        assertThat(setWatchesAction.projectId(), is(this.projectId));
    }

    public void shouldThrowNullPointerExceptionIf_userId_IsNull() {
        assertThrows(NullPointerException.class, () -> {
            new SetWatchesAction(changeRequestId, projectId, null, entity, watches);
        });
    }

    @Test
    public void shouldReturnSupplied_userId() {
        assertThat(setWatchesAction.userId(), is(this.userId));
    }

    public void shouldThrowNullPointerExceptionIf_entity_IsNull() {
        assertThrows(NullPointerException.class, () -> {
            new SetWatchesAction(changeRequestId, projectId, userId, null, watches);
        });
    }

    @Test
    public void shouldReturnSupplied_entity() {
        assertThat(setWatchesAction.entity(), is(this.entity));
    }

    public void shouldThrowNullPointerExceptionIf_watches_IsNull() {
        assertThrows(NullPointerException.class, () -> {
            new SetWatchesAction(changeRequestId, projectId, userId, entity, null);
        });
    }

    @Test
    public void shouldReturnSupplied_watches() {
        assertThat(setWatchesAction.watches(), is(this.watches));
    }

    @Test
    public void shouldBeEqualToSelf() {
        assertThat(setWatchesAction, is(setWatchesAction));
    }

    @Test
    public void shouldNotBeEqualToNull() {
        assertThat(setWatchesAction.equals(null), is(false));
    }

    @Test
    public void shouldBeEqualToOther() {
        assertThat(setWatchesAction, is(new SetWatchesAction(changeRequestId, projectId, userId, entity, watches)));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_projectId() {
        assertThat(setWatchesAction, is(not(new SetWatchesAction(changeRequestId,
                ProjectId.generate(), userId, entity, watches))));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_userId() {
        assertThat(setWatchesAction, is(not(new SetWatchesAction(changeRequestId,
                projectId, new UserId("OtherUser"), entity, watches))));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_entity() {
        assertThat(setWatchesAction, is(not(new SetWatchesAction(changeRequestId,
                projectId, userId, mock(OWLEntity.class), watches))));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_watches() {
        assertThat(setWatchesAction, is(not(new SetWatchesAction(changeRequestId,
                projectId, userId, entity, mock(ImmutableSet.class)))));
    }

    @Test
    public void shouldBeEqualToOtherHashCode() {
        assertThat(setWatchesAction.hashCode(), is(new SetWatchesAction(changeRequestId,
                projectId, userId, entity, watches)
                .hashCode()));
    }

    @Test
    public void shouldImplementToString() {
        assertThat(setWatchesAction.toString(), Matchers.startsWith("SetWatchesAction"));
    }

}
