package edu.stanford.protege.webprotege.sharing;

import edu.stanford.protege.webprotege.common.ChangeRequestId;
import edu.stanford.protege.webprotege.common.ProjectId;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.startsWith;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 07/02/15
 */
@RunWith(MockitoJUnitRunner.class)
public class SetProjectSharingSettingsAction_TestCase {


    private SetProjectSharingSettingsAction action;

    private SetProjectSharingSettingsAction otherAction;

    @Mock
    private ProjectSharingSettings projectSharingSettings;

    private ProjectId projectId = ProjectId.generate();

    private ChangeRequestId changeRequestId = ChangeRequestId.generate();

    @Before
    public void setUp() throws Exception {
        action = new SetProjectSharingSettingsAction(changeRequestId, projectId, projectSharingSettings);
        otherAction = new SetProjectSharingSettingsAction(changeRequestId, projectId, projectSharingSettings);
    }

    @Test(expected = NullPointerException.class)
    public void shouldThrowNullPointerException() {
        new SetProjectSharingSettingsAction(changeRequestId, projectId, null);
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