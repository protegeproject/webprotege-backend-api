package edu.stanford.protege.webprotege.dispatch.actions;

import edu.stanford.protege.webprotege.ontology.GetRootOntologyIdAction;
import edu.stanford.protege.webprotege.ontology.GetRootOntologyIdResult;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static edu.stanford.protege.webprotege.MockingUtils.mockOWLOntologyID;
import static edu.stanford.protege.webprotege.MockingUtils.mockProjectId;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2021-04-07
 */
public class GetRootOntologyId_Serialization_TestCase {

    @Test
    public void shouldSerializeAction() throws IOException {
        var action = new GetRootOntologyIdAction(mockProjectId());

    }

    @Test
    public void shouldSerializeResult() throws IOException {
        var result = new GetRootOntologyIdResult(mockProjectId(), mockOWLOntologyID());

    }
}