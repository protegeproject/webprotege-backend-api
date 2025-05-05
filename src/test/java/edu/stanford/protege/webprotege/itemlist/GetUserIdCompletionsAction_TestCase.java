package edu.stanford.protege.webprotege.itemlist;

import edu.stanford.protege.webprotege.user.GetUserIdCompletionsAction;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class GetUserIdCompletionsAction_TestCase {

    private final String completionText = "The completionText";

    private GetUserIdCompletionsAction action;

    @BeforeEach
    public void setUp()
            throws Exception {
        action = new GetUserIdCompletionsAction(completionText);
    }

    public void shouldThrowNullPointerExceptionIf_completionText_IsNull() {
        assertThrows(NullPointerException.class, () -> {
            new GetUserIdCompletionsAction(null);
        });
    }

    @Test
    public void shouldBeEqualToSelf() {
        MatcherAssert.assertThat(action, Matchers.is(action));
    }

    @Test
    public void shouldNotBeEqualToNull() {
        MatcherAssert.assertThat(action.equals(null), Matchers.is(false));
    }

    @Test
    public void shouldBeEqualToOther() {
        MatcherAssert.assertThat(action, Matchers.is(new GetUserIdCompletionsAction(completionText)));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_completionText() {
        MatcherAssert.assertThat(action, Matchers.is(Matchers.not(new GetUserIdCompletionsAction("String-629f6902-da3d-4a0e-ba06-71db635c07df"))));
    }

    @Test
    public void shouldBeEqualToOtherHashCode() {
        MatcherAssert.assertThat(action.hashCode(), Matchers.is(new GetUserIdCompletionsAction(completionText).hashCode()));
    }

    @Test
    public void shouldImplementToString() {
        MatcherAssert.assertThat(action.toString(), Matchers.startsWith("GetUserIdCompletionsAction"));
    }

}
