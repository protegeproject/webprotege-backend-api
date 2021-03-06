
package edu.stanford.protege.webprotege.project;

import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.common.UserId;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;

@RunWith(org.mockito.runners.MockitoJUnitRunner.class)
public class LoadProjectResult_TestCase {

    private LoadProjectResult loadProjectResult;

    private ProjectId projectId = ProjectId.generate();

    private UserId loadedBy = new UserId("UserA");

    @Mock
    private ProjectDetails projectDetails;

    @Before
    public void setUp()
            throws Exception {
        loadProjectResult = new LoadProjectResult(projectId, loadedBy, projectDetails);
    }

    @Test(expected = java.lang.NullPointerException.class)
    public void shouldThrowNullPointerExceptionIf_projectId_IsNull() {
        new LoadProjectResult(null, loadedBy, projectDetails);
    }

    @Test
    public void shouldReturnSupplied_projectId() {
        MatcherAssert.assertThat(loadProjectResult.projectId(), Matchers.is(this.projectId));
    }

    @Test(expected = java.lang.NullPointerException.class)
    public void shouldThrowNullPointerExceptionIf_loadedBy_IsNull() {
        new LoadProjectResult(projectId, null, projectDetails);
    }

    @Test(expected = java.lang.NullPointerException.class)
    public void shouldThrowNullPointerExceptionIf_projectDetails_IsNull() {
        new LoadProjectResult(projectId, loadedBy, null);
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
