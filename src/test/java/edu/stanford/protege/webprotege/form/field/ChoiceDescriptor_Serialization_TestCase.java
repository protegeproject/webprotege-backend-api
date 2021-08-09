package edu.stanford.protege.webprotege.form.field;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.stanford.protege.webprotege.WebprotegeBackendMonolithApplication;
import edu.stanford.protege.webprotege.form.data.PrimitiveFormControlData;
import edu.stanford.protege.webprotege.lang.LanguageMap;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.semanticweb.owlapi.model.IRI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import uk.ac.manchester.cs.owl.owlapi.OWLClassImpl;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2019-11-09
 */
@SpringBootTest
public class ChoiceDescriptor_Serialization_TestCase {

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void shouldSerializeAndDeserializeChoiceDescriptor() throws IOException {
        var label = LanguageMap.of("en", "Hello World");
        var value = PrimitiveFormControlData.get(new OWLClassImpl(IRI.create("http://example.org/A")));
        var choiceDescriptor = ChoiceDescriptor.choice(label, value);
        var serialized = objectMapper.writeValueAsString(choiceDescriptor);
        System.out.println(serialized);
        var deserialized = objectMapper.readerFor(ChoiceDescriptor.class).readValue(serialized);
        assertThat(deserialized, Matchers.is(choiceDescriptor));
    }
}
