package edu.stanford.protege.webprotege.projectsettings;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.auto.value.AutoValue;
import edu.stanford.protege.webprotege.common.DictionaryLanguage;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.lang.DisplayNameSettings;
import edu.stanford.protege.webprotege.project.WithProjectId;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.io.Serializable;

/**
 * Author: Matthew Horridge<br>
 * Stanford University<br>
 * Bio-Medical Informatics Research Group<br>
 * Date: 09/07/2012
 */
@AutoValue
public abstract class ProjectSettings implements Serializable, WithProjectId<ProjectSettings> {

    private static final String PROJECT_ID = "projectId";

    private static final String DISPLAY_NAME = "displayName";

    private static final String DESCRIPTION = "description";

    private static final String DEFAULT_LANGUAGE = "defaultLanguage";

    private static final String DEFAULT_DISPLAY_NAME_SETTINGS = "defaultDisplayNameSettings";

    private static final String SLACK_INTEGRATION_SETTINGS = "slackIntegrationSettings";

    private static final String WEBHOOK_SETTINGS = "webhookSettings";

    private static final String ENTITY_DEPRECATION_SETTINGS = "entityDeprecationSettings";

    /**
     * Gets the projectId.
     * @return The projectId.  Not {@code null}.
     */
    @JsonProperty(PROJECT_ID)
    @Nonnull
    public abstract ProjectId getProjectId();

    /**
     * Gets the project display name.
     * @return The project display name.  Not {@code null}.
     */
    @Nonnull
    @JsonProperty(DISPLAY_NAME)
    public abstract String getProjectDisplayName();

    /**
     * Gets the project description.
     * @return The project description as a string.  May be empty. Not {@code null}.
     */
    @Nonnull
    @JsonProperty(DESCRIPTION)
    public abstract String getProjectDescription();

    @Nonnull
    @JsonProperty(DEFAULT_LANGUAGE)
    public abstract DictionaryLanguage getDefaultLanguage();

    @Nonnull
    @JsonProperty(DEFAULT_DISPLAY_NAME_SETTINGS)
    public abstract DisplayNameSettings getDefaultDisplayNameSettings();

    @Nonnull
    @JsonProperty(SLACK_INTEGRATION_SETTINGS)
    public abstract SlackIntegrationSettings getSlackIntegrationSettings();

    @Nonnull
    @JsonProperty(WEBHOOK_SETTINGS)
    public abstract WebhookSettings getWebhookSettings();

    @Nonnull
    @JsonProperty(ENTITY_DEPRECATION_SETTINGS)
    public abstract EntityDeprecationSettings getEntityDeprecationSettings();

    @Nonnull
    @JsonCreator
    public static ProjectSettings get(@Nonnull @JsonProperty(PROJECT_ID) ProjectId projectId,
                                      @Nonnull @JsonProperty(DISPLAY_NAME) String displayName,
                                      @Nonnull @JsonProperty(DESCRIPTION) String description,
                                      @Nonnull @JsonProperty(DEFAULT_LANGUAGE) DictionaryLanguage defaultLanguage,
                                      @Nonnull @JsonProperty(DEFAULT_DISPLAY_NAME_SETTINGS) DisplayNameSettings defaultDisplayNameSettings,
                                      @Nonnull @JsonProperty(SLACK_INTEGRATION_SETTINGS) SlackIntegrationSettings slackIntegrationSettings,
                                      @Nonnull @JsonProperty(WEBHOOK_SETTINGS) WebhookSettings webhookSettings,
                                      @Nullable @JsonProperty(ENTITY_DEPRECATION_SETTINGS) EntityDeprecationSettings entityDeprecationSettings) {
        return new AutoValue_ProjectSettings(projectId,
                                             displayName,
                                             description,
                                             defaultLanguage,
                                             defaultDisplayNameSettings,
                                             slackIntegrationSettings,
                                             webhookSettings,
                                             entityDeprecationSettings == null ? EntityDeprecationSettings.empty() : entityDeprecationSettings);
    }

    @Override
    public ProjectSettings withProjectId(@Nonnull ProjectId projectId) {
        return ProjectSettings.get(projectId,
                                   getProjectDisplayName(),
                                   getProjectDescription(),
                                   getDefaultLanguage(),
                                   getDefaultDisplayNameSettings(),
                                   getSlackIntegrationSettings(),
                                   getWebhookSettings(),
                                   getEntityDeprecationSettings());
    }
}
