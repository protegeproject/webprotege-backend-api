package edu.stanford.protege.webprotege.match.tag;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableList;
import edu.stanford.protege.webprotege.color.Color;
import edu.stanford.protege.webprotege.common.WebProtegeCommonConfiguration;
import edu.stanford.protege.webprotege.criteria.EntityIsNotDeprecatedCriteria;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.ipc.WebProtegeIpcApplication;
import edu.stanford.protege.webprotege.jackson.WebProtegeJacksonApplication;
import edu.stanford.protege.webprotege.tag.Tag;
import edu.stanford.protege.webprotege.tag.TagId;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.context.annotation.Import;

import java.io.StringReader;
import java.io.StringWriter;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 21 Jun 2018
 */
@JsonTest
public class Tag_Serialization_TestCase {

    @Autowired
    private JacksonTester<Tag> tester;

    @Test
    public void shouldSerializeTag() throws Exception {
        var tagId = TagId.createTagId();
        Tag tag = Tag.get(tagId,
                          ProjectId.valueOf("12345678-1234-1234-1234-123456789abc"),
                          "The label",
                          "The description",
                          Color.getRGB(1, 2, 3),
                          Color.getRGB(5, 6, 7),
                          ImmutableList.of(EntityIsNotDeprecatedCriteria.get()));
        var json = tester.write(tag);
        assertThat(json).extractingJsonPathStringValue("_id").isEqualTo(tagId.value());
        assertThat(json).extractingJsonPathStringValue("projectId").isEqualTo("12345678-1234-1234-1234-123456789abc");
        assertThat(json).extractingJsonPathStringValue("label").isEqualTo("The label");
        assertThat(json).extractingJsonPathStringValue("description").isEqualTo("The description");
        assertThat(json).extractingJsonPathStringValue("color").isEqualTo("#010203");
        assertThat(json).extractingJsonPathStringValue("backgroundColor").isEqualTo("#050607");
        assertThat(json).hasJsonPathValue("criteria");
    }

    /**
     * Test to handle loading of tags that did not have previous criteria.
     */
    @Test
    public void shouldDeserializeTagWithMissingCriteriaField() throws Exception {
        String tagJson = """
                {"_id":"605bc497-fd7f-4338-b7c9-81cc3559c470",
                 "projectId":"12345678-1234-1234-1234-123456789abc",
                 "label":"The label",
                 "description":"The description",
                 "color":"#010203",
                 "backgroundColor":"#040506"}""
                """;
        var content = tester.parse(tagJson);
        var tag = content.getObject();
        assertThat(tag.getTagId()).isEqualTo(TagId.getId("605bc497-fd7f-4338-b7c9-81cc3559c470"));
        assertThat(tag.getProjectId()).isEqualTo(ProjectId.valueOf("12345678-1234-1234-1234-123456789abc"));
        assertThat(tag.getLabel()).isEqualTo("The label");
        assertThat(tag.getDescription()).isEqualTo("The description");
        assertThat(tag.getColor()).isEqualTo(Color.get(1, 2, 3));
        assertThat(tag.getBackgroundColor()).isEqualTo(Color.get(4, 5, 6));
    }
}
