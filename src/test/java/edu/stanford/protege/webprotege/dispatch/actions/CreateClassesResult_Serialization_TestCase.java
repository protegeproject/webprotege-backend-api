package edu.stanford.protege.webprotege.dispatch.actions;

import com.google.common.collect.ImmutableSet;
import edu.stanford.protege.webprotege.common.ChangeRequestId;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.entity.CreateClassesResult;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2022-02-18
 */
@JsonTest
public class CreateClassesResult_Serialization_TestCase {


    private final ChangeRequestId chgReqId = ChangeRequestId.valueOf("60b0125e-13bf-445b-bd5e-d8fc3926a244");

    private final ProjectId projectId = ProjectId.valueOf("25f4de2e-3428-4ee5-af67-44fa99da3b80");

    @Autowired
    private JacksonTester<CreateClassesResult> tester;



    @Test
    public void shouldSerializeResult() throws IOException {
        var result = new CreateClassesResult(chgReqId,
                                             projectId,
                                             ImmutableSet.of());
        var json = tester.write(result);
        assertThat(json).hasJsonPathStringValue("changeRequestId", chgReqId.value());
        assertThat(json).hasJsonPathStringValue("projectId", projectId.value());
    }
}
