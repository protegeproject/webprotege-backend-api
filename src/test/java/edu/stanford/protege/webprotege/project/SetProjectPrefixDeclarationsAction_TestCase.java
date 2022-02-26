
package edu.stanford.protege.webprotege.project;

import edu.stanford.protege.webprotege.common.ChangeRequestId;
import edu.stanford.protege.webprotege.common.ProjectId;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.startsWith;
import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class)
public class SetProjectPrefixDeclarationsAction_TestCase {

    private SetProjectPrefixDeclarationsAction action;

    private ProjectId projectId;

    private List<PrefixDeclaration> prefixDeclarations;

    private ChangeRequestId changeRequestId = ChangeRequestId.generate();

    @Before
    public void setUp() {
        projectId = ProjectId.valueOf("12345678-1234-1234-1234-123456789abc");
        prefixDeclarations = new ArrayList<>();
        prefixDeclarations.add(PrefixDeclaration.get("a:", "b"));
        action = new SetProjectPrefixDeclarationsAction(changeRequestId, projectId, prefixDeclarations);
    }

    @SuppressWarnings("ConstantConditions")
    @Test(expected = NullPointerException.class)
    public void shouldThrowNullPointerExceptionIf_projectId_IsNull() {
        new SetProjectPrefixDeclarationsAction(changeRequestId, null, prefixDeclarations);
    }

    @Test
    public void shouldReturnSupplied_projectId() {
        assertThat(action.projectId(), is(this.projectId));
    }

    @SuppressWarnings("ConstantConditions")
    @Test(expected = NullPointerException.class)
    public void shouldThrowNullPointerExceptionIf_prefixDeclarations_IsNull() {
        new SetProjectPrefixDeclarationsAction(changeRequestId, projectId, null);
    }

    @Test
    public void shouldReturnSupplied_prefixDeclarations() {
        assertThat(action.prefixDeclarations(), is(this.prefixDeclarations));
    }

    @Test
    public void shouldBeEqualToSelf() {
        assertThat(action, is(action));
    }

    @Test
    @SuppressWarnings("ObjectEqualsNull")
    public void shouldNotBeEqualToNull() {
        assertThat(action.equals(null), is(false));
    }

    @Test
    public void shouldBeEqualToOther() {
        assertThat(action, is(new SetProjectPrefixDeclarationsAction(changeRequestId, projectId, prefixDeclarations)));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_projectId() {
        assertThat(action, is(Matchers.not(new SetProjectPrefixDeclarationsAction(changeRequestId,
                                                                                  ProjectId.generate(), prefixDeclarations))));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_prefixDeclarations() {
        List<PrefixDeclaration> otherDecls = new ArrayList<>();
        otherDecls.add(PrefixDeclaration.get("c:", "d"));
        assertThat(action, is(Matchers.not(new SetProjectPrefixDeclarationsAction(changeRequestId, projectId, otherDecls))));
    }

    @Test
    public void shouldBeEqualToOtherHashCode() {
        assertThat(action.hashCode(), is(new SetProjectPrefixDeclarationsAction(changeRequestId,
                                                                                projectId, prefixDeclarations).hashCode()));
    }

    @Test
    public void shouldImplementToString() {
        assertThat(action.toString(), startsWith("SetProjectPrefixDeclarationsAction"));
    }

}
