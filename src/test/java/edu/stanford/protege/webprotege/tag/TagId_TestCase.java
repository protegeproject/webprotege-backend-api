package edu.stanford.protege.webprotege.tag;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.startsWith;

@ExtendWith(MockitoExtension.class)
public class TagId_TestCase {

    private static final String THE_ID = "12345678-1234-1234-1234-123456789abc";

    private TagId tagId;

    @BeforeEach
    public void setUp() {
        tagId = TagId.getId(THE_ID);
    }

    @Test
    public void shouldBeEqualToSelf() {
        assertThat(tagId, is(tagId));
    }

    @Test
    @SuppressWarnings("ObjectEqualsNull")
    public void shouldNotBeEqualToNull() {
        assertThat(tagId.equals(null), is(false));
    }

    @Test
    public void shouldBeEqualToOther() {
        assertThat(tagId, is(TagId.getId(THE_ID)));
    }

    @Test
    public void shouldBeEqualToOtherHashCode() {
        assertThat(tagId.hashCode(), is(TagId.getId(THE_ID).hashCode()));
    }

    @Test
    public void shouldImplementToString() {
        assertThat(tagId.toString(), startsWith("TagId"));
    }

    @Test
    public void should_getId() {
        assertThat(tagId.getId(), is(THE_ID));
    }

}
