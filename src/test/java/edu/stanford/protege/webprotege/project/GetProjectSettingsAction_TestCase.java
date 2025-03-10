package edu.stanford.protege.webprotege.project;

import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.projectsettings.GetProjectSettingsAction;
import edu.stanford.protege.webprotege.projectsettings.GetProjectSettingsResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class GetProjectSettingsAction_TestCase {

    private final ProjectId projectId = ProjectId.generate();

    private GetProjectSettingsAction action;

    @BeforeEach
    public void setUp() throws Exception {
        action = new GetProjectSettingsAction(projectId);
    }


    public void shouldThrowNullPointerExceptionIf_ProjectSettings_IsNull() {
        assertThrows(NullPointerException.class, () -> {
            new GetProjectSettingsResult(null);
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
    }

    @Test
    public void shouldHaveSameHashCode() {
    }
}
