package edu.stanford.protege.webprotege.dispatch.actions;

import edu.stanford.protege.webprotege.common.ChangeRequestId;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.entity.CreateClassesAction;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;

import java.io.IOException;

import static com.google.common.collect.ImmutableSet.of;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2021-04-06
 */
@JsonTest
public class CreateClasses_Serialization_TestCase {

    private final ChangeRequestId chgReqId = ChangeRequestId.valueOf("60b0125e-13bf-445b-bd5e-d8fc3926a244");

    private final ProjectId projectId = ProjectId.valueOf("25f4de2e-3428-4ee5-af67-44fa99da3b80");

    @Autowired
    private JacksonTester<CreateClassesAction> tester;

    @Test
    public void shouldSerializeAction() throws IOException {
        var action = new CreateClassesAction(chgReqId, projectId,
                                             "A\nB",
                                             "en", of());
        var json = tester.write(action);
        assertThat(json).hasJsonPathStringValue("changeRequestId", chgReqId.value());
        assertThat(json).hasJsonPathStringValue("projectId", projectId.value());
    }
}
