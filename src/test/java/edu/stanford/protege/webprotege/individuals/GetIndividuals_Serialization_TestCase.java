package edu.stanford.protege.webprotege.individuals;

import edu.stanford.protege.webprotege.dispatch.Action;
import edu.stanford.protege.webprotege.dispatch.Result;
import edu.stanford.protege.webprotege.match.JsonSerializationTestUtil;
import edu.stanford.protege.webprotege.pagination.Page;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.pagination.PageRequest;
import org.junit.Test;

import java.io.IOException;
import java.util.Optional;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2021-04-07
 */
public class GetIndividuals_Serialization_TestCase {

    @Test
    public void shouldSerializeAction() throws IOException {
        var action = new GetIndividualsAction(ProjectId.generate(),
                                              null,
                                              PageRequest.requestFirstPage(),
                                              "Hello",
                                              InstanceRetrievalMode.ALL_INSTANCES);
        JsonSerializationTestUtil.testSerialization(action, Action.class);
    }

    @Test
    public void shouldSerializeResult() throws IOException {
        var result = new GetIndividualsResult(Optional.empty(),
                                                 Page.emptyPage());
        JsonSerializationTestUtil.testSerialization(result, Result.class);
    }
}