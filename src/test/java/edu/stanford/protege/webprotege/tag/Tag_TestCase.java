package edu.stanford.protege.webprotege.tag;

import com.google.common.collect.ImmutableList;
import edu.stanford.protege.webprotege.color.Color;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.criteria.RootCriteria;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
public class Tag_TestCase {

    private final String tagLabel = "The label";

    private final String description = "The description";

    private final ProjectId projectId = ProjectId.generate();

    private Tag tag;

    @Mock
    private TagId tagId;

    @Mock
    private Color color;

    @Mock
    private Color backgroundColor;

    private ImmutableList<RootCriteria> criteria;

    @Mock
    private RootCriteria rootCriteria;

    @BeforeEach
    public void setUp() {
        criteria = ImmutableList.of(rootCriteria);
        tag = Tag.get(tagId, projectId, tagLabel, description, color, backgroundColor, criteria);
    }

    @SuppressWarnings("ConstantConditions")
    public void shouldThrowNullPointerExceptionIf_tagId_IsNull() {
        assertThrows(NullPointerException.class, () -> {
            Tag.get(null, projectId, tagLabel, description, color, backgroundColor, criteria);
        });
    }

    @Test
    public void shouldReturnSupplied_tagId() {
        assertThat(tag.getTagId(), is(this.tagId));
    }

    @SuppressWarnings("ConstantConditions")
    public void shouldThrowNullPointerExceptionIf_projectId_IsNull() {
        assertThrows(NullPointerException.class, () -> {
            Tag.get(tagId, null, tagLabel, description, color, backgroundColor, criteria);
        });
    }

    @Test
    public void shouldReturnSupplied_projectId() {
        assertThat(tag.getProjectId(), is(this.projectId));
    }

    @SuppressWarnings("ConstantConditions")
    public void shouldThrowNullPointerExceptionIf_tagLabel_IsNull() {
        assertThrows(NullPointerException.class, () -> {
            Tag.get(tagId, projectId, null, description, color, backgroundColor, criteria);
        });
    }

    @Test
    public void shouldReturnSupplied_tagLabel() {
        assertThat(tag.getLabel(), is(this.tagLabel));
    }

    @Test
    public void shouldReturnSupplied_description() {
        assertThat(tag.getDescription(), is(this.description));
    }

    @SuppressWarnings("ConstantConditions")
    public void shouldThrowNullPointerExceptionIf_color_IsNull() {
        assertThrows(NullPointerException.class, () -> {
            Tag.get(tagId, projectId, tagLabel, description, null, backgroundColor, criteria);
        });
    }

    @Test
    public void shouldReturnSupplied_color() {
        assertThat(tag.getColor(), is(this.color));
    }

    @SuppressWarnings("ConstantConditions")
    public void shouldThrowNullPointerExceptionIf_backgroundColor_IsNull() {
        assertThrows(NullPointerException.class, () -> {
            Tag.get(tagId, projectId, tagLabel, description, color, null, criteria);
        });
    }

    @Test
    public void shouldReturnSupplied_backgroundColor() {
        assertThat(tag.getBackgroundColor(), is(this.backgroundColor));
    }

    @Test
    public void shouldBeEqualToSelf() {
        assertThat(tag, is(tag));
    }

    @Test
    @SuppressWarnings("ObjectEqualsNull")
    public void shouldNotBeEqualToNull() {
        assertThat(tag.equals(null), is(false));
    }

    @Test
    public void shouldBeEqualToOther() {
        assertThat(tag, is(Tag.get(tagId, projectId, tagLabel, description, color, backgroundColor, criteria)));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_tagId() {
        assertThat(tag, is(not(Tag.get(mock(TagId.class), projectId, tagLabel, description, color, backgroundColor, criteria))));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_projectId() {
        assertThat(tag, is(not(Tag.get(tagId, ProjectId.generate(), tagLabel, description, color, backgroundColor, criteria))));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_tagLabel() {
        assertThat(tag, is(not(Tag.get(tagId, projectId, "String-c3bf64b2-a1f6-460b-9cbb-deb440eaefe3", description, color, backgroundColor, criteria))));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_description() {
        assertThat(tag, is(not(Tag.get(tagId, projectId, tagLabel, "String-5a51416b-66bd-4f1c-bbbc-ca20837cd576", color, backgroundColor, criteria))));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_color() {
        assertThat(tag, is(not(Tag.get(tagId, projectId, tagLabel, description, mock(Color.class), backgroundColor, criteria))));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_backgroundColor() {
        assertThat(tag, is(not(Tag.get(tagId, projectId, tagLabel, description, color, mock(Color.class), criteria))));
    }

    @Test
    public void shouldBeEqualToOtherHashCode() {
        assertThat(tag.hashCode(), is(Tag.get(tagId, projectId, tagLabel, description, color, backgroundColor, criteria).hashCode()));
    }

    @Test
    public void shouldImplementToString() {
        assertThat(tag.toString(), startsWith("Tag"));
    }

}
