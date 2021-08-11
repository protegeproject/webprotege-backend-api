
package edu.stanford.protege.webprotege.project;

import edu.stanford.protege.webprotege.common.ProjectId;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class)
public class SetProjectPrefixDeclarationsResult_TestCase {

    private SetProjectPrefixDeclarationsResult result;

    private ProjectId projectId = ProjectId.generate();

    private List<PrefixDeclaration> prefixDeclarations;

    @Before
    public void setUp() {
        prefixDeclarations = new ArrayList<>();
        prefixDeclarations.add(mock(PrefixDeclaration.class));
        result = new SetProjectPrefixDeclarationsResult(projectId, prefixDeclarations);
    }

    @SuppressWarnings("ConstantConditions")
    @Test(expected = NullPointerException.class)
    public void shouldThrowNullPointerExceptionIf_projectId_IsNull() {
        new SetProjectPrefixDeclarationsResult(null, prefixDeclarations);
    }

    @Test
    public void shouldReturnSupplied_projectId() {
        assertThat(result.projectId(), is(this.projectId));
    }

    @SuppressWarnings("ConstantConditions")
    @Test(expected = NullPointerException.class)
    public void shouldThrowNullPointerExceptionIf_prefixDeclarations_IsNull() {
        new SetProjectPrefixDeclarationsResult(projectId, null);
    }

    @Test
    public void shouldReturnSupplied_prefixDeclarations() {
        assertThat(result.prefixDeclarations(), is(this.prefixDeclarations));
    }

    @Test
    public void shouldBeEqualToSelf() {
        assertThat(result, is(result));
    }

    @Test
    @SuppressWarnings("ObjectEqualsNull")
    public void shouldNotBeEqualToNull() {
        assertThat(result.equals(null), is(false));
    }

    @Test
    public void shouldBeEqualToOther() {
        assertThat(result, is(new SetProjectPrefixDeclarationsResult(projectId, prefixDeclarations)));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_projectId() {
        assertThat(result, is(not(new SetProjectPrefixDeclarationsResult(ProjectId.generate(), prefixDeclarations))));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_prefixDeclarations() {
        List<PrefixDeclaration> otherDecls = new ArrayList<>();
        otherDecls.add(mock(PrefixDeclaration.class));
        assertThat(result, is(Matchers.not(new SetProjectPrefixDeclarationsResult(projectId, otherDecls))));
    }

    @Test
    public void shouldBeEqualToOtherHashCode() {
        assertThat(result.hashCode(), is(new SetProjectPrefixDeclarationsResult(projectId, prefixDeclarations).hashCode()));
    }

    @Test
    public void shouldImplementToString() {
        assertThat(result.toString(), startsWith("SetProjectPrefixDeclarationsResult"));
    }

}
