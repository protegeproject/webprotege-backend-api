package edu.stanford.protege.webprotege.dispatch.actions;

import com.google.common.collect.ImmutableList;
import edu.stanford.protege.webprotege.ontology.GetOntologyAnnotationsAction;
import edu.stanford.protege.webprotege.ontology.GetOntologyAnnotationsResult;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Optional;

import static edu.stanford.protege.webprotege.MockingUtils.mockOWLOntologyID;
import static edu.stanford.protege.webprotege.MockingUtils.mockProjectId;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2021-04-07
 */
public class GetOntologyAnnotations_Serialization_TestCase {

    @Test
    public void shouldSerializeAction() throws IOException {
        var action = new GetOntologyAnnotationsAction(mockProjectId(),
                Optional.empty());

    }

    @Test
    public void shouldSerializeResult() throws IOException {
        var result = new GetOntologyAnnotationsResult(mockOWLOntologyID(), ImmutableList.of());

    }
}