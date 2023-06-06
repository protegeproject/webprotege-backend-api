package edu.stanford.protege.webprotege.project;

import com.google.common.collect.ImmutableList;
import edu.stanford.protege.webprotege.jackson.WebProtegeJacksonApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.context.annotation.Import;

import java.io.IOException;

import static edu.stanford.protege.webprotege.MockingUtils.mockProjectId;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2021-04-07
 */
@JsonTest
@Import(WebProtegeJacksonApplication.class)
public class GetProjectPrefixDeclarations_Serialization_TestCase {

    @Autowired
    private JacksonTester<GetProjectPrefixDeclarationsRequest> requestTester;

    @Autowired
    private JacksonTester<GetProjectPrefixDeclarationsResponse> responseTester;

    @Test
    public void shouldSerializeAction() throws IOException {
        var request = new GetProjectPrefixDeclarationsRequest(mockProjectId());
        var content = requestTester.write(request);
        var parsed = requestTester.parse(content.getJson());
        var parsedResult = parsed.getObject();
        assertThat(parsedResult).isEqualTo(request);

        
    }

    @Test
    public void shouldSerializeResult() throws IOException {
        var result = new GetProjectPrefixDeclarationsResponse(mockProjectId(), ImmutableList.of());
        var content = responseTester.write(result);
        var parsed = responseTester.parse(content.getJson());
        var parsedResult = parsed.getObject();
        assertThat(parsedResult).isEqualTo(result);
    }
}