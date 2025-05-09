package edu.stanford.protege.webprotege.project;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.stanford.protege.webprotege.common.ProjectId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2 Feb 2018
 */
public class ProjectId_Json_TestCase {


    private static final String THE_UUID = "0d8f03d4-d9bb-496d-a78c-146868af8265";

    private ProjectId projectId;

    @BeforeEach
    public void setUp() throws Exception {
        projectId = ProjectId.valueOf(THE_UUID);
    }

    @Test
    public void shouldSerializeJson() throws Exception {
        String result = new ObjectMapper().writeValueAsString(projectId);
        assertThat(result, is("\"" + THE_UUID + "\""));
    }

    @Test
    public void shouldDeserializeJson() throws Exception {
        ProjectId readProjectId = new ObjectMapper()
                .readerFor(ProjectId.class)
                .readValue("\"" + THE_UUID + "\"");
        assertThat(readProjectId, is(projectId));
    }
}
