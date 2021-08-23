package edu.stanford.protege.webprotege.permissions;

import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.common.UserId;
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
 * 23/02/15
 */
@RunWith(MockitoJUnitRunner.class)
public class GetProjectPermissionsAction_TestCase {


    private GetProjectPermissionsAction action;

    private GetProjectPermissionsAction otherAction;

    private ProjectId projectId = ProjectId.generate();

    private UserId userId = new UserId("UserA");


    @Before
    public void setUp() throws Exception {
        action = new GetProjectPermissionsAction(projectId, userId);
        otherAction = new GetProjectPermissionsAction(projectId, userId);
    }

    @Test(expected = NullPointerException.class)
    public void shouldThrowNullPointerExceptionIf_ProjectId_IsNull() {
        new GetProjectPermissionsAction(null, userId);
    }


    @Test(expected = NullPointerException.class)
    public void shouldThrowNullPointerExceptionIf_UserId_IsNull() {
        new GetProjectPermissionsAction(projectId, null);
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
        assertThat(action.toString(), startsWith("GetPermissionsAction"));
    }

    @Test
    public void shouldReturnSuppliedProjectId() {
        assertThat(action.projectId(), is(projectId));
    }

    @Test
    public void shouldReturnSuppliedUserId() {
        assertThat(action.userId(), is(userId));
    }
}