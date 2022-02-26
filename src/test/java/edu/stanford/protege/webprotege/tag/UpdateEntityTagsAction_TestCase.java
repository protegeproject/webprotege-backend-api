
package edu.stanford.protege.webprotege.tag;

import edu.stanford.protege.webprotege.common.ChangeRequestId;
import edu.stanford.protege.webprotege.common.ProjectId;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.semanticweb.owlapi.model.OWLEntity;

import java.util.Collections;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class)
public class UpdateEntityTagsAction_TestCase {

    private UpdateEntityTagsAction action;

    private ProjectId projectId = ProjectId.generate();

    @Mock
    private OWLEntity entity;

    @Mock
    private Set<TagId> fromTagIds;

    @Mock
    private Set<TagId> toTagIds;

    private ChangeRequestId changeRequestId = ChangeRequestId.generate();

    @Before
    public void setUp() {
        fromTagIds = Collections.singleton(mock(TagId.class));
        toTagIds = Collections.singleton(mock(TagId.class));
        action = new UpdateEntityTagsAction(changeRequestId, projectId, entity, fromTagIds, toTagIds);
    }

    @SuppressWarnings("ConstantConditions")
    @Test(expected = NullPointerException.class)
    public void shouldThrowNullPointerExceptionIf_projectId_IsNull() {
        new UpdateEntityTagsAction(changeRequestId, null, entity, fromTagIds, toTagIds);
    }

    @Test
    public void shouldReturnSupplied_projectId() {
        assertThat(action.projectId(), is(this.projectId));
    }

    @SuppressWarnings("ConstantConditions")
    @Test(expected = NullPointerException.class)
    public void shouldThrowNullPointerExceptionIf_entity_IsNull() {
        new UpdateEntityTagsAction(changeRequestId, projectId, null, fromTagIds, toTagIds);
    }

    @Test
    public void shouldReturnSupplied_entity() {
        assertThat(action.entity(), is(this.entity));
    }

    @SuppressWarnings("ConstantConditions")
    @Test(expected = NullPointerException.class)
    public void shouldThrowNullPointerExceptionIf_fromTagIds_IsNull() {
        new UpdateEntityTagsAction(changeRequestId, projectId, entity, null, toTagIds);
    }

    @Test
    public void shouldReturnSupplied_fromTagIds() {
        assertThat(action.fromTagIds(), is(this.fromTagIds));
    }

    @SuppressWarnings("ConstantConditions")
    @Test(expected = NullPointerException.class)
    public void shouldThrowNullPointerExceptionIf_toTagIds_IsNull() {
        new UpdateEntityTagsAction(changeRequestId, projectId, entity, fromTagIds, null);
    }

    @Test
    public void shouldReturnSupplied_toTagIds() {
        assertThat(action.toTagIds(), is(this.toTagIds));
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
        assertThat(action, is(new UpdateEntityTagsAction(changeRequestId, projectId, entity, fromTagIds, toTagIds)));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_projectId() {
        assertThat(action, is(Matchers.not(new UpdateEntityTagsAction(changeRequestId,
                                                                      ProjectId.generate(), entity, fromTagIds, toTagIds))));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_entity() {
        assertThat(action, is(Matchers.not(new UpdateEntityTagsAction(changeRequestId,
                                                                      projectId, mock(OWLEntity.class), fromTagIds, toTagIds))));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_fromTagIds() {
        assertThat(action, is(Matchers.not(new UpdateEntityTagsAction(changeRequestId,
                                                                      projectId, entity, Collections.singleton(mock(TagId.class)), toTagIds))));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_toTagIds() {
        assertThat(action, is(Matchers.not(new UpdateEntityTagsAction(changeRequestId,
                                                                      projectId, entity, fromTagIds, Collections.singleton(mock(TagId.class))))));
    }

    @Test
    public void shouldBeEqualToOtherHashCode() {
        assertThat(action.hashCode(), is(new UpdateEntityTagsAction(changeRequestId,
                                                                    projectId, entity, fromTagIds, toTagIds).hashCode()));
    }

    @Test
    public void shouldImplementToString() {
        assertThat(action.toString(), Matchers.startsWith("UpdateEntityTagsAction"));
    }

}
