package edu.stanford.protege.webprotege.watches;

import edu.stanford.protege.webprotege.common.UserId;
import org.junit.Test;
import org.semanticweb.owlapi.model.EntityType;
import org.semanticweb.owlapi.model.IRI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2021-05-19
 *
 * Test that the Watch documents stored by Morphia can be read by Jackson
 */
@JsonTest
public class Watch_JsonDocument_Regression_TestCase {

    private final static String document = "{\"_id\" : \"ObjectId(\\\"60a54871daeba784da91904d\\\")\",\"entity\" : {\"type\" : \"Class\",\"iri\" : \"http://the.ontology/ClsA\"},\"projectId\" : \"b6fc02d5-392f-415a-898d-2062010ecf04\",\"userId\" : \"The User\",\"type\" : \"ENTITY\"}\n";

    @Autowired
    private JacksonTester<Watch> tester;

    @Test
    public void shouldDeserializeDocument() throws IOException {
        var parsedWatch = tester.parse(document);
        var watch = parsedWatch.getObject();
        assertThat(watch.getUserId()).isEqualTo(UserId.valueOf("The User"));
        assertThat(watch.getEntity().getEntityType()).isEqualTo(EntityType.CLASS);
        assertThat(watch.getEntity().getIRI().toString()).isEqualTo("http://the.ontology/ClsA");
        assertThat(watch.getType()).isEqualTo(WatchType.ENTITY);
    }
}
