package edu.stanford.protege.webprotege.user;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2 Feb 2018
 */
public class EmailAddress_Json_TestCase {

    private static final String ADDRESS = "jane.doe@stanford.edu";

    private EmailAddress emailAddress;

    @BeforeEach
    public void setUp() throws Exception {
        emailAddress = new EmailAddress(ADDRESS);
    }

    @Test
    public void shouldSerializeJson() throws Exception {
        String result = new ObjectMapper().writeValueAsString(emailAddress);
        assertThat(result, is("\"" + ADDRESS + "\""));
    }

    @Test
    public void shouldDeserializeJson() throws Exception {
        EmailAddress readEmailAddress = new ObjectMapper()
                .readerFor(EmailAddress.class)
                .readValue("\"" + ADDRESS + "\"");
        assertThat(readEmailAddress, is(emailAddress));
    }
}
