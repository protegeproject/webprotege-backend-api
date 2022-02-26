package edu.stanford.protege.webprotege.dispatch.actions;

import edu.stanford.protege.webprotege.common.ChangeRequestId;
import edu.stanford.protege.webprotege.dispatch.Action;
import edu.stanford.protege.webprotege.dispatch.Result;

import edu.stanford.protege.webprotege.ontology.SetOntologyAnnotationsAction;
import edu.stanford.protege.webprotege.ontology.SetOntologyAnnotationsResult;
import org.junit.Test;

import java.io.IOException;
import java.util.Collections;


import static edu.stanford.protege.webprotege.MockingUtils.*;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2021-04-07
 */
public class SetOntologyAnnotations_Serialization_TestCase {

    @Test
    public void shouldSerializeAction() throws IOException {
        var action = new SetOntologyAnnotationsAction(ChangeRequestId.generate(),
                                                      mockProjectId(),
                                                      mockOWLOntologyID(),
                                                      Collections.emptySet(),
                                                      Collections.emptySet());
        
    }

    @Test
    public void shouldSerializeResult() throws IOException {
        var result = new SetOntologyAnnotationsResult(Collections.emptySet());
        
    }
}