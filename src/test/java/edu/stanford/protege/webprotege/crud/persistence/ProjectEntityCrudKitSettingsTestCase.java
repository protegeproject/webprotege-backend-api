package edu.stanford.protege.webprotege.crud.persistence;

import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.crud.EntityCrudKitSettings;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;

/**
 * Author: Matthew Horridge<br>
 * Stanford University<br>
 * Bio-Medical Informatics Research Group<br>
 * Date: 21/08/2013
 */
public class ProjectEntityCrudKitSettingsTestCase {

    public static final String PROJECT_ID_FIELD_NAME = "projectId";

    public void shouldThrowNullPointerExceptionForNullProjectIdInConstructor() {
        assertThrows(NullPointerException.class, () -> {
            ProjectEntityCrudKitSettings.get(null, mock(EntityCrudKitSettings.class));
        });
    }

    public void shouldThrowNullPointerExceptionForNullEntityCrudKitSettings() {
        assertThrows(NullPointerException.class, () -> {
            ProjectEntityCrudKitSettings.get(ProjectId.generate(), null);
        });
    }

    @Test
    public void getProjectIdShouldReturnValueEqualToProjectIdSuppliedInConstructor() {
        ProjectId projectId = ProjectId.generate();
        ProjectEntityCrudKitSettings settings = ProjectEntityCrudKitSettings.get(projectId, mock(EntityCrudKitSettings.class));
        assertEquals(projectId, settings.getProjectId());
    }

    @Test
    public void getSettingsShouldReturnValueEqualToSettingsSuppliedInConstructor() {
        EntityCrudKitSettings entityCrudKitSettings = mock(EntityCrudKitSettings.class);
        ProjectEntityCrudKitSettings settings = ProjectEntityCrudKitSettings.get(ProjectId.generate(), entityCrudKitSettings);
        assertEquals(entityCrudKitSettings, settings.getSettings());
    }

    @Test
    public void hashCodeShouldBeEqualForSameProjectIdAndSettings() {
        ProjectId projectId = ProjectId.generate();
        EntityCrudKitSettings settings = mock(EntityCrudKitSettings.class);
        ProjectEntityCrudKitSettings settingsA = ProjectEntityCrudKitSettings.get(projectId, settings);
        ProjectEntityCrudKitSettings settingsB = ProjectEntityCrudKitSettings.get(projectId, settings);
        assertEquals(settingsA.hashCode(), settingsB.hashCode());
    }

    @Test
    public void equalsShouldReturnTrueForEqualProjectIdAndEqualSettings() {
        ProjectId projectId = ProjectId.generate();
        EntityCrudKitSettings settings = mock(EntityCrudKitSettings.class);
        ProjectEntityCrudKitSettings settingsA = ProjectEntityCrudKitSettings.get(projectId, settings);
        ProjectEntityCrudKitSettings settingsB = ProjectEntityCrudKitSettings.get(projectId, settings);
        assertEquals(settingsA, settingsB);
    }
}
