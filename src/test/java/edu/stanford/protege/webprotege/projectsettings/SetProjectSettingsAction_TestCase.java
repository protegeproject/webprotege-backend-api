package edu.stanford.protege.webprotege.projectsettings;

import edu.stanford.protege.webprotege.common.ChangeRequestId;
import edu.stanford.protege.webprotege.common.ProjectId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class SetProjectSettingsAction_TestCase {

    private final ProjectId projectId = ProjectId.generate();

    private final ChangeRequestId changeRequestId = ChangeRequestId.generate();

    @Mock
    private ProjectSettings projectSettings;

    private SetProjectSettingsAction action;

    @BeforeEach
    public void setUp() throws Exception {
        action = new SetProjectSettingsAction(changeRequestId, projectId, projectSettings);
    }


    public void shouldThrowNullPointerExceptionIf_ProjectSettings_IsNull() {
        assertThrows(NullPointerException.class, () -> {
            new SetProjectSettingsAction(changeRequestId, projectId, null);
        });
    }

    @Test
    public void shouldReturnSupplied_ProjectId() {
        assertThat(action.projectId(), is(projectId));
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
        SetProjectSettingsAction other = new SetProjectSettingsAction(changeRequestId, projectId, projectSettings);
        assertThat(action, is(equalTo(other)));
    }

    @Test
    public void shouldHaveSameHashCode() {
        SetProjectSettingsAction other = new SetProjectSettingsAction(changeRequestId, projectId, projectSettings);
        assertThat(action.hashCode(), is(other.hashCode()));
    }
}
