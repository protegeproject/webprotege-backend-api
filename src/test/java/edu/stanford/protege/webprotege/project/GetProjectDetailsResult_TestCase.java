package edu.stanford.protege.webprotege.project;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.startsWith;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class GetProjectDetailsResult_TestCase {

    private GetProjectDetailsResult result;

    @Mock
    private ProjectDetails projectDetails;

    @BeforeEach
    public void setUp() {
        result = new GetProjectDetailsResult(projectDetails);
    }

    public void shouldThrowNullPointerExceptionIf_projectDetails_IsNull() {
        assertThrows(NullPointerException.class, () -> {
            new GetProjectDetailsResult(null);
        });
    }

    @Test
    public void shouldReturnSupplied_projectDetails() {
        assertThat(result.projectDetails(), is(projectDetails));
    }

    @Test
    public void shouldBeEqualToSelf() {
        assertThat(result, is(result));
    }

    @Test
    public void shouldNotBeEqualToNull() {
        assertThat(result.equals(null), is(false));
    }


    @Test
    public void shouldImplementToString() {
        assertThat(result.toString(), startsWith("GetProjectDetailsResult"));
    }

}
