package edu.stanford.protege.webprotege.perspective;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import edu.stanford.protege.webprotege.common.ChangeRequestId;
import edu.stanford.protege.webprotege.common.LanguageMap;
import org.junit.Test;

import java.io.IOException;

import static edu.stanford.protege.webprotege.MockingUtils.mockProjectId;
import static edu.stanford.protege.webprotege.MockingUtils.mockUserId;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2021-04-07
 */
public class SetPerspectives_Serialization_TestCase {

    @Test
    public void shouldSerializeAction() throws IOException {
        var action = new SetPerspectivesAction(ChangeRequestId.generate(), mockProjectId(),
                                               mockUserId(), ImmutableList.of(
                        PerspectiveDescriptor.get(PerspectiveId.generate(),
                                                  LanguageMap.of("en", "Hello"),
                                                  true)
                ));
        
    }

    @Test
    public void shouldSerializeResult() throws IOException {
        var result = new SetPerspectivesResult(ImmutableList.of(), ImmutableSet.of());
        
    }
}