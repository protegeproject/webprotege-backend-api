package edu.stanford.protege.webprotege.app;

import edu.stanford.protege.webprotege.user.EmailAddress;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Collections;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2021-04-06
 */
public class GetApplicationSettings_Serialization_TestCase {


    @Test
    public void shouldSerializeAction() throws IOException {
        var action = new GetApplicationSettingsAction();

    }

    @Test
    public void shouldSerializeResult() throws IOException {
        var result = new GetApplicationSettingsResult(new ApplicationSettings(
                "Name",
                new EmailAddress("Email"),
                new ApplicationLocation("scheme", "host", "path", 20),
                AccountCreationSetting.ACCOUNT_CREATION_ALLOWED,
                Collections.emptyList(),
                ProjectCreationSetting.EMPTY_PROJECT_CREATION_ALLOWED,
                Collections.emptyList(),
                ProjectUploadSetting.PROJECT_UPLOAD_ALLOWED,
                Collections.emptyList(),
                NotificationEmailsSetting.SEND_NOTIFICATION_EMAILS,
                300L
        ));

    }
}
