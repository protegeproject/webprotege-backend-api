
package edu.stanford.protege.webprotege.project;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.startsWith;

@RunWith(MockitoJUnitRunner.class)
public class GetProjectDetailsResult_TestCase {

    private GetProjectDetailsResult result;
    @Mock
    private ProjectDetails projectDetails;

    @Before
    public void setUp() {
        result = new GetProjectDetailsResult(projectDetails);
    }

    @Test(expected = NullPointerException.class)
    public void shouldThrowNullPointerExceptionIf_projectDetails_IsNull() {
        new GetProjectDetailsResult(null);
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
