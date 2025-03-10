package edu.stanford.protege.webprotege.change;

import edu.stanford.protege.webprotege.common.Page;
import edu.stanford.protege.webprotege.common.PageRequest;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Optional;

import static edu.stanford.protege.webprotege.MockingUtils.mockProjectId;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2021-04-07
 */
public class GetProjectChanges_Serialization_TestCase {

    @Test
    public void shouldSerializeAction() throws IOException {
        var action = new GetProjectChangesAction(mockProjectId(),
                Optional.empty(),
                PageRequest.requestFirstPage());

    }

    @Test
    public void shouldSerializeResult() throws IOException {
        var result = new GetProjectChangesResult(Page.emptyPage());

    }
}