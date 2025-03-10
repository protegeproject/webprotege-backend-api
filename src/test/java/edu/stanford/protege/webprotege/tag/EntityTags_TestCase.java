package edu.stanford.protege.webprotege.tag;

import edu.stanford.protege.webprotege.common.ProjectId;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.semanticweb.owlapi.model.OWLEntity;

import java.util.Collections;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
public class EntityTags_TestCase {

    private final List<TagId> tags = Collections.singletonList(mock(TagId.class));

    private final ProjectId projectId = ProjectId.generate();

    private EntityTags entityTags;

    @Mock
    private OWLEntity entity;

    @BeforeEach
    public void setUp() {
        entityTags = new EntityTags(projectId, entity, tags);
    }

    @SuppressWarnings("ConstantConditions")
    public void shouldThrowNullPointerExceptionIf_projectId_IsNull() {
        assertThrows(NullPointerException.class, () -> {
            new EntityTags(null, entity, tags);
        });
    }

    @Test
    public void shouldReturnSupplied_projectId() {
        assertThat(entityTags.getProjectId(), is(this.projectId));
    }

    @SuppressWarnings("ConstantConditions")
    public void shouldThrowNullPointerExceptionIf_entity_IsNull() {
        assertThrows(NullPointerException.class, () -> {
            new EntityTags(projectId, null, tags);
        });
    }

    @Test
    public void shouldReturnSupplied_entity() {
        assertThat(entityTags.getEntity(), is(this.entity));
    }

    @SuppressWarnings("ConstantConditions")
    public void shouldThrowNullPointerExceptionIf_tags_IsNull() {
        assertThrows(NullPointerException.class, () -> {
            new EntityTags(projectId, entity, null);
        });
    }

    @Test
    public void shouldReturnSupplied_tags() {
        assertThat(entityTags.getTags(), is(this.tags));
    }

    @Test
    public void shouldBeEqualToSelf() {
        assertThat(entityTags, is(entityTags));
    }

    @Test
    @SuppressWarnings("ObjectEqualsNull")
    public void shouldNotBeEqualToNull() {
        assertThat(entityTags.equals(null), is(false));
    }

    @Test
    public void shouldBeEqualToOther() {
        assertThat(entityTags, is(new EntityTags(projectId, entity, tags)));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_projectId() {
        assertThat(entityTags, is(not(new EntityTags(ProjectId.generate(), entity, tags))));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_entity() {
        assertThat(entityTags, is(not(new EntityTags(projectId, mock(OWLEntity.class), tags))));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_tags() {
        assertThat(entityTags, is(not(new EntityTags(projectId, entity, Collections.singletonList(mock(TagId.class))))));
    }

    @Test
    public void shouldBeEqualToOtherHashCode() {
        assertThat(entityTags.hashCode(), is(new EntityTags(projectId, entity, tags).hashCode()));
    }

    @Test
    public void shouldImplementToString() {
        assertThat(entityTags.toString(), Matchers.startsWith("EntityTags"));
    }

}
