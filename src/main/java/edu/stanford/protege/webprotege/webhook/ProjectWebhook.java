package edu.stanford.protege.webprotege.webhook;

import com.google.common.base.Objects;
import edu.stanford.protege.webprotege.project.HasProjectId;
import edu.stanford.protege.webprotege.common.ProjectId;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;

import static com.google.common.base.MoreObjects.toStringHelper;
import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 19 May 2017
 */
public class ProjectWebhook implements Webhook, HasProjectId {

    public static final String PROJECT_ID = "projectId";

    public static final String SUBSCRIBED_TO_EVENTS = "subscribedToEvents";

    private final ProjectId projectId;

    private final String payloadUrl;

    private List<ProjectWebhookEventType> subscribedToEvents = new ArrayList<>();

    public ProjectWebhook(ProjectId projectId,
                          String payloadUrl,
                          List<ProjectWebhookEventType> subscribedToEvents) {
        this.projectId = checkNotNull(projectId);
        this.payloadUrl = checkNotNull(payloadUrl);
        this.subscribedToEvents = new ArrayList<>(subscribedToEvents);
    }

    /**
     * Gets the ProjectId
     *
     * @return The ProjectId that this webhook pertains to.
     */
    @Nonnull
    public ProjectId getProjectId() {
        return projectId;
    }

    /**
     * Gets the webhook URL.
     *
     * @return A string representing the URL that the payload should be posted to.
     */
    @Nonnull
    public String getPayloadUrl() {
        return payloadUrl;
    }

    /**
     * Gets the events that this webhook subscribes to.
     *
     * @return A list of events
     */
    @Nonnull
    public List<ProjectWebhookEventType> getSubscribedToEvents() {
        return new ArrayList<>(subscribedToEvents);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(projectId, payloadUrl, subscribedToEvents);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ProjectWebhook)) {
            return false;
        }
        ProjectWebhook other = (ProjectWebhook) obj;
        return this.projectId.equals(other.projectId)
                && this.payloadUrl.equals(other.payloadUrl)
                && this.subscribedToEvents.equals(other.subscribedToEvents);
    }


    @Override
    public String toString() {
        return toStringHelper("ProjectWebhook")
                .addValue(payloadUrl)
                .add("payloadUrl", payloadUrl)
                .add("subscribedToEvents", subscribedToEvents)
                .toString();
    }
}
