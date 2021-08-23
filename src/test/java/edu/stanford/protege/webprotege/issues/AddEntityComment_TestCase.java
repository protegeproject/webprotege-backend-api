package edu.stanford.protege.webprotege.issues;

import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.common.UserId;
import edu.stanford.protege.webprotege.jackson.WebprotegeOwlApiJacksonApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.context.annotation.Import;

import java.io.IOException;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2021-04-05
 */
@JsonTest
@Import({WebprotegeOwlApiJacksonApplication.class})
public class AddEntityComment_TestCase {

    private static final String THE_COMMENT = "The comment";

    private final ProjectId projectId = ProjectId.valueOf("11111111-1111-1111-1111-111111111111");

    private final ThreadId threadId = new ThreadId("22222222-2222-2222-2222-222222222222");

    @Autowired
    private JacksonTester<AddCommentAction> tester;

    @Test
    public void shouldSerializeAction() throws IOException {
        var action = new AddCommentAction(projectId, threadId, THE_COMMENT);
        var json = tester.write(action);
        assertThat(json).hasJsonPathValue("projectId");
        assertThat(json).hasJsonPathValue("threadId");
        assertThat(json).hasJsonPathValue("comment");

    }
}
