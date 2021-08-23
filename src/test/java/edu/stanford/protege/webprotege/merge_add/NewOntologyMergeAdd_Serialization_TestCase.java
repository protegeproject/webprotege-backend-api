package edu.stanford.protege.webprotege.merge_add;

import com.google.common.collect.ImmutableList;

import org.junit.Test;

import java.io.IOException;


import static edu.stanford.protege.webprotege.MockingUtils.*;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2021-04-07
 */
public class NewOntologyMergeAdd_Serialization_TestCase {

    @Test
    public void shouldSerializeAction() throws IOException {
        var action = new MergeOntologiesAction(mockProjectId(),
                                               mockDocumentId(),
                                               "Iri",
                                               ImmutableList.of());

    }

    @Test
    public void shouldSerializeResult() throws IOException {
        var result = new NewOntologyMergeAddResult();

    }
}