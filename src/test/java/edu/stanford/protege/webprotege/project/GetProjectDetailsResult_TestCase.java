
package edu.stanford.protege.webprotege.project;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@RunWith(MockitoJUnitRunner.class)
public class GetProjectDetailsResult_TestCase {

    private GetProjectDetailsResult getProjectDetailsResult;
    @Mock
    private ProjectDetails projectDetails;

    @Before
    public void setUp()
    {
    }

    @Test(expected = NullPointerException.class)
    public void shouldThrowNullPointerExceptionIf_projectDetails_IsNull() {
    }

    @Test
    public void shouldReturnSupplied_projectDetails() {
    }

    @Test
    public void shouldBeEqualToSelf() {
        assertThat(getProjectDetailsResult, is(getProjectDetailsResult));
    }

    @Test
    public void shouldNotBeEqualToNull() {
        assertThat(getProjectDetailsResult.equals(null), is(false));
    }

    @Test
    public void shouldBeEqualToOther() {
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_projectDetails() {
    }

    @Test
    public void shouldBeEqualToOtherHashCode() {
    }

    @Test
    public void shouldImplementToString() {
        assertThat(getProjectDetailsResult.toString(), startsWith("GetProjectDetailsResult"));
    }

}
