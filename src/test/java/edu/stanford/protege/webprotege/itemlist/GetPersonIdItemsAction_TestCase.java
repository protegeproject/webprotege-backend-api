
package edu.stanford.protege.webprotege.itemlist;

import edu.stanford.protege.webprotege.MockingUtils;
import edu.stanford.protege.webprotege.common.ProjectId;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RunWith(org.mockito.runners.MockitoJUnitRunner.class)
public class GetPersonIdItemsAction_TestCase {

    private GetPersonIdItemsAction action;

    private List<String> itemNames;

    private ProjectId projectId = MockingUtils.mockProjectId();

    @Before
    public void setUp()
        throws Exception
    {
        itemNames = new ArrayList<>();
        action = new GetPersonIdItemsAction(projectId, itemNames);
    }

    @Test(expected = java.lang.NullPointerException.class)
    public void shouldThrowNullPointerExceptionIf_itemNames_IsNull() {
        new GetPersonIdItemsAction(projectId, null);
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
        MatcherAssert.assertThat(action, Matchers.is(new GetPersonIdItemsAction(projectId, itemNames)));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_itemNames() {
        List<String> otherItemNames = Collections.singletonList("Other Item");
        MatcherAssert.assertThat(action, Matchers.is(Matchers.not(new GetPersonIdItemsAction(projectId, otherItemNames))));
    }

    @Test
    public void shouldBeEqualToOtherHashCode() {
        MatcherAssert.assertThat(action.hashCode(), Matchers.is(new GetPersonIdItemsAction(projectId, itemNames).hashCode()));
    }

    @Test
    public void shouldImplementToString() {
        MatcherAssert.assertThat(action.toString(), Matchers.startsWith("GetPersonIdItemsAction"));
    }

}
