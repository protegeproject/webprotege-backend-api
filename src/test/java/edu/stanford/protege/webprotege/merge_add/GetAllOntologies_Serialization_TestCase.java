package edu.stanford.protege.webprotege.merge_add;

import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.csv.DocumentId;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Collections;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2021-04-06
 */
public class GetAllOntologies_Serialization_TestCase {


    @Test
    public void shouldSerializeAction() throws IOException {
        var action = new GetUploadedOntologiesAction(ProjectId.generate(),
                new DocumentId("abc"));

    }

    @Test
    public void shouldSerializeResult() throws IOException {
        var result = new GetUploadedOntologiesResult(Collections.emptyList());

    }
}
