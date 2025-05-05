package edu.stanford.protege.webprotege.project;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.startsWith;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class CreateNewProjectResult_TestCase {


    private CreateNewProjectResult result;

    private CreateNewProjectResult otherResult;

    @Mock
    private ProjectDetails projectDetails;


    @BeforeEach
    public void setUp() throws Exception {
        result = new CreateNewProjectResult(projectDetails);
        otherResult = new CreateNewProjectResult(projectDetails);
    }

    public void shouldThrowNullPointerException() {
        assertThrows(NullPointerException.class, () -> {
            new CreateNewProjectResult(null);
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
        assertThat(result.toString(), startsWith("CreateNewProjectResult"));
    }

    @Test
    public void shouldReturnSuppliedProjectDetails() {
        assertThat(result.projectDetails(), is(projectDetails));
    }
}