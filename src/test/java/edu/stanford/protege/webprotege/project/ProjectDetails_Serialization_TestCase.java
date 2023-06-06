package edu.stanford.protege.webprotege.project;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableList;
import edu.stanford.protege.webprotege.common.DictionaryLanguage;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.common.UserId;
import edu.stanford.protege.webprotege.jackson.WebProtegeJacksonApplication;
import edu.stanford.protege.webprotege.lang.DisplayNameSettings;
import edu.stanford.protege.webprotege.projectsettings.EntityDeprecationSettings;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

import javax.annotation.Nonnull;
import java.io.IOException;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 18 Jul 2018
 */
@SpringBootTest
@Import(WebProtegeJacksonApplication.class)
public class ProjectDetails_Serialization_TestCase {

    private ProjectDetails projectDetails;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    public void setUp() {
        projectDetails = ProjectDetails.get(ProjectId.valueOf("12345678-1234-1234-1234-123456789abc"),
                                            "The display name",
                                            "The description",
                                            UserId.valueOf("The Owner"),
                                            true,
                                            DictionaryLanguage.rdfsLabel("en-GB"),
                                            DisplayNameSettings.get(ImmutableList.of(DictionaryLanguage.rdfsLabel("en-GB"),
                                                                                     DictionaryLanguage.rdfsLabel("en"),
                                                                                     DictionaryLanguage.rdfsLabel("")),
                                                                    ImmutableList.of(DictionaryLanguage.rdfsLabel("de"))),
                                            2L,
                                            UserId.valueOf("The creator"),
                                            3L,
                                            UserId.valueOf("The modifier"),
                                            EntityDeprecationSettings.empty());
    }

    @Test
    public void shouldSerializeToJson() throws IOException {
        String val = objectMapper.writeValueAsString(projectDetails);
        System.out.println(val);
        ProjectDetails readProjectDetails = objectMapper.readValue(val, ProjectDetails.class);
        assertThat(readProjectDetails, is(projectDetails));
    }

    @Test
    public void shouldDeserializeFromJsonWithMissingDescription() {
        ProjectDetails readProjectDetails = roundTripWithoutField(ProjectDetails.DESCRIPTION);
        assertThat(readProjectDetails, is(projectDetails.withDescription("")));
    }

    @Test
    public void shouldDeserializeFromJsonWithMissingDefaultLanguage() {
        ProjectDetails readProjectDetails = roundTripWithoutField(ProjectDetails.DEFAULT_LANGUAGE);
        DictionaryLanguage expectedDefaultLanguage = DictionaryLanguage.rdfsLabel("");
        assertThat(readProjectDetails, is(projectDetails.withDefaultLanguage(expectedDefaultLanguage)));
    }

    private ProjectDetails roundTripWithoutField(@Nonnull String fieldName) {
        Map document = objectMapper.convertValue(projectDetails, Map.class);
        document.remove(fieldName);
        return objectMapper.convertValue(document, ProjectDetails.class);
    }
}
