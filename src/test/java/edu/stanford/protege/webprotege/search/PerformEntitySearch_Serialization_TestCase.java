package edu.stanford.protege.webprotege.search;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import edu.stanford.protege.webprotege.common.LangTagFilter;
import edu.stanford.protege.webprotege.common.Page;
import edu.stanford.protege.webprotege.common.PageRequest;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Collections;

import static edu.stanford.protege.webprotege.MockingUtils.mockProjectId;


/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2021-04-07
 */
public class PerformEntitySearch_Serialization_TestCase {

    @Test
    public void shouldSerializeAction() throws IOException {
        var action = new PerformEntitySearchAction(mockProjectId(),
                "Test", Collections.emptySet(),
                LangTagFilter.get(ImmutableSet.of()), ImmutableList.of(),
                PageRequest.requestFirstPage(),
                null,
                DeprecatedEntitiesTreatment.EXCLUDE_DEPRECATED_ENTITIES);

    }

    @Test
    public void shouldSerializeResult() throws IOException {
        var result = new PerformEntitySearchResult("Test", Page.emptyPage());

    }
}