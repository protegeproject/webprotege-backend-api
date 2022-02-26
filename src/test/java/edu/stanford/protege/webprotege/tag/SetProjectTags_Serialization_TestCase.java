package edu.stanford.protege.webprotege.tag;

import com.google.common.collect.ImmutableList;
import edu.stanford.protege.webprotege.color.Color;

import edu.stanford.protege.webprotege.common.ChangeRequestId;
import org.junit.Test;

import java.io.IOException;


import static edu.stanford.protege.webprotege.MockingUtils.*;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2021-04-07
 */
public class SetProjectTags_Serialization_TestCase {

    @Test
    public void shouldSerializeAction() throws IOException {
        var action = new SetProjectTagsAction(ChangeRequestId.generate(), mockProjectId(), ImmutableList.of(
                TagData.get(TagId.createTagId(),
                            "Label",
                            "Description",
                            Color.getWhite(),
                            Color.getWhite(),
                            ImmutableList.of(),
                            22)
        ));

    }

    @Test
    public void shouldSerializeResult() throws IOException {
        var result = new SetProjectTagsResult();

    }
}