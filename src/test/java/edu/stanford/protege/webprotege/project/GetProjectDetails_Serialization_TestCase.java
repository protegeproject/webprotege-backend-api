package edu.stanford.protege.webprotege.project;

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
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.context.annotation.Import;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 18 Jul 2018
 */
@JsonTest
@Import(WebProtegeJacksonApplication.class)
public class GetProjectDetails_Serialization_TestCase {

    private ProjectDetails projectDetails;

    @Autowired
    private JacksonTester<ProjectDetails> tester;

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
        var val = tester.write(projectDetails);
        System.out.println(val.getJson());
        var readProjectDetails = tester.parse(val.getJson());
        assertThat(readProjectDetails.getObject(), is(projectDetails));
    }
}
