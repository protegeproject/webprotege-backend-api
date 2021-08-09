
package edu.stanford.protege.webprotege.itemlist;

import edu.stanford.protege.webprotege.sharing.PersonId;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.mock;

@RunWith(org.mockito.runners.MockitoJUnitRunner.class)
public class GetPersonIdCompletionsResult_TestCase {

    private GetPersonIdCompletionsResult result;

    @Mock
    private PersonId personId;

    private List<PersonId> possibleItemCompletions;

    @Before
    public void setUp()
        throws Exception
    {
        possibleItemCompletions = new ArrayList<>();
        possibleItemCompletions.add(personId);
        result = GetPersonIdCompletionsResult.create(possibleItemCompletions);
    }

    @Test(expected = java.lang.NullPointerException.class)
    public void shouldThrowNullPointerExceptionIf_possibleItemCompletions_IsNull() {
        GetPersonIdCompletionsResult.create(null);
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
        MatcherAssert.assertThat(result, Matchers.is(GetPersonIdCompletionsResult.create(possibleItemCompletions)));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_possibleItemCompletions() {
        MatcherAssert.assertThat(result, Matchers.is(Matchers.not(GetPersonIdCompletionsResult.create(Collections.singletonList(
                mock(PersonId.class))))));
    }

    @Test
    public void shouldBeEqualToOtherHashCode() {
        MatcherAssert.assertThat(result.hashCode(), Matchers.is(GetPersonIdCompletionsResult.create(possibleItemCompletions)
                                                                                            .hashCode()));
    }

    @Test
    public void shouldImplementToString() {
        MatcherAssert.assertThat(result.toString(), Matchers.startsWith("GetPersonIdCompletionsResult"));
    }

}
