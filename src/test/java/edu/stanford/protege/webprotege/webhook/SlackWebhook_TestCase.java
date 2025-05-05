package edu.stanford.protege.webprotege.webhook;

import edu.stanford.protege.webprotege.common.ProjectId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class SlackWebhook_TestCase {

    private final String payloadUrl = "The payloadUrl";

    private final ProjectId projectId = ProjectId.generate();

    private SlackWebhook slackWebhook;

    @BeforeEach
    public void setUp() {
        slackWebhook = new SlackWebhook(projectId, payloadUrl);
    }

    @SuppressWarnings("ConstantConditions")
    public void shouldThrowNullPointerExceptionIf_projectId_IsNull() {
        assertThrows(NullPointerException.class, () -> {
            new SlackWebhook(null, payloadUrl);
        });
    }

    @Test
    public void shouldReturnSupplied_projectId() {
        assertThat(slackWebhook.getProjectId(), is(this.projectId));
    }

    @SuppressWarnings("ConstantConditions")
    public void shouldThrowNullPointerExceptionIf_payloadUrl_IsNull() {
        assertThrows(NullPointerException.class, () -> {
            new SlackWebhook(projectId, null);
        });
    }

    @Test
    public void shouldReturnSupplied_payloadUrl() {
        assertThat(slackWebhook.getPayloadUrl(), is(this.payloadUrl));
    }

    @Test
    public void shouldBeEqualToSelf() {
        assertThat(slackWebhook, is(slackWebhook));
    }

    @Test
    @SuppressWarnings("ObjectEqualsNull")
    public void shouldNotBeEqualToNull() {
        assertThat(slackWebhook.equals(null), is(false));
    }

    @Test
    public void shouldBeEqualToOther() {
        assertThat(slackWebhook, is(new SlackWebhook(projectId, payloadUrl)));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_projectId() {
        assertThat(slackWebhook, is(not(new SlackWebhook(ProjectId.generate(), payloadUrl))));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_payloadUrl() {
        assertThat(slackWebhook, is(not(new SlackWebhook(projectId, "String-eefb20e3-a251-4c46-8a95-826ace1c2a15"))));
    }

    @Test
    public void shouldBeEqualToOtherHashCode() {
        assertThat(slackWebhook.hashCode(), is(new SlackWebhook(projectId, payloadUrl).hashCode()));
    }

    @Test
    public void shouldImplementToString() {
        assertThat(slackWebhook.toString(), startsWith("SlackWebhook"));
    }

}
