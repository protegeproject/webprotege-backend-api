package edu.stanford.protege.webprotege.issues;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsNot.not;

@ExtendWith(MockitoExtension.class)
public class CommentId_TestCase {

    private CommentId commentId;

    @BeforeEach
    public void setUp() {
        commentId = CommentId.create();
    }

    @Test
    public void shouldBeEqualToSelf() {
        assertThat(commentId, is(commentId));
    }

    @Test
    @SuppressWarnings("ObjectEqualsNull")
    public void shouldNotBeEqualToNull() {
        assertThat(commentId.equals(null), is(false));
    }

    @Test
    public void shouldNotBeEqualToOther() {
        assertThat(commentId, is(not(CommentId.create())));
    }


    @Test
    public void shouldNotBeEqualToOtherHashCode() {
        assertThat(commentId.hashCode(), is(not(CommentId.create().hashCode())));
    }

    @Test
    public void shouldImplementToString() {
        assertThat(commentId.toString(), Matchers.startsWith("CommentId"));
    }
}
