package edu.stanford.protege.webprotege.project;

import com.google.common.collect.ImmutableList;
import edu.stanford.protege.webprotege.common.ProjectId;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class GetProjectPrefixDeclarationsResponse_TestCase {

    private final ProjectId projectId = ProjectId.generate();

    private GetProjectPrefixDeclarationsResponse result;

    private ImmutableList<PrefixDeclaration> prefixDeclarations;

    @BeforeEach
    public void setUp() {
        prefixDeclarations = ImmutableList.of(PrefixDeclaration.get("a:", "b"));
        result = new GetProjectPrefixDeclarationsResponse(projectId, prefixDeclarations);
    }

    @SuppressWarnings("ConstantConditions")
    public void shouldThrowNullPointerExceptionIf_projectId_IsNull() {
        assertThrows(NullPointerException.class, () -> {
            new GetProjectPrefixDeclarationsResponse(null, prefixDeclarations);
        });
    }

    @Test
    public void shouldReturnSupplied_projectId() {
        assertThat(result.projectId(), is(this.projectId));
    }

    @SuppressWarnings("ConstantConditions")
    public void shouldThrowNullPointerExceptionIf_prefixDeclarations_IsNull() {
        assertThrows(NullPointerException.class, () -> {
            new GetProjectPrefixDeclarationsResponse(projectId, null);
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
        assertThat(result, is(new GetProjectPrefixDeclarationsResponse(projectId, prefixDeclarations)));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_projectId() {
        assertThat(result, is(not(new GetProjectPrefixDeclarationsResponse(ProjectId.generate(), prefixDeclarations))));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_prefixDeclarations() {
        assertThat(result, is(not(new GetProjectPrefixDeclarationsResponse(projectId, ImmutableList.of()))));
    }

    @Test
    public void shouldBeEqualToOtherHashCode() {
        assertThat(result.hashCode(), is(new GetProjectPrefixDeclarationsResponse(projectId, prefixDeclarations).hashCode()));
    }

    @Test
    public void shouldImplementToString() {
        assertThat(result.toString(), Matchers.startsWith("GetProjectPrefixDeclarationsResponse"));
    }

}
