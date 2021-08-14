package edu.stanford.protege.webprotege.search;

import com.google.common.collect.ImmutableList;
import edu.stanford.protege.webprotege.dispatch.Action;
import edu.stanford.protege.webprotege.dispatch.Result;
import edu.stanford.protege.webprotege.common.LanguageMap;

import edu.stanford.protege.webprotege.criteria.CompositeRootCriteria;
import edu.stanford.protege.webprotege.criteria.MultiMatchType;
import org.junit.Test;

import java.io.IOException;


import static edu.stanford.protege.webprotege.MockingUtils.*;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2021-04-07
 */
public class SetSearchSettings_Serialization_TestCase {

    @Test
    public void shouldSerializeAction() throws IOException {
        var action = new SetSearchSettingsAction(mockProjectId(), ImmutableList.of(
                EntitySearchFilter.get(EntitySearchFilterId.createFilterId(),
                                       mockProjectId(),
                                       LanguageMap.of("en", "Test"), CompositeRootCriteria.get(ImmutableList.of(),
                                                                                               MultiMatchType.ALL))
        ), ImmutableList.of());
        
    }

    @Test
    public void shouldSerializeResult() throws IOException {
        var result = new SetSearchSettingsResult();
        
    }
}