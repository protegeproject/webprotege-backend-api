package edu.stanford.protege.webprotege.lang;

import com.google.common.collect.ImmutableSet;
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
public abstract class GetProjectLangTags_Serialization_TestCase {

    @Test
    public void shouldSerializeAction() throws IOException {
        var action = new GetProjectLangTagsAction(mockProjectId());
        
    }

    @Test
    public void shouldSerializeResult() throws IOException {
        var result = new GetProjectLangTagsResult(mockProjectId(), ImmutableSet.of());
        
    }
}