package edu.stanford.protege.webprotege.webhook;

import edu.stanford.protege.webprotege.common.ProjectId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class ProjectWebhook_TestCase {

    private final String payloadUrl = "The payloadUrl";

    private final ProjectId projectId = ProjectId.generate();

    private ProjectWebhook projectWebhook;

    @Mock
    private List<ProjectWebhookEventType> subscribedToEvents = new ArrayList<>();

    @BeforeEach
    public void setUp() {
        subscribedToEvents = Collections.singletonList(ProjectWebhookEventType.PROJECT_CHANGED);
        projectWebhook = new ProjectWebhook(projectId, payloadUrl, subscribedToEvents);
    }

    @SuppressWarnings("ConstantConditions")
    public void shouldThrowNullPointerExceptionIf_projectId_IsNull() {
        assertThrows(NullPointerException.class, () -> {
            new ProjectWebhook(null, payloadUrl, subscribedToEvents);
        });
    }

    @Test
    public void shouldReturnSupplied_projectId() {
        assertThat(projectWebhook.projectId(), is(this.projectId));
    }

    @SuppressWarnings("ConstantConditions")
    public void shouldThrowNullPointerExceptionIf_payloadUrl_IsNull() {
        assertThrows(NullPointerException.class, () -> {
            new ProjectWebhook(projectId, null, subscribedToEvents);
        });
    }

    @Test
    public void shouldReturnSupplied_payloadUrl() {
        assertThat(projectWebhook.getPayloadUrl(), is(this.payloadUrl));
    }

    @SuppressWarnings("ConstantConditions")
    public void shouldThrowNullPointerExceptionIf_subscribedToEvents_IsNull() {
        assertThrows(NullPointerException.class, () -> {
            new ProjectWebhook(projectId, payloadUrl, null);
        });
    }

    @Test
    public void shouldReturnSupplied_subscribedToEvents() {
        assertThat(projectWebhook.getSubscribedToEvents(), is(this.subscribedToEvents));
    }

    @Test
    public void shouldBeEqualToSelf() {
        assertThat(projectWebhook, is(projectWebhook));
    }

    @Test
    @SuppressWarnings("ObjectEqualsNull")
    public void shouldNotBeEqualToNull() {
        assertThat(projectWebhook.equals(null), is(false));
    }

    @Test
    public void shouldBeEqualToOther() {
        assertThat(projectWebhook, is(new ProjectWebhook(projectId, payloadUrl, subscribedToEvents)));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_projectId() {
        assertThat(projectWebhook, is(not(new ProjectWebhook(ProjectId.generate(), payloadUrl, subscribedToEvents))));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_payloadUrl() {
        assertThat(projectWebhook, is(not(new ProjectWebhook(projectId, "String-90554065-a9cf-485e-86b5-725b38241203", subscribedToEvents))));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_subscribedToEvents() {
        assertThat(projectWebhook, is(not(new ProjectWebhook(projectId, payloadUrl, new ArrayList<>()))));
    }

    @Test
    public void shouldBeEqualToOtherHashCode() {
        assertThat(projectWebhook.hashCode(), is(new ProjectWebhook(projectId, payloadUrl, subscribedToEvents).hashCode()));
    }

    @Test
    public void shouldImplementToString() {
        assertThat(projectWebhook.toString(), startsWith("ProjectWebhook"));
    }

}
