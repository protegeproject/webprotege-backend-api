
package edu.stanford.protege.webprotege.itemlist;

import com.google.common.collect.ImmutableList;
import edu.stanford.protege.webprotege.common.UserId;
import edu.stanford.protege.webprotege.user.GetUserIdCompletionsResult;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(org.mockito.runners.MockitoJUnitRunner.class)
public class GetUserIdCompletionsResult_TestCase {

    private GetUserIdCompletionsResult result;

    private UserId userId = new UserId("UserA");

    private ImmutableList<UserId> possibleItemCompletions;

    @Before
    public void setUp()
        throws Exception
    {
        possibleItemCompletions = ImmutableList.of(userId);
        result = new GetUserIdCompletionsResult(possibleItemCompletions);
    }

    @Test(expected = java.lang.NullPointerException.class)
    public void shouldThrowNullPointerExceptionIf_possibleItemCompletions_IsNull() {
        new GetUserIdCompletionsResult(null);
    }

    @Test
    public void shouldBeEqualToSelf() {
        MatcherAssert.assertThat(result, Matchers.is(result));
    }

    @Test
    public void shouldNotBeEqualToNull() {
        MatcherAssert.assertThat(result.equals(null), Matchers.is(false));
    }

    @Test
    public void shouldBeEqualToOther() {
        MatcherAssert.assertThat(result, Matchers.is(new GetUserIdCompletionsResult(possibleItemCompletions)));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_possibleItemCompletions() {
        MatcherAssert.assertThat(result, Matchers.is(Matchers.not(new GetUserIdCompletionsResult(ImmutableList.of(
                new UserId("OtherUser"))))));
    }

    @Test
    public void shouldBeEqualToOtherHashCode() {
        MatcherAssert.assertThat(result.hashCode(), Matchers.is(new GetUserIdCompletionsResult(possibleItemCompletions)
                                                                                          .hashCode()));
    }

    @Test
    public void shouldImplementToString() {
        MatcherAssert.assertThat(result.toString(), Matchers.startsWith("GetUserIdCompletionsResult"));
    }

}
