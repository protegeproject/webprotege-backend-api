package edu.stanford.protege.webprotege.project;

import edu.stanford.protege.webprotege.common.ChangeRequestId;
import edu.stanford.protege.webprotege.common.ProjectId;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.startsWith;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class SetProjectPrefixDeclarationsAction_TestCase {

    private final ChangeRequestId changeRequestId = ChangeRequestId.generate();

    private SetProjectPrefixDeclarationsAction action;

    private ProjectId projectId;

    private List<PrefixDeclaration> prefixDeclarations;

    @BeforeEach
    public void setUp() {
        projectId = ProjectId.valueOf("12345678-1234-1234-1234-123456789abc");
        prefixDeclarations = new ArrayList<>();
        prefixDeclarations.add(PrefixDeclaration.get("a:", "b"));
        action = new SetProjectPrefixDeclarationsAction(changeRequestId, projectId, prefixDeclarations);
    }

    @SuppressWarnings("ConstantConditions")
    public void shouldThrowNullPointerExceptionIf_projectId_IsNull() {
        assertThrows(NullPointerException.class, () -> {
            new SetProjectPrefixDeclarationsAction(changeRequestId, null, prefixDeclarations);
        });
    }

    @Test
    public void shouldReturnSupplied_projectId() {
        assertThat(action.projectId(), is(this.projectId));
    }

    @SuppressWarnings("ConstantConditions")
    public void shouldThrowNullPointerExceptionIf_prefixDeclarations_IsNull() {
        assertThrows(NullPointerException.class, () -> {
            new SetProjectPrefixDeclarationsAction(changeRequestId, projectId, null);
        });
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
