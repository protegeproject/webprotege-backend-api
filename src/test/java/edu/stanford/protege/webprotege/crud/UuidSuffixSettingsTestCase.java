package edu.stanford.protege.webprotege.crud;

import edu.stanford.protege.webprotege.crud.uuid.UuidSuffixKit;
import edu.stanford.protege.webprotege.crud.uuid.UuidSuffixSettings;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Author: Matthew Horridge<br>
 * Stanford University<br>
 * Bio-Medical Informatics Research Group<br>
 * Date: 16/08/2013
 */
public class UuidSuffixSettingsTestCase {

    @Test
    public void equalsReturnsTrueForDifferentObjects() {
        UuidSuffixSettings settingsA = UuidSuffixSettings.get();
        UuidSuffixSettings settingsB = UuidSuffixSettings.get();
        assertEquals(settingsA, settingsB);
    }

    @Test
    public void hashCodeReturnsSameValueForDifferentObjects() {
        UuidSuffixSettings settingsA = UuidSuffixSettings.get();
        UuidSuffixSettings settingsB = UuidSuffixSettings.get();
        assertEquals(settingsA.hashCode(), settingsB.hashCode());
    }

    @Test
    public void getKitIdIsNotNull() {
        UuidSuffixSettings settings = UuidSuffixSettings.get();
        EntityCrudKitId kitId = settings.getKitId();
        assertNotNull(kitId);
    }

    @Test
    public void getKitIdMatchesUUIDDescriptorId() {
        UuidSuffixSettings settings = UuidSuffixSettings.get();
        assertEquals(UuidSuffixKit.getId(), settings.getKitId());
    }

}
