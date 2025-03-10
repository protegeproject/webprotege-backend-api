package edu.stanford.protege.webprotege.change;

import edu.stanford.protege.webprotege.common.PageRequest;
import edu.stanford.protege.webprotege.common.ProjectId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.semanticweb.owlapi.model.OWLEntity;

import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.startsWith;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
public class GetProjectChangesAction_TestCase {


    private final Optional<OWLEntity> subject = Optional.of(mock(OWLEntity.class));

    private final ProjectId projectId = ProjectId.generate();

    private GetProjectChangesAction action;

    private GetProjectChangesAction otherAction;

    @Mock
    private PageRequest pageRequest;

    @BeforeEach
    public void setUp() throws Exception {
        action = new GetProjectChangesAction(projectId, subject, pageRequest);
        otherAction = new GetProjectChangesAction(projectId, subject, pageRequest);
    }

    public void shouldThrowNullPointerExceptionIf_ProjectId_IsNull() {
        assertThrows(NullPointerException.class, () -> {
            new GetProjectChangesAction(null, subject, pageRequest);
        });
    }


    public void shouldThrowNullPointerExceptionIf_Subject_IsNull() {
        assertThrows(NullPointerException.class, () -> {
            new GetProjectChangesAction(projectId, null, pageRequest);
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
        assertThat(action.toString(), startsWith("GetProjectChangesAction"));
    }

    @Test
    public void shouldReturnSuppliedProjectId() {
        assertThat(action.projectId(), is(projectId));
    }

    @Test
    public void shouldReturnSuppliedSubject() {
        assertThat(action.subject(), is(subject));
    }
}