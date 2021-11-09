
package edu.stanford.protege.webprotege.change;

import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.revision.RevisionNumber;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;

@RunWith(org.mockito.runners.MockitoJUnitRunner.class)
public class RevertRevisionResult_TestCase {

    private RevertRevisionResult revertRevisionResult;

    private ProjectId projectId = ProjectId.generate();

    @Mock
    private RevisionNumber revisionNumber;

    @Before
    public void setUp() {
        revertRevisionResult = new RevertRevisionResult(projectId, revisionNumber);
    }

    @Test
    public void shouldReturnSupplied_projectId() {
        MatcherAssert.assertThat(revertRevisionResult.projectId(), Matchers.is(this.projectId));
    }

    @Test
    public void shouldBeEqualToSelf() {
        MatcherAssert.assertThat(revertRevisionResult, Matchers.is(revertRevisionResult));
    }

    @Test
    public void shouldNotBeEqualToNull() {
        MatcherAssert.assertThat(revertRevisionResult.equals(null), Matchers.is(false));
    }

    @Test
    public void shouldBeEqualToOther() {
        MatcherAssert.assertThat(revertRevisionResult, Matchers.is(new RevertRevisionResult(projectId, revisionNumber)));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_projectId() {
        MatcherAssert.assertThat(revertRevisionResult, Matchers.is(Matchers.not(new RevertRevisionResult(ProjectId.generate(), revisionNumber))));
    }

    @Test
    public void shouldBeEqualToOtherHashCode() {
        MatcherAssert.assertThat(revertRevisionResult.hashCode(), Matchers.is(new RevertRevisionResult(projectId, revisionNumber).hashCode()));
    }

    @Test
    public void shouldImplementToString() {
        MatcherAssert.assertThat(revertRevisionResult.toString(), Matchers.startsWith("RevertRevisionResult"));
    }
}
