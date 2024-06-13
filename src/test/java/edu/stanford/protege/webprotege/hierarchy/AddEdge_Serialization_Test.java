package edu.stanford.protege.webprotege.hierarchy;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.stanford.protege.webprotege.MockingUtils;
import edu.stanford.protege.webprotege.entity.EntityNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;

import java.io.IOException;
import java.io.StringReader;

import static org.assertj.core.api.Assertions.assertThat;

@JsonTest
@AutoConfigureJsonTesters
class AddEdge_Serialization_Test {

    @Autowired
    JacksonTester<GraphModelChange<EntityNode>> tester;

    @Autowired
    ObjectMapper objectMapper;

    @BeforeEach
    void setUp() throws JsonProcessingException {
    }

    @Test
    void shouldSerializeAsJson() throws IOException {
        var written = tester.write(new AddEdge<>(
                new GraphEdge<>(
                        GraphNode.getForEntityNode(MockingUtils.mockOWLClassNode(),
                                                   false),
                        GraphNode.getForEntityNode(MockingUtils.mockOWLClassNode(),
                                                   false)
                )
        ));
        assertThat(written).hasJsonPathStringValue("type", "AddEdge");
        assertThat(written).hasJsonPath("edge");
    }

    @Test
    void shouldDeserializeFromJson() throws IOException {
        var json = """
                {"type":"AddEdge","edge":{"predecessor":{"userObject":{"entity":{"@type":"Class","iri":"http://stuff.com/I0"},"browserText":"<http://stuff.com/I0>","tags":[],"deprecated":false,"watches":[],"openCommentCount":0,"shortForms":[], "statuses":[]},"sink":false},"successor":{"userObject":{"entity":{"@type":"Class","iri":"http://stuff.com/I1"},"browserText":"<http://stuff.com/I1>","tags":[],"deprecated":false,"watches":[],"openCommentCount":0,"shortForms":[], "statuses":[]},"sink":false}}}
                """;
        var read = tester.readObject(new StringReader(json));
        assertThat(read).isInstanceOf(AddEdge.class);
    }
}