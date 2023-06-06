
package edu.stanford.protege.webprotege.tag;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Collections;
import java.util.Map;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class)
public class GetProjectTagsResult_TestCase {

    private GetProjectTagsResult result;

    private Set<Tag> tags;

    private Map<TagId, Integer> tagUsage;

    @Before
    public void setUp() {
        tags = Collections.singleton(mock(Tag.class));
        tagUsage = ImmutableMap.of(mock(TagId.class), 1);
        result = new GetProjectTagsResult(tags, tagUsage);
    }

    @SuppressWarnings("ConstantConditions")
    @Test(expected = NullPointerException.class)
    public void shouldThrowNullPointerExceptionIf_tags_IsNull() {
        new GetProjectTagsResult(null, tagUsage);
    }

    @Test
    public void shouldReturnSupplied_tags() {
        assertThat(result.tags(), is(this.tags));
    }

    @SuppressWarnings("ConstantConditions")
    @Test(expected = NullPointerException.class)
    public void shouldThrowNullPointerExceptionIf_tagUsage_IsNull() {
        new GetProjectTagsResult(tags, null);
    }

    @Test
    public void shouldReturnSupplied_tagUsage() {
        assertThat(result.tagUsage(), is(this.tagUsage));
    }

    @Test
    public void shouldBeEqualToSelf() {
        assertThat(result, is(result));
    }

    @Test
    @SuppressWarnings("ObjectEqualsNull")
    public void shouldNotBeEqualToNull() {
        assertThat(result.equals(null), is(false));
    }

    @Test
    public void shouldBeEqualToOther() {
        assertThat(result, is(new GetProjectTagsResult(tags, tagUsage)));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_tags() {
        assertThat(result, is(not(new GetProjectTagsResult(ImmutableSet.of(mock(Tag.class)), tagUsage))));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_tagUsage() {
        assertThat(result, is(not(new GetProjectTagsResult(tags, ImmutableMap.of(mock(TagId.class), 2)))));
    }

    @Test
    public void shouldBeEqualToOtherHashCode() {
        assertThat(result.hashCode(), is(new GetProjectTagsResult(tags, tagUsage).hashCode()));
    }

    @Test
    public void shouldImplementToString() {
        assertThat(result.toString(), startsWith("GetProjectTagsResult"));
    }

}
