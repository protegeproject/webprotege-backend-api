package edu.stanford.protege.webprotege.project;

import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.dispatch.Action;
import edu.stanford.protege.webprotege.dispatch.Result;
import edu.stanford.protege.webprotege.lang.DisplayNameSettings;

import edu.stanford.protege.webprotege.projectsettings.EntityDeprecationSettings;
import edu.stanford.protege.webprotege.common.DictionaryLanguage;
import edu.stanford.protege.webprotege.user.UserId;
import org.junit.Test;

import java.io.IOException;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2021-04-06
 */
public class LoadProjectAction_Serialization_TestCase {

    @Test
    public void shouldSerializeAction() throws IOException {
        var action = new LoadProjectAction(ProjectId.generate());

    }

    @Test
    public void shouldSerializeResult() throws IOException {
        var result = new LoadProjectResult(ProjectId.generate(), UserId.getGuest(),
                                           ProjectDetails.get(
                                                   ProjectId.generate(),
                                                   "The display name",
                                                   "The description",
                                                   UserId.getGuest(),
                                                   false, DictionaryLanguage.localName(),
                                                   DisplayNameSettings.empty(),
                                                   1,
                                                   UserId.getGuest(),
                                                   2,
                                                   UserId.getGuest(),
                                                   EntityDeprecationSettings.empty()
                                           ));

    }
}
