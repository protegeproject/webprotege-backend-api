package edu.stanford.protege.webprotege.project;

import edu.stanford.protege.webprotege.common.ProjectId;
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
public class CreateNewProjectAction_TestCase {


    private CreateNewProjectAction action;

    private CreateNewProjectAction otherAction;

    @Mock
    private NewProjectSettings newProjectSettings;


    @BeforeEach
    public void setUp() throws Exception {
        var projectId = ProjectId.generate();
        action = new CreateNewProjectAction(projectId,
                newProjectSettings);
        otherAction = new CreateNewProjectAction(projectId, newProjectSettings);
    }

    public void shouldThrowNullPointerException() {
        assertThrows(NullPointerException.class, () -> {
            new CreateNewProjectAction(ProjectId.generate(), null);
        });
    }

    @Test
    public void shouldBeEqualToSelf() {
        assertThat(action, is(equalTo(action)));
    }

    @Test
    public void shouldNotBeEqualToNull() {
        assertThat(action, is(not(equalTo(null))));
    }

    @Test
    public void shouldBeEqualToOther() {
        assertThat(action, is(equalTo(otherAction)));
    }

    @Test
    public void shouldHaveSameHashCodeAsOther() {
        assertThat(action.hashCode(), is(otherAction.hashCode()));
    }

    @Test
    public void shouldGenerateToString() {
        assertThat(action.toString(), startsWith("CreateNewProjectAction"));
    }

    @Test
    public void shouldReturnSuppliedSettings() {
        assertThat(action.newProjectSettings(), is(newProjectSettings));
    }
}