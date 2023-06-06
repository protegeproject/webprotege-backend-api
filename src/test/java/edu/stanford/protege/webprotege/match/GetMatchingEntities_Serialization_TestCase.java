package edu.stanford.protege.webprotege.match;

import com.google.common.collect.ImmutableList;
import edu.stanford.protege.webprotege.common.Page;
import edu.stanford.protege.webprotege.common.PageRequest;
import edu.stanford.protege.webprotege.criteria.CompositeRootCriteria;
import edu.stanford.protege.webprotege.criteria.MultiMatchType;
import org.junit.Test;

import java.io.IOException;

import static edu.stanford.protege.webprotege.MockingUtils.mockProjectId;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2021-04-07
 */
public class GetMatchingEntities_Serialization_TestCase {

    @Test
    public void shouldSerializeAction() throws IOException {
        var action = new GetMatchingEntitiesAction(mockProjectId(),
                                                      CompositeRootCriteria.get(ImmutableList.of(), MultiMatchType.ALL),
                                                      PageRequest.requestFirstPage());
        
    }

    @Test
    public void shouldSerializeResult() throws IOException {
        var result = new GetMatchingEntitiesResult(Page.emptyPage());
        
    }
}