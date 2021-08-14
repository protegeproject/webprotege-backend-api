package edu.stanford.protege.webprotege.project;

import edu.stanford.protege.webprotege.MockingUtils;
import edu.stanford.protege.webprotege.dispatch.Action;
import edu.stanford.protege.webprotege.dispatch.Result;

import org.junit.Test;

import java.io.IOException;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2021-04-07
 */
public class RemoveProjectsFromTrash_Serialization_TestCase {

    @Test
    public void shouldSerializeAction() throws IOException {
        var action = new RemoveProjectFromTrashAction(MockingUtils.mockProjectId());

    }

    @Test
    public void shouldSerializeResult() throws IOException {
        var result = new RemoveProjectFromTrashResult();

    }
}