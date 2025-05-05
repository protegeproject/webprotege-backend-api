package edu.stanford.protege.webprotege.crud;

import edu.stanford.protege.webprotege.crud.gen.GeneratedAnnotationsSettings;
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
public class EntityCrudKitSettingsTestCase {

    public void constructorThrowsNullPointerExceptionIfPrefixSettingsIsNull() {
        assertThrows(NullPointerException.class, () -> {
            EntityCrudKitSettings.get(null, mock(EntityCrudKitSuffixSettings.class), mock(GeneratedAnnotationsSettings.class));
        });
    }

    public void constructorThrowsNullPointerExceptionIfSuffixSettingsIsNull() {
        assertThrows(NullPointerException.class, () -> {
            EntityCrudKitSettings.get(EntityCrudKitPrefixSettings.get(), null, mock(GeneratedAnnotationsSettings.class));
        });
    }

    @Test
    public void objectsWithSamePrefixAndSuffixSettingsHaveEqualHashCodes() {
        EntityCrudKitPrefixSettings prefixSettings = EntityCrudKitPrefixSettings.get();
        EntityCrudKitSuffixSettings suffixSettings = mock(EntityCrudKitSuffixSettings.class);
        GeneratedAnnotationsSettings generatedAnnotationsSettings = mock(GeneratedAnnotationsSettings.class);
        EntityCrudKitSettings settingsA = EntityCrudKitSettings.get(prefixSettings, suffixSettings, generatedAnnotationsSettings);
        EntityCrudKitSettings settingsB = EntityCrudKitSettings.get(prefixSettings, suffixSettings, generatedAnnotationsSettings);
        assertEquals(settingsA.hashCode(), settingsB.hashCode());
    }

    @Test
    public void objectsWithSamePrefixAndSuffixSettingsAreEqual() {
        EntityCrudKitPrefixSettings prefixSettings = EntityCrudKitPrefixSettings.get();
        EntityCrudKitSuffixSettings suffixSettings = mock(EntityCrudKitSuffixSettings.class);
        GeneratedAnnotationsSettings generatedAnnotationsSettings = mock(GeneratedAnnotationsSettings.class);
        EntityCrudKitSettings settingsA = EntityCrudKitSettings.get(prefixSettings, suffixSettings, generatedAnnotationsSettings);
        EntityCrudKitSettings settingsB = EntityCrudKitSettings.get(prefixSettings, suffixSettings, generatedAnnotationsSettings);
        assertEquals(settingsA, settingsB);
    }

}
