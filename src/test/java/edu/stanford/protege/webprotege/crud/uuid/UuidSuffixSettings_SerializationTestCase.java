package edu.stanford.protege.webprotege.crud.uuid;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.stanford.protege.webprotege.crud.EntityCrudKitSuffixSettings;

import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2020-04-06
 */
public class UuidSuffixSettings_SerializationTestCase {

    @Test
    public void shouldDeserializeLegacySerialization() throws IOException {
        var serialization = "{\"_class\" : \"edu.stanford.bmir.protege.web.shared.crud.uuid.UUIDSuffixSettings\"}";
    }

    @Test
    public void shouldSerializeDefaultSettings() throws IOException {
        var settings = UuidSuffixSettings.get();

    }
}
