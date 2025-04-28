package edu.stanford.protege.webprotege.sharing;

import edu.stanford.protege.webprotege.common.ChangeRequestId;
import edu.stanford.protege.webprotege.common.ProjectId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.startsWith;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class SetProjectSharingSettingsAction_TestCase {


    private final ProjectId projectId = ProjectId.generate();

    private final ChangeRequestId changeRequestId = ChangeRequestId.generate();

    private SetProjectSharingSettingsAction action;

    private SetProjectSharingSettingsAction otherAction;

    @Mock
    private ProjectSharingSettings projectSharingSettings;

    @BeforeEach
    public void setUp() throws Exception {
        action = new SetProjectSharingSettingsAction(changeRequestId, projectId, projectSharingSettings);
        otherAction = new SetProjectSharingSettingsAction(changeRequestId, projectId, projectSharingSettings);
    }

    public void shouldThrowNullPointerException() {
        assertThrows(NullPointerException.class, () -> {
            new SetProjectSharingSettingsAction(changeRequestId, projectId, null);
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
        assertThat(action.toString(), startsWith("SetProjectSharingSettingsAction"));
    }

    @Test
    public void shouldReturnSuppliedSharingSettings() {
        assertThat(action.settings(), is(projectSharingSettings));
    }

    @Test
    public void shouldReturnSuppliedProjectId() {
        assertThat(action.projectId(), is(projectId));
    }

}