package edu.stanford.protege.webprotege.crud.obo;

import edu.stanford.protege.webprotege.crud.oboid.OboIdSuffixKit;
import edu.stanford.protege.webprotege.crud.oboid.OboIdSuffixSettings;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Author: Matthew Horridge<br>
 * Stanford University<br>
 * Bio-Medical Informatics Research Group<br>
 * Date: 21/08/2013
 */
public class OBOSuffixSettingsTestCase {

    @Test
    public void getKitIdReturnsTheCorrectId() {
        OboIdSuffixSettings settings = OboIdSuffixSettings.get();
        assertEquals(OboIdSuffixKit.getId(), settings.getKitId());
    }

    @Test
    public void shouldSupplyDefaultTotalDigits() {
        OboIdSuffixSettings settings = OboIdSuffixSettings.get();
        assertEquals(7, settings.getTotalDigits());
    }
}
