package edu.stanford.protege.webprotege.crud.supplied;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2020-04-07
 */
public class SuppliedNameSuffixSettings_SerializationTestCase {

    @Test
    public void shouldRoundTrip() throws IOException {
        var settings = SuppliedNameSuffixSettings.get(WhiteSpaceTreatment.REPLACE_WITH_DASHES);

    }

    @Test
    public void shouldDeserializeFullClassNameForBackwardsCompatibility() throws IOException {
        var serialization = "{\"_class\" : \"edu.stanford.protege.webprotege.crud.supplied.SuppliedNameSuffixSettings\"}";
    }
}
