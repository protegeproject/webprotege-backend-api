package edu.stanford.protege.webprotege.tag;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
public class AddProjectTagResult_TestCase {

    private AddProjectTagResult result;

    @Mock
    private Tag addedTag;

    @BeforeEach
    public void setUp() {
        result = AddProjectTagResult.create(addedTag);
    }

    @Test
    public void shouldReturnSupplied_addedTag() {
        assertThat(result.getAddedTag(), is(Optional.of(this.addedTag)));
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
        assertThat(result, is(AddProjectTagResult.create(addedTag)));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_addedTag() {
        assertThat(result, is(not(AddProjectTagResult.create(mock(Tag.class)))));
    }

    @Test
    public void shouldBeEqualToOtherHashCode() {
        assertThat(result.hashCode(), is(AddProjectTagResult.create(addedTag).hashCode()));
    }

    @Test
    public void shouldImplementToString() {
        assertThat(result.toString(), startsWith("AddProjectTagResult"));
    }

}
