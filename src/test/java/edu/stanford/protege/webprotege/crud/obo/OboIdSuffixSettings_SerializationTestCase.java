package edu.stanford.protege.webprotege.crud.obo;

import com.google.common.collect.ImmutableList;
import edu.stanford.protege.webprotege.common.UserId;
import edu.stanford.protege.webprotege.crud.EntityCrudKitSuffixSettings;
import edu.stanford.protege.webprotege.crud.oboid.OboIdSuffixSettings;
import edu.stanford.protege.webprotege.crud.oboid.UserIdRange;
import edu.stanford.protege.webprotege.jackson.WebProtegeJacksonApplication;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.context.annotation.Import;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2020-04-07
 */
@JsonTest
@Import(WebProtegeJacksonApplication.class)
public class OboIdSuffixSettings_SerializationTestCase {

    public static final int TOTAL_DIGITS = 77;

    public static final int START = 100;

    public static final int END = 203;

    public static final UserId THE_USER = UserId.valueOf("TheUser");

    private OboIdSuffixSettings settings;

    @Autowired
    private JacksonTester<EntityCrudKitSuffixSettings> tester;

    @BeforeEach
    public void setUp() {
        settings = OboIdSuffixSettings.get(
                TOTAL_DIGITS,
                ImmutableList.of(
                        UserIdRange.get(THE_USER, START, END)
                )
        );
    }

    @Test
    public void shouldSerializeSettings() throws IOException {
        var json = tester.write(settings);
        System.out.println(json.getJson());
        assertThat(json).extractingJsonPathStringValue("['@type']").isEqualTo("OboId");
        assertThat(json).extractingJsonPathNumberValue("totalDigits").isEqualTo(77);
        assertThat(json).hasJsonPathValue("userIdRanges");
    }

    @Test
    public void shouldDeserializeSettings() throws IOException {
        var serialization = "{\"@type\":\"OboId\",\"totalDigits\":77,\"userIdRanges\":[{\"userId\":\"TheUser\",\"start\":100,\"end\":203}]}";
        var content = tester.parse(serialization);
        var object = content.getObject();
        assertThat(object).isEqualTo(settings);
    }
}
