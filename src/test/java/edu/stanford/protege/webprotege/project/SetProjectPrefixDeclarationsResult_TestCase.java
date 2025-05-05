package edu.stanford.protege.webprotege.project;

import edu.stanford.protege.webprotege.common.ProjectId;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class SetProjectPrefixDeclarationsResult_TestCase {

    private final ProjectId projectId = ProjectId.generate();

    private SetProjectPrefixDeclarationsResult result;

    private List<PrefixDeclaration> prefixDeclarations;

    @BeforeEach
    public void setUp() {
        prefixDeclarations = new ArrayList<>();
        prefixDeclarations.add(PrefixDeclaration.get("x:", "y"));
        result = new SetProjectPrefixDeclarationsResult(projectId, prefixDeclarations);
    }

    @SuppressWarnings("ConstantConditions")
    public void shouldThrowNullPointerExceptionIf_projectId_IsNull() {
        assertThrows(NullPointerException.class, () -> {
            new SetProjectPrefixDeclarationsResult(null, prefixDeclarations);
        });
    }

    @Test
    public void shouldReturnSupplied_projectId() {
        assertThat(result.projectId(), is(this.projectId));
    }

    @SuppressWarnings("ConstantConditions")
    public void shouldThrowNullPointerExceptionIf_prefixDeclarations_IsNull() {
        assertThrows(NullPointerException.class, () -> {
            new SetProjectPrefixDeclarationsResult(projectId, null);
        });
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
        otherDecls.add(PrefixDeclaration.get("q:", "r"));
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
