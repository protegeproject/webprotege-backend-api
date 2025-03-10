package edu.stanford.protege.webprotege.tag;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Collections;

import static edu.stanford.protege.webprotege.MockingUtils.mockProjectId;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2021-04-07
 */
public class GetProjectTags_Serialization_TestCase {

    @Test
    public void shouldSerializeAction() throws IOException {
        var action = new GetProjectTagsAction(mockProjectId());

    }

    @Test
    public void shouldSerializeResult() throws IOException {
        var result = new GetProjectTagsResult(Collections.emptySet(),
                Collections.emptyMap());

    }
}