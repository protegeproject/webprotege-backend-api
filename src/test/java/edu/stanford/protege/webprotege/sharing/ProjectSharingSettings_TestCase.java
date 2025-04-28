package edu.stanford.protege.webprotege.sharing;

import edu.stanford.protege.webprotege.common.ProjectId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
public class ProjectSharingSettings_TestCase {

    private final Optional<SharingPermission> linkSharingPermission = Optional.of(SharingPermission.EDIT);

    private final List<SharingSetting> sharingSettings = new ArrayList<>();

    private final ProjectId projectId = ProjectId.generate();

    private ProjectSharingSettings projectSharingSettings;

    @BeforeEach
    public void setUp() {
        projectSharingSettings = new ProjectSharingSettings(projectId, linkSharingPermission, sharingSettings);
    }

    public void shouldThrowNullPointerExceptionIf_projectId_IsNull() {
        assertThrows(NullPointerException.class, () -> {
            new ProjectSharingSettings(null, linkSharingPermission, sharingSettings);
        });
    }

    @Test
    public void shouldReturnSupplied_projectId() {
        assertThat(projectSharingSettings.getProjectId(), is(this.projectId));
    }

    public void shouldThrowNullPointerExceptionIf_linkSharingPermission_IsNull() {
        assertThrows(NullPointerException.class, () -> {
            new ProjectSharingSettings(projectId, null, sharingSettings);
        });
    }

    @Test
    public void shouldReturnSupplied_linkSharingPermission() {
        assertThat(projectSharingSettings.getLinkSharingPermission(), is(this.linkSharingPermission));
    }

    public void shouldThrowNullPointerExceptionIf_sharingSettings_IsNull() {
        assertThrows(NullPointerException.class, () -> {
            new ProjectSharingSettings(projectId, linkSharingPermission, null);
        });
    }

    @Test
    public void shouldReturnSupplied_sharingSettings() {
        assertThat(projectSharingSettings.getSharingSettings(), is(this.sharingSettings));
    }

    @Test
    public void shouldBeEqualToSelf() {
        assertThat(projectSharingSettings, is(projectSharingSettings));
    }

    @Test
    public void shouldNotBeEqualToNull() {
        assertThat(projectSharingSettings.equals(null), is(false));
    }

    @Test
    public void shouldBeEqualToOther() {
        assertThat(projectSharingSettings, is(new ProjectSharingSettings(projectId, linkSharingPermission, sharingSettings)));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_projectId() {
        assertThat(projectSharingSettings, is(not(new ProjectSharingSettings(ProjectId.generate(), linkSharingPermission, sharingSettings))));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_linkSharingPermission() {
        assertThat(projectSharingSettings, is(not(new ProjectSharingSettings(projectId, Optional.of(SharingPermission.COMMENT), sharingSettings))));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_sharingSettings() {
        ArrayList<SharingSetting> otherSharingSettings = new ArrayList<>();
        otherSharingSettings.add(mock(SharingSetting.class));
        assertThat(projectSharingSettings, is(not(new ProjectSharingSettings(projectId, linkSharingPermission, otherSharingSettings))));
    }

    @Test
    public void shouldBeEqualToOtherHashCode() {
        assertThat(projectSharingSettings.hashCode(), is(new ProjectSharingSettings(projectId, linkSharingPermission, sharingSettings).hashCode()));
    }

    @Test
    public void shouldImplementToString() {
        assertThat(projectSharingSettings.toString(), startsWith("ProjectSharingSettings"));
    }

}
