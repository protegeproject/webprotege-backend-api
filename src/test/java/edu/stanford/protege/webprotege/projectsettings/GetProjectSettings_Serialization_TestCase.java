package edu.stanford.protege.webprotege.projectsettings;

import com.google.common.collect.ImmutableList;
import edu.stanford.protege.webprotege.dispatch.Action;
import edu.stanford.protege.webprotege.dispatch.Result;
import edu.stanford.protege.webprotege.lang.DisplayNameSettings;

import edu.stanford.protege.webprotege.common.DictionaryLanguage;
import org.junit.Test;

import java.io.IOException;


import static edu.stanford.protege.webprotege.MockingUtils.*;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2021-04-07
 */
public class GetProjectSettings_Serialization_TestCase {

    @Test
    public void shouldSerializeAction() throws IOException {
        var action = new GetProjectSettingsAction(mockProjectId());

    }

    @Test
    public void shouldSerializeResult() throws IOException {
        var result = new GetProjectSettingsResult(ProjectSettings.get(
                mockProjectId(),
                "The display name",
                "The description",
                DictionaryLanguage.localName(),
                DisplayNameSettings.empty(),
                SlackIntegrationSettings.get("url"),
                WebhookSettings.get(ImmutableList.of()),
                EntityDeprecationSettings.empty()
        ));

    }
}