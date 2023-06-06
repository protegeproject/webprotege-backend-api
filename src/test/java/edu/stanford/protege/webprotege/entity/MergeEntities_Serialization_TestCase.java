package edu.stanford.protege.webprotege.entity;

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
public class MergeEntities_Serialization_TestCase {

    private ChangeRequestId changeRequestId = ChangeRequestId.generate();

    @Test
    public void shouldSerializeAction() throws IOException {
        var action = new MergeEntitiesAction(changeRequestId, mockProjectId(), ImmutableSet.of(),
                                             mockOWLClass(),
                                             MergedEntityTreatment.DELETE_MERGED_ENTITY,
                                             "Test");
        
    }

    @Test
    public void shouldSerializeResult() throws IOException {
        var result = new MergeEntitiesResult();
        
    }
}