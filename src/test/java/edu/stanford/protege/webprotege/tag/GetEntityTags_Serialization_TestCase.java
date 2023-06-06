package edu.stanford.protege.webprotege.tag;

import edu.stanford.protege.webprotege.common.ProjectId;
import org.junit.Test;

import java.io.IOException;
import java.util.Collections;

import static edu.stanford.protege.webprotege.MockingUtils.mockOWLClass;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2021-04-07
 */
public class GetEntityTags_Serialization_TestCase {

    @Test
    public void shouldSerializeAction() throws IOException {
        var action = new GetEntityTagsAction(ProjectId.generate(),
                                                mockOWLClass());
        
    }

    @Test
    public void shouldSerializeResult() throws IOException {
        var result = new GetEntityTagsResult(Collections.emptySet(),
                                                Collections.emptySet());
        
    }
}