package edu.stanford.protege.webprotege.crud.supplied;

import edu.stanford.protege.webprotege.crud.EntityCrudKitSuffixSettings;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;

import java.io.IOException;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2020-04-07
 */
@JsonTest
public class SuppliedNameSuffixSettings_SerializationTestCase {

    @Autowired
    private JacksonTester<EntityCrudKitSuffixSettings> tester;

    @Test
    public void shouldSerializeUuidSettingsWithDefaults() throws IOException {
        var settings = SuppliedNameSuffixSettings.get();
        var json = tester.write(settings);
        System.out.println(json.getJson());
        Assertions.assertThat(json).extractingJsonPathStringValue("['@type']").isEqualTo("SuppliedName");
        Assertions.assertThat(json).extractingJsonPathStringValue("whiteSpaceTreatment").isEqualTo("TRANSFORM_TO_CAMEL_CASE");
    }

    @Test
    public void shouldSerializeUuidSettingsWithNonDefaults() throws IOException {
        var settings = SuppliedNameSuffixSettings.get(WhiteSpaceTreatment.REPLACE_WITH_DASHES);
        var json = tester.write(settings);
        System.out.println(json.getJson());
        Assertions.assertThat(json).extractingJsonPathStringValue("['@type']").isEqualTo("SuppliedName");
        Assertions.assertThat(json).extractingJsonPathStringValue("whiteSpaceTreatment").isEqualTo("REPLACE_WITH_DASHES");
    }

    @Test
    void shouldDeserializeUuidSettingsWithStandardFormat() throws IOException {
        var json = """
                    {"@type":"SuppliedName","whiteSpaceTreatment":"REPLACE_WITH_DASHES"}
                """;
        var object = tester.parse(json);
        var content = object.getObject();
        Assertions.assertThat(content).isInstanceOf(SuppliedNameSuffixSettings.class);
        Assertions.assertThat(((SuppliedNameSuffixSettings) content).getWhiteSpaceTreatment()).isEqualTo(WhiteSpaceTreatment.REPLACE_WITH_DASHES);
    }

    @Test
    void shouldDeserializeUuidSettingsWithUnspecifiedWhiteSpaceTreatment() throws IOException {
        var json = """
                    {"@type":"SuppliedName"}
                """;
        var object = tester.parse(json);
        var content = object.getObject();
        Assertions.assertThat(content).isInstanceOf(SuppliedNameSuffixSettings.class);
        Assertions.assertThat(((SuppliedNameSuffixSettings) content).getWhiteSpaceTreatment()).isEqualTo(WhiteSpaceTreatment.TRANSFORM_TO_CAMEL_CASE);
    }
}
