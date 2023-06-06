package edu.stanford.protege.webprotege.entity;

import com.google.common.collect.ImmutableSet;
import edu.stanford.protege.webprotege.common.ChangeRequestId;
import edu.stanford.protege.webprotege.common.ProjectId;
import org.junit.Test;

import java.io.IOException;


/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2021-04-06
 */
public class DeleteEntities_Serialization_TestCase {


    @Test
    public void shouldSerializeAction() throws IOException {
        var action = new DeleteEntitiesAction(ChangeRequestId.generate(),
                                              ProjectId.generate(),
                                              ImmutableSet.of());
        
    }

    @Test
    public void shouldSerializeResult() throws IOException {
        var result = new DeleteEntitiesResult(ImmutableSet.of());
        
    }
}
