package edu.stanford.protege.webprotege.entity;

import com.google.common.collect.ImmutableList;
import edu.stanford.protege.webprotege.common.DictionaryLanguage;
import edu.stanford.protege.webprotege.search.SearchResultMatch;
import edu.stanford.protege.webprotege.search.SearchResultMatchPosition;
import org.junit.Test;

import java.io.IOException;

import static edu.stanford.protege.webprotege.MockingUtils.mockOWLClassNode;
import static edu.stanford.protege.webprotege.MockingUtils.mockProjectId;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2021-04-07
 */
public class LookupEntities_Serialization_TestCase {

    @Test
    public void shouldSerializeAction() throws IOException {
        var action = new LookupEntitiesAction(mockProjectId(),
                                                 new EntityLookupRequest("Search"));

    }

    @Test
    public void shouldSerializeResult() throws IOException {
        var result = new LookupEntitiesResult(ImmutableList.of(
                new EntityLookupResult(SearchResultMatch.get(mockOWLClassNode(),
                                                             DictionaryLanguage.localName(),
                                                             "Search",
                                                             ImmutableList.of(SearchResultMatchPosition.get(2, 4))),
                                       "link")
        ));

    }
}