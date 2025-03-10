package edu.stanford.protege.webprotege.issues;

import edu.stanford.protege.webprotege.common.UserId;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class Comment_TestCase {

    private final long createdAt = 1L;

    private final Optional updatedAt = Optional.of(33L);

    private final String body = "The body";

    private final String renderedBody = "The renderedBody";

    private final UserId createdBy = new UserId("UserA");

    private Comment comment;

    @Mock
    private CommentId id;

    @BeforeEach
    public void setUp()
            throws Exception {
        comment = new Comment(id, createdBy, createdAt, updatedAt, body, renderedBody);
    }

    @SuppressWarnings("ConstantConditions")
    public void shouldThrowNullPointerExceptionIf_id_IsNull() {
        assertThrows(NullPointerException.class, () -> {
            new Comment(null, createdBy, createdAt, updatedAt, body, renderedBody);
        });
    }

    @Test
    public void shouldReturnSupplied_id() {
        assertThat(comment.getId(), is(this.id));
    }

    @SuppressWarnings("ConstantConditions")
    public void shouldThrowNullPointerExceptionIf_createdBy_IsNull() {
        assertThrows(NullPointerException.class, () -> {
            new Comment(id, null, createdAt, updatedAt, body, renderedBody);
        });
    }

    @Test
    public void shouldReturnSupplied_createdBy() {
        assertThat(comment.getCreatedBy(), is(this.createdBy));
    }

    @Test
    public void shouldReturnSupplied_createdAt() {
        assertThat(comment.getCreatedAt(), is(this.createdAt));
    }

    @SuppressWarnings("ConstantConditions")
    public void shouldThrowNullPointerExceptionIf_updatedAt_IsNull() {
        assertThrows(NullPointerException.class, () -> {
            new Comment(id, createdBy, createdAt, null, body, renderedBody);
        });
    }

    @Test
    public void shouldReturnSupplied_updatedAt() {
        assertThat(comment.getUpdatedAt(), is(this.updatedAt));
    }

    @SuppressWarnings("ConstantConditions")
    public void shouldThrowNullPointerExceptionIf_body_IsNull() {
        assertThrows(NullPointerException.class, () -> {
            new Comment(id, createdBy, createdAt, updatedAt, null, renderedBody);
        });
    }

    @Test
    public void shouldReturnSupplied_body() {
        assertThat(comment.getBody(), is(this.body));
    }

    @SuppressWarnings("ConstantConditions")
    public void shouldThrowNullPointerExceptionIf_renderedBody_IsNull() {
        assertThrows(NullPointerException.class, () -> {
            new Comment(id, createdBy, createdAt, updatedAt, body, null);
        });
    }

    @Test
    public void shouldReturnSupplied_renderedBody() {
        assertThat(comment.getRenderedBody(), is(this.renderedBody));
    }

    @Test
    public void shouldBeEqualToSelf() {
        assertThat(comment, is(comment));
    }

    @Test
    @SuppressWarnings("ObjectEqualsNull")
    public void shouldNotBeEqualToNull() {
        assertThat(comment.equals(null), is(false));
    }

    @Test
    public void shouldBeEqualToOther() {
        assertThat(comment, is(new Comment(id, createdBy, createdAt, updatedAt, body, renderedBody)));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_id() {
        assertThat(comment, is(not(new Comment(Mockito.mock(CommentId.class), createdBy, createdAt, updatedAt, body, renderedBody))));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_createdBy() {
        assertThat(comment, is(not(new Comment(id, new UserId("OtherUser"), createdAt, updatedAt, body, renderedBody))));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_createdAt() {
        assertThat(comment, is(not(new Comment(id, createdBy, 2L, updatedAt, body, renderedBody))));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_updatedAt() {
        assertThat(comment, is(not(new Comment(id, createdBy, createdAt, Optional.of(1234L), body, renderedBody))));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_body() {
        assertThat(comment, is(not(new Comment(id, createdBy, createdAt, updatedAt, "String-7db11dfc-07e3-4497-b089-f32f37e0daf8", renderedBody))));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_renderedBody() {
        assertThat(comment, is(not(new Comment(id, createdBy, createdAt, updatedAt, body, "String-ad3be5cf-83bf-4b6f-980b-426b0acb2633"))));
    }

    @Test
    public void shouldBeEqualToOtherHashCode() {
        assertThat(comment.hashCode(), is(new Comment(id, createdBy, createdAt, updatedAt, body, renderedBody).hashCode()));
    }

    @Test
    public void shouldImplementToString() {
        assertThat(comment.toString(), Matchers.startsWith("Comment"));
    }

}
