package edu.stanford.protege.webprotege.tag;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collection;
import java.util.Collections;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
public class GetEntityTagsResult_TestCase {

    private GetEntityTagsResult result;

    private Collection<Tag> entityTags;

    private Collection<Tag> projectTags;

    @BeforeEach
    public void setUp() {
        entityTags = Collections.singletonList(mock(Tag.class));
        projectTags = Collections.singletonList(mock(Tag.class));
        result = new GetEntityTagsResult(entityTags, projectTags);
    }

    @SuppressWarnings("ConstantConditions")
    public void shouldThrowNullPointerExceptionIf_entityTags_IsNull() {
        assertThrows(NullPointerException.class, () -> {
            new GetEntityTagsResult(null, projectTags);
        });
    }

    @Test
    public void shouldReturnSupplied_entityTags() {
        assertThat(result.entityTags(), is(this.entityTags));
    }

    @SuppressWarnings("ConstantConditions")
    public void shouldThrowNullPointerExceptionIf_projectTags_IsNull() {
        assertThrows(NullPointerException.class, () -> {
            new GetEntityTagsResult(entityTags, null);
        });
    }

    @Test
    public void shouldReturnSupplied_projectTags() {
        assertThat(result.projectTags(), is(this.projectTags));
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
        assertThat(result, is(new GetEntityTagsResult(entityTags, projectTags)));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_entityTags() {
        assertThat(result, is(Matchers.not(new GetEntityTagsResult(Collections.singletonList(mock(Tag.class)), projectTags))));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_projectTags() {
        assertThat(result, is(Matchers.not(new GetEntityTagsResult(entityTags, Collections.singletonList(mock(Tag.class))))));
    }

    @Test
    public void shouldBeEqualToOtherHashCode() {
        assertThat(result.hashCode(), is(new GetEntityTagsResult(entityTags, projectTags).hashCode()));
    }

    @Test
    public void shouldImplementToString() {
        assertThat(result.toString(), Matchers.startsWith("GetEntityTagsResult"));
    }

}
