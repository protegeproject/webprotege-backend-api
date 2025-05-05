package edu.stanford.protege.webprotege.project;

import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.common.UserId;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class LoadProjectResult_TestCase {

    private final ProjectId projectId = ProjectId.generate();

    private final UserId loadedBy = new UserId("UserA");

    private LoadProjectResult loadProjectResult;

    @Mock
    private ProjectDetails projectDetails;

    @BeforeEach
    public void setUp()
            throws Exception {
        loadProjectResult = new LoadProjectResult(projectId, loadedBy, projectDetails);
    }

    public void shouldThrowNullPointerExceptionIf_projectId_IsNull() {
        assertThrows(NullPointerException.class, () -> {
            new LoadProjectResult(null, loadedBy, projectDetails);
        });
    }

    @Test
    public void shouldReturnSupplied_projectId() {
        MatcherAssert.assertThat(loadProjectResult.projectId(), Matchers.is(this.projectId));
    }

    public void shouldThrowNullPointerExceptionIf_loadedBy_IsNull() {
        assertThrows(NullPointerException.class, () -> {
            new LoadProjectResult(projectId, null, projectDetails);
        });
    }

    public void shouldThrowNullPointerExceptionIf_projectDetails_IsNull() {
        assertThrows(NullPointerException.class, () -> {
            new LoadProjectResult(projectId, loadedBy, null);
        });
    }

    @Test
    public void shouldReturnSupplied_projectDetails() {
        MatcherAssert.assertThat(loadProjectResult.projectDetails(), Matchers.is(this.projectDetails));
    }

    @Test
    public void shouldBeEqualToSelf() {
        MatcherAssert.assertThat(loadProjectResult, Matchers.is(loadProjectResult));
    }

    @Test
    public void shouldNotBeEqualToNull() {
        MatcherAssert.assertThat(loadProjectResult.equals(null), Matchers.is(false));
    }

    @Test
    public void shouldBeEqualToOther() {
        MatcherAssert.assertThat(loadProjectResult,
                Matchers.is(new LoadProjectResult(projectId, loadedBy, projectDetails)));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_projectId() {
        MatcherAssert.assertThat(loadProjectResult,
                Matchers.is(Matchers.not(new LoadProjectResult(ProjectId.generate(),
                        loadedBy,
                        projectDetails))));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_loadedBy() {
        MatcherAssert.assertThat(loadProjectResult,
                Matchers.is(Matchers.not(new LoadProjectResult(projectId,
                        new UserId("OtherUser"),
                        projectDetails))));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_projectDetails() {
        MatcherAssert.assertThat(loadProjectResult,
                Matchers.is(Matchers.not(new LoadProjectResult(projectId,
                        loadedBy,
                        Mockito.mock(ProjectDetails.class)))));
    }

    @Test
    public void shouldBeEqualToOtherHashCode() {
        MatcherAssert.assertThat(loadProjectResult.hashCode(),
                Matchers.is(new LoadProjectResult(projectId, loadedBy, projectDetails).hashCode()));
    }

    @Test
    public void shouldImplementToString() {
        MatcherAssert.assertThat(loadProjectResult.toString(), Matchers.startsWith("LoadProjectResult"));
    }

    @Test
    public void should_getUserId() {
        MatcherAssert.assertThat(loadProjectResult.loadedBy(), Matchers.is(loadedBy));
    }
}
