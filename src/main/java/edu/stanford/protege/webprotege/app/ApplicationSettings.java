package edu.stanford.protege.webprotege.app;

import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.google.common.base.Objects;
import edu.stanford.protege.webprotege.common.UserId;
import edu.stanford.protege.webprotege.user.EmailAddress;

import javax.annotation.Nonnull;
import java.util.List;

import static com.google.common.base.MoreObjects.toStringHelper;
import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 16 Mar 2017
 */
@JsonClassDescription("An object that represents the application settings")
public class ApplicationSettings {

    private final String applicationName;

    private final EmailAddress systemNotificationEmailAddress;

    private final ApplicationLocation applicationLocation;

    private final AccountCreationSetting accountCreationSetting;

    private final List<UserId> accountCreators;

    private final ProjectCreationSetting projectCreationSetting;

    private final List<UserId> projectCreators;

    private final ProjectUploadSetting projectUploadSetting;

    private final List<UserId> projectUploaders;

    private final NotificationEmailsSetting notificationEmailsSetting;

    private final long maxUploadSize;

    public ApplicationSettings(@Nonnull String applicationName,
                               @Nonnull EmailAddress systemNotificationEmailAddress,
                               @Nonnull ApplicationLocation applicationLocation,
                               @Nonnull AccountCreationSetting accountCreationSetting,
                               @Nonnull List<UserId> accountCreators,
                               @Nonnull ProjectCreationSetting projectCreationSetting,
                               @Nonnull List<UserId> projectCreators,
                               @Nonnull ProjectUploadSetting projectUploadSetting,
                               @Nonnull List<UserId> projectUploaders,
                               @Nonnull NotificationEmailsSetting notificationEmailsSetting,
                               long maxUploadSize) {
        this.applicationName = checkNotNull(applicationName);
        this.systemNotificationEmailAddress = checkNotNull(systemNotificationEmailAddress);
        this.applicationLocation = checkNotNull(applicationLocation);
        this.accountCreationSetting = checkNotNull(accountCreationSetting);
        this.accountCreators = checkNotNull(accountCreators);
        this.projectCreationSetting = checkNotNull(projectCreationSetting);
        this.projectCreators = checkNotNull(projectCreators);
        this.projectUploadSetting = checkNotNull(projectUploadSetting);
        this.projectUploaders = checkNotNull(projectUploaders);
        this.notificationEmailsSetting = checkNotNull(notificationEmailsSetting);
        this.maxUploadSize = maxUploadSize;
    }

    @JsonPropertyDescription("The human readable application name")
    @Nonnull
    public String getApplicationName() {
        return applicationName;
    }

    @JsonPropertyDescription("An email address that critical system notifications will be sent to")
    @Nonnull
    public EmailAddress getSystemNotificationEmailAddress() {
        return systemNotificationEmailAddress;
    }

    @Nonnull
    public AccountCreationSetting getAccountCreationSetting() {
        return accountCreationSetting;
    }

    @JsonPropertyDescription("A list of users that are allowed to create accounts.  May be empty.")
    @Nonnull
    public List<UserId> getAccountCreators() {
        return accountCreators;
    }

    @Nonnull
    public ProjectCreationSetting getProjectCreationSetting() {
        return projectCreationSetting;
    }


    @JsonPropertyDescription("A list of users that are allowed to create projects.  May be empty.")
    @Nonnull
    public List<UserId> getProjectCreators() {
        return projectCreators;
    }

    @Nonnull
    public ProjectUploadSetting getProjectUploadSetting() {
        return projectUploadSetting;
    }


    @JsonPropertyDescription("A list of users that are allowed to upload ontologies.  May be empty.")
    @Nonnull
    public List<UserId> getProjectUploaders() {
        return projectUploaders;
    }

    @Nonnull
    public NotificationEmailsSetting getNotificationEmailsSetting() {
        return notificationEmailsSetting;
    }


    @JsonPropertyDescription("An object that represents the Web location of the application.")
    @Nonnull
    public ApplicationLocation getApplicationLocation() {
        return applicationLocation;
    }


    @JsonPropertyDescription("The maximum upload size in Megabytes")
    public long getMaxUploadSize() {
        return maxUploadSize;
    }


    @Override
    public int hashCode() {
        return Objects.hashCode(applicationName,
                                systemNotificationEmailAddress,
                                applicationLocation,
                                accountCreationSetting,
                                accountCreators,
                                projectCreationSetting,
                                projectCreators,
                                projectUploadSetting,
                                projectUploaders,
                                notificationEmailsSetting,
                                maxUploadSize);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ApplicationSettings other)) {
            return false;
        }
        return this.applicationName.equals(other.applicationName) && this.systemNotificationEmailAddress.equals(other.systemNotificationEmailAddress) && this.applicationLocation
                .equals(other.applicationLocation) && this.accountCreationSetting == other.accountCreationSetting && this.accountCreators
                .equals(other.accountCreators) && this.projectCreationSetting == other.projectCreationSetting && this.projectCreators
                .equals(other.projectCreators) && this.projectUploadSetting == other.projectUploadSetting && this.projectUploaders
                .equals(other.projectUploaders) && this.notificationEmailsSetting == other.notificationEmailsSetting && this.maxUploadSize == other.maxUploadSize;
    }


    @Override
    public String toString() {
        return toStringHelper("ApplicationSettings").add("name", applicationName)
                                                    .add("systemNotificationEmail", systemNotificationEmailAddress)
                                                    .addValue(applicationLocation)
                                                    .addValue(accountCreationSetting)
                                                    .add("accountCreators", accountCreators)
                                                    .addValue(projectCreationSetting)
                                                    .add("projectCreators", projectCreators)
                                                    .addValue(projectUploaders)
                                                    .add("projectUploaders", projectUploaders)
                                                    .addValue(notificationEmailsSetting)
                                                    .toString();
    }
}
