package edu.stanford.protege.webprotege.merge;

import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.csv.DocumentId;
import org.junit.Test;

import java.io.IOException;
import java.util.Collections;
import java.util.UUID;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2021-04-06
 */
public class ComputeProjectMerge_Serialization_TestCase {

    @Test
    public void shouldSerializeAction() throws IOException {
        var action = new ComputeProjectMergeAction(ProjectId.generate(),
                                                      new DocumentId(UUID.randomUUID().toString()));
        
    }

    @Test
    public void shouldSerializeResult() throws IOException {
        var result = new ComputeProjectMergeResult(Collections.emptyList());
        
    }
}
