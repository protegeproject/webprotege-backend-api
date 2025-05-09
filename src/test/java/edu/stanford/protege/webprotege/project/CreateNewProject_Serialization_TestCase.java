package edu.stanford.protege.webprotege.project;

import com.google.common.collect.ImmutableList;
import edu.stanford.protege.webprotege.common.DictionaryLanguage;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.common.UserId;
import edu.stanford.protege.webprotege.csv.DocumentId;
import edu.stanford.protege.webprotege.lang.DisplayNameSettings;
import edu.stanford.protege.webprotege.projectsettings.EntityDeprecationSettings;
import org.junit.jupiter.api.Test;

import java.io.IOException;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2021-04-06
 */
public class CreateNewProject_Serialization_TestCase {

    @Test
    public void shouldSerializeAction() throws IOException {
        var action = new CreateNewProjectAction(ProjectId.generate(),
                NewProjectSettings.get(UserId.getGuest(),
                        "DisplayName",
                        "en",
                        "The description",
                        new DocumentId("TheDocId")
                ));
    }

    @Test
    public void shouldSerializeResult() throws IOException {
        var result = new CreateNewProjectResult(ProjectDetails.get(
                ProjectId.getNil(),
                "The display name",
                "The description",
                UserId.getGuest(),
                true, DictionaryLanguage.localName(),
                DisplayNameSettings.get(ImmutableList.of(), ImmutableList.of()),
                1,
                UserId.getGuest(),
                3,
                UserId.getGuest(),
                EntityDeprecationSettings.empty()
        ));
    }
}
