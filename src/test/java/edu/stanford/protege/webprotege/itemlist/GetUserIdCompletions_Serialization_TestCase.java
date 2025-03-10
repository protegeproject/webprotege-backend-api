package edu.stanford.protege.webprotege.itemlist;

import com.google.common.collect.ImmutableList;
import edu.stanford.protege.webprotege.user.GetUserIdCompletionsAction;
import edu.stanford.protege.webprotege.user.GetUserIdCompletionsResult;
import org.junit.jupiter.api.Test;

import java.io.IOException;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2021-04-07
 */
public class GetUserIdCompletions_Serialization_TestCase {

    @Test
    public void shouldSerializeAction() throws IOException {
        var action = new GetUserIdCompletionsAction("Text");

    }

    @Test
    public void shouldSerializeResult() throws IOException {
        var result = new GetUserIdCompletionsResult(ImmutableList.of());

    }
}