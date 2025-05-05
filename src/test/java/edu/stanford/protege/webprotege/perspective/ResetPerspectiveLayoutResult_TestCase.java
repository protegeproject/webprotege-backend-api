package edu.stanford.protege.webprotege.perspective;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
public class ResetPerspectiveLayoutResult_TestCase {

    private ResetPerspectiveLayoutResult resetPerspectiveLayoutResult;

    @Mock
    private PerspectiveLayout resetLayout;

    @BeforeEach
    public void setUp()
            throws Exception {
        resetPerspectiveLayoutResult = new ResetPerspectiveLayoutResult(resetLayout);
    }

    @SuppressWarnings("ConstantConditions")
    public void shouldThrowNullPointerExceptionIf_resetLayout_IsNull() {
        assertThrows(NullPointerException.class, () -> {
            new ResetPerspectiveLayoutResult(null);
        });
    }

    @Test
    public void shouldReturnSupplied_resetLayout() {
        assertThat(resetPerspectiveLayoutResult.resetLayout(), is(this.resetLayout));
    }

    @Test
    public void shouldBeEqualToSelf() {
        assertThat(resetPerspectiveLayoutResult, is(resetPerspectiveLayoutResult));
    }

    @Test
    @SuppressWarnings("ObjectEqualsNull")
    public void shouldNotBeEqualToNull() {
        assertThat(resetPerspectiveLayoutResult.equals(null), is(false));
    }

    @Test
    public void shouldBeEqualToOther() {
        assertThat(resetPerspectiveLayoutResult, is(new ResetPerspectiveLayoutResult(resetLayout)));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_resetLayout() {
        assertThat(resetPerspectiveLayoutResult, is(not(new ResetPerspectiveLayoutResult(mock(PerspectiveLayout.class)))));
    }

    @Test
    public void shouldBeEqualToOtherHashCode() {
        assertThat(resetPerspectiveLayoutResult.hashCode(), is(new ResetPerspectiveLayoutResult(resetLayout).hashCode()));
    }

    @Test
    public void shouldImplementToString() {
        assertThat(resetPerspectiveLayoutResult.toString(), Matchers.startsWith("ResetPerspectiveLayoutResult"));
    }

}
