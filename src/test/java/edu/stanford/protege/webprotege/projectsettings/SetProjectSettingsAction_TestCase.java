package edu.stanford.protege.webprotege.projectsettings;

import edu.stanford.protege.webprotege.common.ChangeRequestId;
import edu.stanford.protege.webprotege.common.ProjectId;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 25/11/14
 */
@RunWith(MockitoJUnitRunner.class)
public class SetProjectSettingsAction_TestCase {

    private ProjectId projectId = ProjectId.generate();

    @Mock
    private ProjectSettings projectSettings;

    private SetProjectSettingsAction action;

    private ChangeRequestId changeRequestId = ChangeRequestId.generate();

    @Before
    public void setUp() throws Exception {
        action = new SetProjectSettingsAction(changeRequestId, projectId, projectSettings);
    }


    @Test(expected = NullPointerException.class)
    public void shouldThrowNullPointerExceptionIf_ProjectSettings_IsNull() {
        new SetProjectSettingsAction(changeRequestId, projectId, null);
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
