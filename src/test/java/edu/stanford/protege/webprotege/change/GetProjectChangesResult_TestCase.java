package edu.stanford.protege.webprotege.change;

import edu.stanford.protege.webprotege.pagination.Page;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.startsWith;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 24/02/15
 */
@RunWith(MockitoJUnitRunner.class)
public class GetProjectChangesResult_TestCase {


    private GetProjectChangesResult result;

    private GetProjectChangesResult otherResult;

    @Mock
    private Page<ProjectChange> projectChanges;


    @Before
    public void setUp() throws Exception {
        result = GetProjectChangesResult.create(projectChanges);
        otherResult = GetProjectChangesResult.create(projectChanges);
    }

    @Test(expected = NullPointerException.class)
    public void shouldThrowNullPointerException() {
        GetProjectChangesResult.create(null);
    }

    @Test
    public void shouldBeEqualToSelf() {
        assertThat(result, is(equalTo(result)));
    }

    @Test
    public void shouldNotBeEqualToNull() {
        assertThat(result, is(not(equalTo(null))));
    }

    @Test
    public void shouldBeEqualToOther() {
        assertThat(result, is(equalTo(otherResult)));
    }

    @Test
    public void shouldHaveSameHashCodeAsOther() {
        assertThat(result.hashCode(), is(otherResult.hashCode()));
    }

    @Test
    public void shouldGenerateToString() {
        assertThat(result.toString(), startsWith("GetProjectChangesResult"));
    }

    @Test
    public void shouldReturnSuppliedList() {
        assertThat(result.getProjectChanges(), is(projectChanges));
    }
}