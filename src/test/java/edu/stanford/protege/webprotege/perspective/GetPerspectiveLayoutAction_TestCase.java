package edu.stanford.protege.webprotege.perspective;

import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.common.UserId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class GetPerspectiveLayoutAction_TestCase {

    private final ProjectId projectId = ProjectId.generate();

    private final UserId userId = new UserId("UserA");

    private GetPerspectiveLayoutAction getPerspectiveLayoutAction;

    @Mock
    private PerspectiveId perspectiveId;

    @BeforeEach
    public void setUp() {
        getPerspectiveLayoutAction = new GetPerspectiveLayoutAction(projectId, userId, perspectiveId);
    }

    public void shouldThrowNullPointerExceptionIf_projectId_IsNull() {
        assertThrows(NullPointerException.class, () -> {
            new GetPerspectiveLayoutAction(null, userId, perspectiveId);
        });
    }

    @Test
    public void shouldReturnSupplied_projectId() {
        assertThat(getPerspectiveLayoutAction.projectId(), is(this.projectId));
    }

    public void shouldThrowNullPointerExceptionIf_userId_IsNull() {
        assertThrows(NullPointerException.class, () -> {
            new GetPerspectiveLayoutAction(projectId, null, perspectiveId);
        });
    }

    @Test
    public void shouldReturnSupplied_userId() {
        assertThat(getPerspectiveLayoutAction.userId(), is(this.userId));
    }

    public void shouldThrowNullPointerExceptionIf_perspectiveId_IsNull() {
        assertThrows(NullPointerException.class, () -> {
            new GetPerspectiveLayoutAction(projectId, userId, null);
        });
    }

    @Test
    public void shouldReturnSupplied_perspectiveId() {
        assertThat(getPerspectiveLayoutAction.perspectiveId(), is(this.perspectiveId));
    }

    @Test
    public void shouldBeEqualToSelf() {
        assertThat(getPerspectiveLayoutAction, is(getPerspectiveLayoutAction));
    }

    @Test
    public void shouldNotBeEqualToNull() {
        assertThat(getPerspectiveLayoutAction.equals(null), is(false));
    }

    @Test
    public void shouldBeEqualToOther() {
        assertThat(getPerspectiveLayoutAction, is(new GetPerspectiveLayoutAction(projectId, userId, perspectiveId)));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_projectId() {
        assertThat(getPerspectiveLayoutAction, is(not(new GetPerspectiveLayoutAction(ProjectId.generate(), userId, perspectiveId))));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_userId() {
        assertThat(getPerspectiveLayoutAction, is(not(new GetPerspectiveLayoutAction(projectId, new UserId("OtherUser"), perspectiveId))));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_perspectiveId() {
        assertThat(getPerspectiveLayoutAction, is(not(new GetPerspectiveLayoutAction(projectId, userId, Mockito.mock(PerspectiveId.class)))));
    }

    @Test
    public void shouldBeEqualToOtherHashCode() {
        assertThat(getPerspectiveLayoutAction.hashCode(), is(new GetPerspectiveLayoutAction(projectId, userId, perspectiveId)
                .hashCode()));
    }

    @Test
    public void shouldImplementToString() {
        assertThat(getPerspectiveLayoutAction.toString(), startsWith("GetPerspectiveLayoutAction"));
    }

}
