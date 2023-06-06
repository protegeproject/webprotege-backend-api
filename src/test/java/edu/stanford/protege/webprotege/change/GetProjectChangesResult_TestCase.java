package edu.stanford.protege.webprotege.change;

import edu.stanford.protege.webprotege.common.Page;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.startsWith;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 24/02/15
 */
@SpringBootTest
public class GetProjectChangesResult_TestCase {


    private GetProjectChangesResult result;

    private GetProjectChangesResult otherResult;

    @Mock
    private Page<ProjectChange> projectChanges;


    @BeforeEach
    public void setUp() throws Exception {
        result = new GetProjectChangesResult(projectChanges);
        otherResult = new GetProjectChangesResult(projectChanges);
    }

    @Test
    public void shouldThrowNullPointerException() {
        assertThrows(NullPointerException.class, () -> {
            new GetProjectChangesResult(null);
        });
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
        assertThat(result.changes(), is(projectChanges));
    }
}