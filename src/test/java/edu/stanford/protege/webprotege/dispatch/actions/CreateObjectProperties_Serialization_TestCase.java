package edu.stanford.protege.webprotege.dispatch.actions;

import com.google.common.collect.ImmutableSet;
import edu.stanford.protege.webprotege.common.ChangeRequestId;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.entity.CreateObjectPropertiesAction;
import edu.stanford.protege.webprotege.entity.CreateObjectPropertiesResult;
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
public class CreateObjectProperties_Serialization_TestCase {

    private final ChangeRequestId changeRequestId = ChangeRequestId.generate();

    private final ProjectId projectId = ProjectId.generate();

    @Autowired
    private JacksonTester<CreateObjectPropertiesAction> tester;

    @Test
    public void shouldSerializeAction() throws IOException {
        var action = new CreateObjectPropertiesAction(changeRequestId, projectId, "P\nQ", "en", of());

        var json = tester.write(action);
        assertThat(json).hasJsonPathStringValue("changeRequestId", changeRequestId.value());
        assertThat(json).hasJsonPathStringValue("projectId", projectId.value());
        assertThat(json).hasJsonPathStringValue("sourceText", "P\nQ");
        assertThat(json).hasJsonPathStringValue("langTag", "en");
    }

    @Test
    public void shouldSerializeResult() throws IOException {
        var result = new CreateObjectPropertiesResult(ProjectId.generate(),
                ImmutableSet.of());

    }
}
