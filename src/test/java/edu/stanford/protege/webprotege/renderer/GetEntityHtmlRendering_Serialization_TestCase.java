package edu.stanford.protege.webprotege.renderer;

import edu.stanford.protege.webprotege.common.ProjectId;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static edu.stanford.protege.webprotege.MockingUtils.mockOWLClass;
import static edu.stanford.protege.webprotege.MockingUtils.mockOWLClassData;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2021-04-07
 */
public class GetEntityHtmlRendering_Serialization_TestCase {


    @Test
    public void shouldSerializeAction() throws IOException {
        var action = new GetEntityHtmlRenderingAction(ProjectId.generate(),
                mockOWLClass());
    }

    @Test
    public void shouldSerializeResult() throws IOException {
        var result = new GetEntityHtmlRenderingResult(mockOWLClassData(),
                "TheRendering");

    }
}
