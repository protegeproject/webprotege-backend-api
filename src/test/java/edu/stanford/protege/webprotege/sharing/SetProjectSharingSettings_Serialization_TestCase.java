package edu.stanford.protege.webprotege.sharing;

import com.google.common.collect.ImmutableList;
import edu.stanford.protege.webprotege.common.ChangeRequestId;
import edu.stanford.protege.webprotege.common.ProjectId;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Optional;

import static edu.stanford.protege.webprotege.MockingUtils.mockProjectId;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2021-04-07
 */
public class SetProjectSharingSettings_Serialization_TestCase {

    @Test
    public void shouldSerializeAction() throws IOException {
        var action = new SetProjectSharingSettingsAction(ChangeRequestId.generate(), ProjectId.generate(), new ProjectSharingSettings(
                mockProjectId(),
                Optional.of(SharingPermission.EDIT), ImmutableList.of(
                new SharingSetting(PersonId.get("User"), SharingPermission.EDIT)
        )
        ));

    }

    @Test
    public void shouldSerializeResult() throws IOException {
        var result = new SetProjectSharingSettingsResult();

    }
}