
package edu.stanford.protege.webprotege.watches;

import com.google.common.collect.ImmutableSet;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.user.UserId;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.semanticweb.owlapi.model.OWLEntity;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class)
public class SetEntityWatchesAction_TestCase {

    private SetEntityWatchesAction setEntityWatchesAction;
    private ProjectId projectId = ProjectId.generate();
    @Mock
    private UserId userId;
    @Mock
    private OWLEntity entity;
    @Mock
    private ImmutableSet watches;

    @Before
    public void setUp()
    {
        setEntityWatchesAction = new SetEntityWatchesAction(projectId, userId, entity, watches);
    }

    @Test(expected = NullPointerException.class)
    public void shouldThrowNullPointerExceptionIf_projectId_IsNull() {
        new SetEntityWatchesAction(null, userId, entity, watches);
    }

    @Test
    public void shouldReturnSupplied_projectId() {
        assertThat(setEntityWatchesAction.projectId(), is(this.projectId));
    }

    @Test(expected = NullPointerException.class)
    public void shouldThrowNullPointerExceptionIf_userId_IsNull() {
        new SetEntityWatchesAction(projectId, null, entity, watches);
    }

    @Test
    public void shouldReturnSupplied_userId() {
        assertThat(setEntityWatchesAction.userId(), is(this.userId));
    }

    @Test(expected = NullPointerException.class)
    public void shouldThrowNullPointerExceptionIf_entity_IsNull() {
        new SetEntityWatchesAction(projectId, userId, null, watches);
    }

    @Test
    public void shouldReturnSupplied_entity() {
        assertThat(setEntityWatchesAction.entity(), is(this.entity));
    }

    @Test(expected = NullPointerException.class)
    public void shouldThrowNullPointerExceptionIf_watches_IsNull() {
        new SetEntityWatchesAction(projectId, userId, entity, null);
    }

    @Test
    public void shouldReturnSupplied_watches() {
        assertThat(setEntityWatchesAction.watches(), is(this.watches));
    }

    @Test
    public void shouldBeEqualToSelf() {
        assertThat(setEntityWatchesAction, is(setEntityWatchesAction));
    }

    @Test
    public void shouldNotBeEqualToNull() {
        assertThat(setEntityWatchesAction.equals(null), is(false));
    }

    @Test
    public void shouldBeEqualToOther() {
        assertThat(setEntityWatchesAction, is(new SetEntityWatchesAction(projectId, userId, entity, watches)));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_projectId() {
        assertThat(setEntityWatchesAction, is(not(new SetEntityWatchesAction(ProjectId.generate(), userId, entity, watches))));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_userId() {
        assertThat(setEntityWatchesAction, is(not(new SetEntityWatchesAction(projectId, mock(UserId.class), entity, watches))));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_entity() {
        assertThat(setEntityWatchesAction, is(not(new SetEntityWatchesAction(projectId, userId, mock(OWLEntity.class), watches))));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_watches() {
        assertThat(setEntityWatchesAction, is(not(new SetEntityWatchesAction(projectId, userId, entity, mock(ImmutableSet.class)))));
    }

    @Test
    public void shouldBeEqualToOtherHashCode() {
        assertThat(setEntityWatchesAction.hashCode(), is(new SetEntityWatchesAction(projectId, userId, entity, watches)
                                                                               .hashCode()));
    }

    @Test
    public void shouldImplementToString() {
        assertThat(setEntityWatchesAction.toString(), Matchers.startsWith("SetEntityWatchesAction"));
    }

}
