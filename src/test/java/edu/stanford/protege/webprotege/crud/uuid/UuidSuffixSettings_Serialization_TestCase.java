package edu.stanford.protege.webprotege.crud.uuid;

import edu.stanford.protege.webprotege.crud.EntityCrudKitSuffixSettings;
import edu.stanford.protege.webprotege.crud.uuid.UuidFormat;
import edu.stanford.protege.webprotege.crud.uuid.UuidSuffixSettings;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2020-04-07
 */
@JsonTest
public class UuidSuffixSettings_Serialization_TestCase {

    @Autowired
    private JacksonTester<EntityCrudKitSuffixSettings> tester;

    @Test
    public void shouldSerializeUuidSettingsWithDefaultFormat() throws IOException {
        var settings = UuidSuffixSettings.get();
        var json = tester.write(settings);
        System.out.println(json.getJson());
        assertThat(json).extractingJsonPathStringValue("['@type']").isEqualTo("Uuid");
        assertThat(json).extractingJsonPathStringValue("uuidFormat").isEqualTo("BASE62");
    }

    @Test
    public void shouldSerializeUuidSettingsWithStandardFormat() throws IOException {
        var settings = UuidSuffixSettings.get(UuidFormat.STANDARD);
        var json = tester.write(settings);
        System.out.println(json.getJson());
        assertThat(json).extractingJsonPathStringValue("['@type']").isEqualTo("Uuid");
        assertThat(json).extractingJsonPathStringValue("uuidFormat").isEqualTo("STANDARD");
    }

    @Test
    void shouldDeserializeUuidSettingsWithStandardFormat() throws IOException {
        var json = """
                    {"@type":"Uuid","uuidFormat":"STANDARD"}
                """;
        var object = tester.parse(json);
        var content = object.getObject();
        assertThat(content).isInstanceOf(UuidSuffixSettings.class);
        assertThat(((UuidSuffixSettings) content).getUuidFormat()).isEqualTo(UuidFormat.STANDARD);
    }

    @Test
    void shouldDeserializeUuidSettingsWithUnspecifiedFormat() throws IOException {
        var json = """
                    {"@type":"Uuid"}
                """;
        var object = tester.parse(json);
        var content = object.getObject();
        assertThat(content).isInstanceOf(UuidSuffixSettings.class);
        assertThat(((UuidSuffixSettings) content).getUuidFormat()).isEqualTo(UuidFormat.BASE62);
    }
}
