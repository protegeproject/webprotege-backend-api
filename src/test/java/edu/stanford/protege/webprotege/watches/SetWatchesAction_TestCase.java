
package edu.stanford.protege.webprotege.watches;

import com.google.common.collect.ImmutableSet;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.common.UserId;
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
public class SetWatchesAction_TestCase {

    private SetWatchesAction setWatchesAction;

    private ProjectId projectId = ProjectId.generate();

    private UserId userId = new UserId("UserA");

    @Mock
    private OWLEntity entity;

    @Mock
    private ImmutableSet watches;

    @Before
    public void setUp()
    {
        setWatchesAction = new SetWatchesAction(projectId, userId, entity, watches);
    }

    @Test(expected = NullPointerException.class)
    public void shouldThrowNullPointerExceptionIf_projectId_IsNull() {
        new SetWatchesAction(null, userId, entity, watches);
    }

    @Test
    public void shouldReturnSupplied_projectId() {
        assertThat(setWatchesAction.projectId(), is(this.projectId));
    }

    @Test(expected = NullPointerException.class)
    public void shouldThrowNullPointerExceptionIf_userId_IsNull() {
        new SetWatchesAction(projectId, null, entity, watches);
    }

    @Test
    public void shouldReturnSupplied_userId() {
        assertThat(setWatchesAction.userId(), is(this.userId));
    }

    @Test(expected = NullPointerException.class)
    public void shouldThrowNullPointerExceptionIf_entity_IsNull() {
        new SetWatchesAction(projectId, userId, null, watches);
    }

    @Test
    public void shouldReturnSupplied_entity() {
        assertThat(setWatchesAction.entity(), is(this.entity));
    }

    @Test(expected = NullPointerException.class)
    public void shouldThrowNullPointerExceptionIf_watches_IsNull() {
        new SetWatchesAction(projectId, userId, entity, null);
    }

    @Test
    public void shouldReturnSupplied_watches() {
        assertThat(setWatchesAction.watches(), is(this.watches));
    }

    @Test
    public void shouldBeEqualToSelf() {
        assertThat(setWatchesAction, is(setWatchesAction));
    }

    @Test
    public void shouldNotBeEqualToNull() {
        assertThat(setWatchesAction.equals(null), is(false));
    }

    @Test
    public void shouldBeEqualToOther() {
        assertThat(setWatchesAction, is(new SetWatchesAction(projectId, userId, entity, watches)));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_projectId() {
        assertThat(setWatchesAction, is(not(new SetWatchesAction(ProjectId.generate(), userId, entity, watches))));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_userId() {
        assertThat(setWatchesAction, is(not(new SetWatchesAction(projectId, new UserId("OtherUser"), entity, watches))));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_entity() {
        assertThat(setWatchesAction, is(not(new SetWatchesAction(projectId, userId, mock(OWLEntity.class), watches))));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_watches() {
        assertThat(setWatchesAction, is(not(new SetWatchesAction(projectId, userId, entity, mock(ImmutableSet.class)))));
    }

    @Test
    public void shouldBeEqualToOtherHashCode() {
        assertThat(setWatchesAction.hashCode(), is(new SetWatchesAction(projectId, userId, entity, watches)
                                                                               .hashCode()));
    }

    @Test
    public void shouldImplementToString() {
        assertThat(setWatchesAction.toString(), Matchers.startsWith("SetWatchesAction"));
    }

}
