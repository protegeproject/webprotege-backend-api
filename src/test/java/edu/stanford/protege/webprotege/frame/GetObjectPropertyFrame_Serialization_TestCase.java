package edu.stanford.protege.webprotege.frame;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import edu.stanford.protege.webprotege.dispatch.Action;
import edu.stanford.protege.webprotege.dispatch.Result;
import edu.stanford.protege.webprotege.entity.OWLObjectPropertyData;

import org.junit.Test;

import java.io.IOException;


import static edu.stanford.protege.webprotege.MockingUtils.*;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2021-04-07
 */
public class GetObjectPropertyFrame_Serialization_TestCase {

    @Test
    public void shouldSerializeAction() throws IOException {
        var action = new GetObjectPropertyFrameAction(mockProjectId(),
                                                         mockOWLObjectProperty());

    }

    @Test
    public void shouldSerializeResult() throws IOException {
        var result = new GetObjectPropertyFrameResult(ObjectPropertyFrame.get(
                OWLObjectPropertyData.get(mockOWLObjectProperty(), ImmutableMap.of(), false),
                ImmutableSet.of(),
                ImmutableSet.of(),
                ImmutableSet.of(),
                ImmutableSet.of(),
                ImmutableSet.of()
        ));

    }
}