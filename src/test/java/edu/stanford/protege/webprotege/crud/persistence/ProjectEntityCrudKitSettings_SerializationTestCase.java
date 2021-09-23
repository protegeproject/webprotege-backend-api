package edu.stanford.protege.webprotege.crud.persistence;

import edu.stanford.protege.webprotege.crud.EntityCrudKitPrefixSettings;
import edu.stanford.protege.webprotege.crud.EntityCrudKitSettings;
import edu.stanford.protege.webprotege.crud.gen.GeneratedAnnotationsSettings;
import edu.stanford.protege.webprotege.crud.uuid.UuidSuffixSettings;

import edu.stanford.protege.webprotege.common.ProjectId;
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
public class ProjectEntityCrudKitSettings_SerializationTestCase {


    private final ProjectId projectId = ProjectId.valueOf("12345678-1234-1234-1234-123456789abc");

    private ProjectEntityCrudKitSettings settings;

    @Autowired
    private JacksonTester<ProjectEntityCrudKitSettings> tester;

    @BeforeEach
    public void setUp() {
        settings = ProjectEntityCrudKitSettings.get(projectId,
                                                    EntityCrudKitSettings.get(
                                                            EntityCrudKitPrefixSettings.get(),
                                                            UuidSuffixSettings.get(),
                                                            GeneratedAnnotationsSettings.empty()
                                                    ));
    }

    @Test
    public void shouldRoundTrip() throws IOException {
        var json = tester.write(settings);
        System.out.println(json.getJson());
        var parsed = tester.parse(json.getJson());
        var parsedContent = parsed.getObject();
        assertThat(parsedContent).isEqualTo(settings);
    }
}
