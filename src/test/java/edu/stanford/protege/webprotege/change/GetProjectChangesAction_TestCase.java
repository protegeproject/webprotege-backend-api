package edu.stanford.protege.webprotege.change;

import edu.stanford.protege.webprotege.pagination.PageRequest;
import edu.stanford.protege.webprotege.common.ProjectId;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.semanticweb.owlapi.model.OWLEntity;

import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.startsWith;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.mockito.Mockito.mock;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 24/02/15
 */
@RunWith(MockitoJUnitRunner.class)
public class GetProjectChangesAction_TestCase {


    private GetProjectChangesAction action;

    private GetProjectChangesAction otherAction;

    private ProjectId projectId = ProjectId.generate();

    @Mock
    private PageRequest pageRequest;

    private final Optional<OWLEntity> subject = Optional.of(mock(OWLEntity.class));


    @Before
    public void setUp() throws Exception {
        action = GetProjectChangesAction.create(projectId, subject, pageRequest);
        otherAction = GetProjectChangesAction.create(projectId, subject, pageRequest);
    }

    @Test(expected = NullPointerException.class)
    public void shouldThrowNullPointerExceptionIf_ProjectId_IsNull() {
        GetProjectChangesAction.create(null, subject, pageRequest);
    }


    @Test(expected = NullPointerException.class)
    public void shouldThrowNullPointerExceptionIf_Subject_IsNull() {
        GetProjectChangesAction.create(projectId, null, pageRequest);
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
        assertThat(action.getProjectId(), is(projectId));
    }

    @Test
    public void shouldReturnSuppliedSubject() {
        assertThat(action.getSubject(), is(subject));
    }
}