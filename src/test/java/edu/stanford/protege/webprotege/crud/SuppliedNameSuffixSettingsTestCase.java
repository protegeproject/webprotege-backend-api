package edu.stanford.protege.webprotege.crud;

import edu.stanford.protege.webprotege.crud.supplied.SuppliedNameSuffixSettings;
import edu.stanford.protege.webprotege.crud.supplied.WhiteSpaceTreatment;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Author: Matthew Horridge<br>
 * Stanford University<br>
 * Bio-Medical Informatics Research Group<br>
 * Date: 8/19/13
 */
public class SuppliedNameSuffixSettingsTestCase {

    @Test
    public void shouldReturnDefaultValueForWhiteSpaceTreatment() {
        SuppliedNameSuffixSettings settings = SuppliedNameSuffixSettings.get();
        assertEquals(settings.getWhiteSpaceTreatment(), WhiteSpaceTreatment.TRANSFORM_TO_CAMEL_CASE);
    }

    @Test
    public void shouldReturnSuppliedWhiteSpaceTreatment() {
        SuppliedNameSuffixSettings settings = SuppliedNameSuffixSettings.get(WhiteSpaceTreatment.ESCAPE);
        assertEquals(settings.getWhiteSpaceTreatment(), WhiteSpaceTreatment.ESCAPE);
    }
}
