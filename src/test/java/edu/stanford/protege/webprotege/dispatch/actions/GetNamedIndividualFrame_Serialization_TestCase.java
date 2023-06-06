package edu.stanford.protege.webprotege.dispatch.actions;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import edu.stanford.protege.webprotege.entity.OWLNamedIndividualData;
import edu.stanford.protege.webprotege.frame.GetNamedIndividualFrameAction;
import edu.stanford.protege.webprotege.frame.GetNamedIndividualFrameResult;
import edu.stanford.protege.webprotege.frame.NamedIndividualFrame;
import org.junit.Test;

import java.io.IOException;

import static edu.stanford.protege.webprotege.MockingUtils.mockOWLNamedIndividual;
import static edu.stanford.protege.webprotege.MockingUtils.mockProjectId;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2021-04-07
 */
public class GetNamedIndividualFrame_Serialization_TestCase {

    @Test
    public void shouldSerializeAction() throws IOException {
        var action = new GetNamedIndividualFrameAction(mockProjectId(),
                                                          mockOWLNamedIndividual());
        
    }

    @Test
    public void shouldSerializeResult() throws IOException {
        var result = new GetNamedIndividualFrameResult(NamedIndividualFrame.get(
                OWLNamedIndividualData.get(mockOWLNamedIndividual(),
                                           ImmutableMap.of(), false), ImmutableSet.of(),
                ImmutableSet.of(),
                ImmutableSet.of()
        ));
        
    }
}