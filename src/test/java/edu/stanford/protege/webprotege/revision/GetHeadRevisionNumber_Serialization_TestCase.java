package edu.stanford.protege.webprotege.revision;

import edu.stanford.protege.webprotege.common.ProjectId;
import org.junit.jupiter.api.Test;

import java.io.IOException;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2021-04-07
 */
public class GetHeadRevisionNumber_Serialization_TestCase {

    @Test
    public void shouldSerializeAction() throws IOException {
        var action = new GetHeadRevisionNumberAction(ProjectId.generate());

    }

    @Test
    public void shouldSerializeResult() throws IOException {
        var result = new GetHeadRevisionNumberResult(ProjectId.generate(), RevisionNumber.getHeadRevisionNumber());

    }
}