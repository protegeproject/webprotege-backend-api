package edu.stanford.protege.webprotege.revision;

import com.google.common.collect.ImmutableList;
import edu.stanford.protege.webprotege.common.Page;
import edu.stanford.protege.webprotege.common.PageRequest;
import edu.stanford.protege.webprotege.dispatch.Action;
import edu.stanford.protege.webprotege.dispatch.Result;

import org.junit.Test;

import java.io.IOException;


import static edu.stanford.protege.webprotege.MockingUtils.*;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2021-04-07
 */
public class GetRevisionSummaries_Serialization_TestCase {

    @Test
    public void shouldSerializeAction() throws IOException {
        var action = new GetRevisionSummariesAction(mockProjectId(), PageRequest.requestFirstPage());

    }

    @Test
    public void shouldSerializeResult() throws IOException {
        var result = new GetRevisionSummariesResult(Page.emptyPage());

    }
}