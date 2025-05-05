package edu.stanford.protege.webprotege.tag;

import edu.stanford.protege.webprotege.color.Color;
import edu.stanford.protege.webprotege.common.ChangeRequestId;
import edu.stanford.protege.webprotege.common.ProjectId;
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
public class AddProjectTagAction_TestCase {

    private final String label = "The label";

    private final String description = "The description";

    private final ProjectId projectId = ProjectId.generate();

    private final ChangeRequestId changeRequestId = ChangeRequestId.generate();

    private AddProjectTagAction addProjectTagAction;

    @Mock
    private Color color;

    @Mock
    private Color backgroundColor;

    @BeforeEach
    public void setUp() {
        addProjectTagAction = AddProjectTagAction.create(changeRequestId, projectId, label, description, color, backgroundColor);
    }

    @SuppressWarnings("ConstantConditions")
    public void shouldThrowNullPointerExceptionIf_projectId_IsNull() {
        assertThrows(NullPointerException.class, () -> {
            AddProjectTagAction.create(changeRequestId, null, label, description, color, backgroundColor);
        });
    }

    @Test
    public void shouldReturnSupplied_projectId() {
        assertThat(addProjectTagAction.projectId(), is(this.projectId));
    }

    @SuppressWarnings("ConstantConditions")
    public void shouldThrowNullPointerExceptionIf_label_IsNull() {
        assertThrows(NullPointerException.class, () -> {
            AddProjectTagAction.create(changeRequestId, projectId, null, description, color, backgroundColor);
        });
    }

    @Test
    public void shouldReturnSupplied_label() {
        assertThat(addProjectTagAction.label(), is(this.label));
    }

    @SuppressWarnings("ConstantConditions")
    public void shouldThrowNullPointerExceptionIf_description_IsNull() {
        assertThrows(NullPointerException.class, () -> {
            AddProjectTagAction.create(changeRequestId, projectId, label, null, color, backgroundColor);
        });
    }

    @Test
    public void shouldReturnSupplied_description() {
        assertThat(addProjectTagAction.description(), is(this.description));
    }

    @SuppressWarnings("ConstantConditions")
    public void shouldThrowNullPointerExceptionIf_color_IsNull() {
        assertThrows(NullPointerException.class, () -> {
            AddProjectTagAction.create(changeRequestId, projectId, label, description, null, backgroundColor);
        });
    }

    @Test
    public void shouldReturnSupplied_color() {
        assertThat(addProjectTagAction.color(), is(this.color));
    }

    @SuppressWarnings("ConstantConditions")
    public void shouldThrowNullPointerExceptionIf_backgroundColor_IsNull() {
        assertThrows(NullPointerException.class, () -> {
            AddProjectTagAction.create(changeRequestId, projectId, label, description, color, null);
        });
    }

    @Test
    public void shouldReturnSupplied_backgroundColor() {
        assertThat(addProjectTagAction.backgroundColor(), is(this.backgroundColor));
    }

    @Test
    public void shouldBeEqualToSelf() {
        assertThat(addProjectTagAction, is(addProjectTagAction));
    }

    @Test
    @SuppressWarnings("ObjectEqualsNull")
    public void shouldNotBeEqualToNull() {
        assertThat(addProjectTagAction.equals(null), is(false));
    }

    @Test
    public void shouldBeEqualToOther() {
        assertThat(addProjectTagAction, is(AddProjectTagAction.create(changeRequestId, projectId, label, description, color, backgroundColor)));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_projectId() {
        assertThat(addProjectTagAction, is(not(AddProjectTagAction.create(changeRequestId, ProjectId.generate(), label, description, color, backgroundColor))));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_label() {
        assertThat(addProjectTagAction, is(not(AddProjectTagAction.create(changeRequestId, projectId, "String-3bba18b6-6903-4c92-8ffb-7b00cb3fef7a", description, color, backgroundColor))));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_description() {
        assertThat(addProjectTagAction, is(not(AddProjectTagAction.create(changeRequestId, projectId, label, "String-69702116-7cad-4810-b6f5-e844b8d51369", color, backgroundColor))));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_color() {
        assertThat(addProjectTagAction, is(not(AddProjectTagAction.create(changeRequestId, projectId, label, description, mock(Color.class), backgroundColor))));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_backgroundColor() {
        assertThat(addProjectTagAction, is(not(AddProjectTagAction.create(changeRequestId, projectId, label, description, color, mock(Color.class)))));
    }

    @Test
    public void shouldBeEqualToOtherHashCode() {
        assertThat(addProjectTagAction.hashCode(), is(AddProjectTagAction.create(changeRequestId, projectId, label, description, color, backgroundColor).hashCode()));
    }

    @Test
    public void shouldImplementToString() {
        assertThat(addProjectTagAction.toString(), startsWith("AddProjectTagAction"));
    }
}
