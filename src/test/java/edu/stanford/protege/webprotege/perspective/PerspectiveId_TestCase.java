package edu.stanford.protege.webprotege.perspective;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class PerspectiveId_TestCase {

    private final String id = "12345678-1234-1234-1234-123456789abc";

    private PerspectiveId perspectiveId;

    @BeforeEach
    public void setUp() throws Exception {
        perspectiveId = PerspectiveId.get(id);
    }

    public void shouldThrowNullPointerExceptionIf_id_IsNull() {
        assertThrows(NullPointerException.class, () -> {
            PerspectiveId.get(null);
        });
    }

    @Test
    public void shouldReturnSupplied_id() {
        assertThat(perspectiveId.getId(), is(this.id));
    }

    @Test
    public void shouldBeEqualToSelf() {
        assertThat(perspectiveId, is(perspectiveId));
    }

    @Test
    public void shouldNotBeEqualToNull() {
        assertThat(perspectiveId.equals(null), is(false));
    }

    @Test
    public void shouldBeEqualToOther() {
        assertThat(perspectiveId, is(PerspectiveId.get(id)));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_id() {
        assertThat(perspectiveId, is(not(PerspectiveId.get("4c96af5c-31d0-4b5a-9d57-ed48e6668da4"))));
    }

    @Test
    public void shouldBeEqualToOtherHashCode() {
        assertThat(perspectiveId.hashCode(), is(PerspectiveId.get(id).hashCode()));
    }

    @Test
    public void shouldImplementToString() {
        assertThat(perspectiveId.toString(), startsWith("PerspectiveId"));
    }

    @Test
    public void shouldHaveValueEqualToId() {
        assertThat(perspectiveId.value(), equalTo(perspectiveId.getId()));
    }
}
