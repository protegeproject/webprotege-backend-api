
package edu.stanford.protege.webprotege.projectsettings;

import edu.stanford.protege.webprotege.common.DictionaryLanguage;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.lang.DisplayNameSettings;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.mock;

@RunWith(value = MockitoJUnitRunner.class)
public class ProjectSettings_TestCase {

    private ProjectSettings projectSettings;

    private ProjectId projectId = ProjectId.generate();

    private final String projectDisplayName = "The projectDisplayName";

    private final String projectDescription = "The projectDescription";

    @Mock
    private SlackIntegrationSettings slackIntegrationSettings;

    @Mock
    private DictionaryLanguage defaultLanguage;

    @Mock
    private DisplayNameSettings defaultDisplayNameSettings;

    @Mock
    private WebhookSettings webhookSettings;

    @Mock
    private EntityDeprecationSettings entityDeprecationSettings;

    @Before
    public void setUp() {
        projectSettings = ProjectSettings.get(projectId, projectDisplayName, projectDescription, defaultLanguage, defaultDisplayNameSettings, slackIntegrationSettings, webhookSettings, entityDeprecationSettings);
    }

    @SuppressWarnings("ConstantConditions")
    @Test(expected = NullPointerException.class)
    public void shouldThrowNullPointerExceptionIf_projectId_IsNull() {
        ProjectSettings.get(null, projectDisplayName, projectDescription, defaultLanguage, defaultDisplayNameSettings, slackIntegrationSettings, webhookSettings, entityDeprecationSettings);
    }

    @Test
    public void shouldReturnSupplied_projectId() {
        assertThat(projectSettings.getProjectId(), is(this.projectId));
    }

    @SuppressWarnings("ConstantConditions")
    @Test(expected = NullPointerException.class)
    public void shouldThrowNullPointerExceptionIf_projectDisplayName_IsNull() {
        ProjectSettings.get(projectId, null, projectDescription, defaultLanguage, defaultDisplayNameSettings, slackIntegrationSettings, webhookSettings, entityDeprecationSettings);
    }

    @Test
    public void shouldReturnSupplied_projectDisplayName() {
        assertThat(projectSettings.getProjectDisplayName(), is(this.projectDisplayName));
    }

    @SuppressWarnings("ConstantConditions")
    @Test(expected = NullPointerException.class)
    public void shouldThrowNullPointerExceptionIf_projectDescription_IsNull() {
        ProjectSettings.get(projectId, projectDisplayName, null, defaultLanguage, defaultDisplayNameSettings, slackIntegrationSettings, webhookSettings, entityDeprecationSettings);
    }

    @Test
    public void shouldReturnSupplied_projectDescription() {
        assertThat(projectSettings.getProjectDescription(), is(this.projectDescription));
    }

    @SuppressWarnings("ConstantConditions")
    @Test(expected = NullPointerException.class)
    public void shouldThrowNullPointerExceptionIf_slackIntegrationSettings_IsNull() {
        ProjectSettings.get(projectId, projectDisplayName, projectDescription, defaultLanguage, defaultDisplayNameSettings, null, webhookSettings, entityDeprecationSettings);
    }

    @Test
    public void shouldReturnSupplied_slackIntegrationSettings() {
        assertThat(projectSettings.getSlackIntegrationSettings(), is(this.slackIntegrationSettings));
    }

    @SuppressWarnings("ConstantConditions")
    @Test(expected = NullPointerException.class)
    public void shouldThrowNullPointerExceptionIf_webhookSettings_IsNull() {
        ProjectSettings.get(projectId, projectDisplayName, projectDescription, defaultLanguage, defaultDisplayNameSettings, slackIntegrationSettings, null, entityDeprecationSettings);
    }

    @Test
    public void shouldReturnSupplied_webhookSettings() {
        assertThat(projectSettings.getWebhookSettings(), is(this.webhookSettings));
    }

    @Test
    public void shouldBeEqualToSelf() {
        assertThat(projectSettings, is(projectSettings));
    }

    @Test
    @SuppressWarnings("ObjectEqualsNull")
    public void shouldNotBeEqualToNull() {
        assertThat(projectSettings.equals(null), is(false));
    }

    @Test
    public void shouldBeEqualToOther() {
        assertThat(projectSettings, is(ProjectSettings.get(projectId, projectDisplayName, projectDescription, defaultLanguage, defaultDisplayNameSettings, slackIntegrationSettings, webhookSettings, entityDeprecationSettings)));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_projectId() {
        assertThat(projectSettings, is(not(ProjectSettings.get(ProjectId.generate(), projectDisplayName, projectDescription, defaultLanguage, defaultDisplayNameSettings, slackIntegrationSettings, webhookSettings, entityDeprecationSettings))));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_projectDisplayName() {
        assertThat(projectSettings, is(not(ProjectSettings.get(projectId, "String-e2778d26-1625-44d5-95be-360157916c2a", projectDescription, defaultLanguage, defaultDisplayNameSettings, slackIntegrationSettings, webhookSettings, entityDeprecationSettings))));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_projectDescription() {
        assertThat(projectSettings, is(not(ProjectSettings.get(projectId, projectDisplayName, "String-47556e3c-b862-44dc-a859-df860d6a2b59", defaultLanguage, defaultDisplayNameSettings, slackIntegrationSettings, webhookSettings, entityDeprecationSettings))));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_slackIntegrationSettings() {
        assertThat(projectSettings, is(not(ProjectSettings.get(projectId, projectDisplayName, projectDescription, defaultLanguage, defaultDisplayNameSettings, mock(SlackIntegrationSettings.class), webhookSettings, entityDeprecationSettings))));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_webhookSettings() {
        assertThat(projectSettings, is(not(ProjectSettings.get(projectId, projectDisplayName, projectDescription, defaultLanguage, defaultDisplayNameSettings, slackIntegrationSettings, mock(WebhookSettings.class), entityDeprecationSettings))));
    }

    @Test
    public void shouldBeEqualToOtherHashCode() {
        assertThat(projectSettings.hashCode(), is(ProjectSettings.get(projectId, projectDisplayName, projectDescription, defaultLanguage, defaultDisplayNameSettings, slackIntegrationSettings, webhookSettings, entityDeprecationSettings).hashCode()));
    }

    @Test
    public void shouldImplementToString() {
        assertThat(projectSettings.toString(), startsWith("ProjectSettings"));
    }

}
