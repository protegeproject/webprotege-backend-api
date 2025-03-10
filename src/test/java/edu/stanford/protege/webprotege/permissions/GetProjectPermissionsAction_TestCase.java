package edu.stanford.protege.webprotege.permissions;

import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.common.UserId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.startsWith;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class GetProjectPermissionsAction_TestCase {


    private final ProjectId projectId = ProjectId.generate();

    private final UserId userId = new UserId("UserA");

    private GetProjectPermissionsAction action;

    private GetProjectPermissionsAction otherAction;

    @BeforeEach
    public void setUp() throws Exception {
        action = new GetProjectPermissionsAction(projectId, userId);
        otherAction = new GetProjectPermissionsAction(projectId, userId);
    }

    public void shouldThrowNullPointerExceptionIf_ProjectId_IsNull() {
        assertThrows(NullPointerException.class, () -> {
            new GetProjectPermissionsAction(null, userId);
        });
    }


    public void shouldThrowNullPointerExceptionIf_UserId_IsNull() {
        assertThrows(NullPointerException.class, () -> {
            new GetProjectPermissionsAction(projectId, null);
        });
    }

    @Test
    public void shouldBeEqualToSelf() {
        assertThat(action, is(equalTo(action)));
    }

    @Test
    public void shouldNotBeEqualToNull() {
        assertThat(action, is(not(equalTo(null))));
    }

    @Test
    public void shouldBeEqualToOther() {
        assertThat(action, is(equalTo(otherAction)));
    }

    @Test
    public void shouldHaveSameHashCodeAsOther() {
        assertThat(action.hashCode(), is(otherAction.hashCode()));
    }

    @Test
    public void shouldGenerateToString() {
        assertThat(action.toString(), startsWith("GetProjectPermissionsAction"));
    }

    @Test
    public void shouldReturnSuppliedProjectId() {
        assertThat(action.projectId(), is(projectId));
    }

    @Test
    public void shouldReturnSuppliedUserId() {
        assertThat(action.userId(), is(userId));
    }
}