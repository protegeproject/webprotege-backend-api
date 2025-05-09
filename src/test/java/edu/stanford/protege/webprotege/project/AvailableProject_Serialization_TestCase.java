package edu.stanford.protege.webprotege.project;

import com.google.common.collect.ImmutableList;
import edu.stanford.protege.webprotege.common.DictionaryLanguage;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.common.UserId;
import edu.stanford.protege.webprotege.lang.DisplayNameSettings;
import edu.stanford.protege.webprotege.projectsettings.EntityDeprecationSettings;
import org.junit.jupiter.api.Test;

import java.io.IOException;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2021-04-06
 */
public class AvailableProject_Serialization_TestCase {

    @Test
    public void shouldSerializeAvailableProject() throws IOException {
        var projectDetails = ProjectDetails.get(ProjectId.valueOf("12345678-1234-1234-1234-123456789abc"),
                "The display name",
                "The description",
                UserId.valueOf("The Owner"),
                true,
                DictionaryLanguage.rdfsLabel("en-GB"),
                DisplayNameSettings.get(ImmutableList.of(DictionaryLanguage.rdfsLabel("en-GB"),
                                DictionaryLanguage.rdfsLabel("en"),
                                DictionaryLanguage.rdfsLabel("")),
                        ImmutableList.of(DictionaryLanguage.rdfsLabel("de"))),
                2L,
                UserId.valueOf("The creator"),
                3L,
                UserId.valueOf("The modifier"),
                EntityDeprecationSettings.empty());
        var availableProject = AvailableProject.get(ProjectId.valueOf("12345678-1234-1234-1234-123456789abc"),
                "The display name",
                "The description",
                UserId.valueOf("The Owner"),
                true, 1L, UserId.valueOf("Created By"),
                2L,
                UserId.valueOf("Modified By"),
                true,
                true,
                4L);
    }
}
