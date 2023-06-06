package edu.stanford.protege.webprotege.tag;

import com.google.common.collect.ImmutableSet;
import edu.stanford.protege.webprotege.common.ChangeRequestId;
import org.junit.Test;

import java.io.IOException;

import static edu.stanford.protege.webprotege.MockingUtils.mockOWLClass;
import static edu.stanford.protege.webprotege.MockingUtils.mockProjectId;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2021-04-07
 */
public class UpdateEntityTags_Serialization_TestCase {

    @Test
    public void shouldSerializeAction() throws IOException {
        var action = new UpdateEntityTagsAction(ChangeRequestId.generate(), mockProjectId(),
                                                mockOWLClass(),
                                                ImmutableSet.of(TagId.createTagId()),
                                                ImmutableSet.of());
        
    }

    @Test
    public void shouldSerializeResult() throws IOException {
        var result = new UpdateEntityTagsResult();
        
    }
}