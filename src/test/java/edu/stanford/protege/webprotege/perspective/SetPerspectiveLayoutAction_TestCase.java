package edu.stanford.protege.webprotege.perspective;

import edu.stanford.protege.webprotege.common.ChangeRequestId;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.common.UserId;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
public class SetPerspectiveLayoutAction_TestCase {

    private final ProjectId projectId = ProjectId.generate();

    private final UserId userId = new UserId("UserA");

    private final ChangeRequestId changeRequestId = ChangeRequestId.generate();

    private SetPerspectiveLayoutAction setPerspectiveLayoutAction;

    @Mock
    private PerspectiveLayout layout;

    @BeforeEach
    public void setUp()
            throws Exception {
        setPerspectiveLayoutAction = new SetPerspectiveLayoutAction(changeRequestId, projectId, userId, layout);
    }

    public void shouldThrowNullPointerExceptionIf_projectId_IsNull() {
        assertThrows(NullPointerException.class, () -> {
            new SetPerspectiveLayoutAction(changeRequestId, null, userId, layout);
        });
    }

    @Test
    public void shouldReturnSupplied_projectId() {
        assertThat(setPerspectiveLayoutAction.projectId(), is(this.projectId));
    }

    public void shouldThrowNullPointerExceptionIf_userId_IsNull() {
        assertThrows(NullPointerException.class, () -> {
            new SetPerspectiveLayoutAction(changeRequestId, projectId, null, layout);
        });
    }

    @Test
    public void shouldReturnSupplied_userId() {
        assertThat(setPerspectiveLayoutAction.userId(), is(this.userId));
    }

    public void shouldThrowNullPointerExceptionIf_layout_IsNull() {
        assertThrows(NullPointerException.class, () -> {
            new SetPerspectiveLayoutAction(changeRequestId, projectId, userId, null);
        });
    }

    @Test
    public void shouldReturnSupplied_layout() {
        assertThat(setPerspectiveLayoutAction.layout(), is(this.layout));
    }

    @Test
    public void shouldBeEqualToSelf() {
        assertThat(setPerspectiveLayoutAction, is(setPerspectiveLayoutAction));
    }

    @Test
    public void shouldNotBeEqualToNull() {
        assertThat(setPerspectiveLayoutAction.equals(null), is(false));
    }

    @Test
    public void shouldBeEqualToOther() {
        assertThat(setPerspectiveLayoutAction, is(new SetPerspectiveLayoutAction(changeRequestId,
                projectId, userId, layout)));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_projectId() {
        assertThat(setPerspectiveLayoutAction, is(Matchers.not(new SetPerspectiveLayoutAction(changeRequestId,
                ProjectId.generate(), userId, layout))));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_userId() {
        assertThat(setPerspectiveLayoutAction, is(Matchers.not(new SetPerspectiveLayoutAction(changeRequestId,
                projectId, new UserId("OtherUser"), layout))));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_layout() {
        assertThat(setPerspectiveLayoutAction, is(Matchers.not(new SetPerspectiveLayoutAction(changeRequestId,
                projectId, userId, mock(PerspectiveLayout.class)))));
    }

    @Test
    public void shouldBeEqualToOtherHashCode() {
        assertThat(setPerspectiveLayoutAction.hashCode(), is(new SetPerspectiveLayoutAction(changeRequestId,
                projectId, userId, layout)
                .hashCode()));
    }

    @Test
    public void shouldImplementToString() {
        assertThat(setPerspectiveLayoutAction.toString(), Matchers.startsWith("SetPerspectiveLayoutAction"));
    }

}
