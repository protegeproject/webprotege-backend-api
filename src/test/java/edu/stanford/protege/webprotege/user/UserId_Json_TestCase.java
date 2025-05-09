package edu.stanford.protege.webprotege.user;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.stanford.protege.webprotege.common.UserId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2 Feb 2018
 */
public class UserId_Json_TestCase {

    private static final String THE_USER_NAME = "The User Name";

    private UserId userId;

    @BeforeEach
    public void setUp() throws Exception {
        userId = UserId.valueOf(THE_USER_NAME);
    }

    @Test
    public void shouldSerializeJson() throws Exception {
        String result = new ObjectMapper().writeValueAsString(userId);
        assertThat(result, is("\"" + THE_USER_NAME + "\""));
    }

    @Test
    public void shouldDeserializeJson() throws Exception {
        UserId readUserId = new ObjectMapper()
                .readerFor(UserId.class)
                .readValue("\"" + THE_USER_NAME + "\"");
        assertThat(readUserId, is(userId));
    }
}
