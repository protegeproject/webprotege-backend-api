package edu.stanford.protege.webprotege.project;

import com.google.common.collect.ImmutableList;

import edu.stanford.protege.webprotege.common.ChangeRequestId;
import org.junit.Test;

import java.io.IOException;


import static edu.stanford.protege.webprotege.MockingUtils.*;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2021-04-07
 */
public class SetProjectPrefixDeclarations_Serialization_TestCase {

    @Test
    public void shouldSerializeAction() throws IOException {
        var action = new SetProjectPrefixDeclarationsAction(ChangeRequestId.generate(), mockProjectId(), ImmutableList.of(
                PrefixDeclaration.get("hello:", "http://example.org/")
        ));

    }

    @Test
    public void shouldSerializeResult() throws IOException {
        var result = new SetProjectPrefixDeclarationsResult(mockProjectId(),
                                                               ImmutableList.of());

    }
}