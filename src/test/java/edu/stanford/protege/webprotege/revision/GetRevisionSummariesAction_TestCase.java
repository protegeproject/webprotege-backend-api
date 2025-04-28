package edu.stanford.protege.webprotege.revision;

import edu.stanford.protege.webprotege.common.PageRequest;
import edu.stanford.protege.webprotege.common.ProjectId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.startsWith;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class GetRevisionSummariesAction_TestCase {


    private final ProjectId projectId = ProjectId.generate();

    private final PageRequest pageRequest = PageRequest.requestFirstPage();

    private GetRevisionSummariesAction action;

    private GetRevisionSummariesAction otherAction;

    @BeforeEach
    public void setUp() throws Exception {
        action = new GetRevisionSummariesAction(projectId, pageRequest);
        otherAction = new GetRevisionSummariesAction(projectId, pageRequest);
    }

    public void shouldThrowNullPointerException() {
        assertThrows(NullPointerException.class, () -> {
            new GetRevisionSummariesAction(null, pageRequest);
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
        assertThat(action.toString(), startsWith("GetRevisionSummariesAction"));
    }

    public void shouldReturnSuppliedProjectId() {
        assertThat(action.projectId(), is(projectId));
    }
}