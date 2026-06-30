package edu.stanford.protege.webprotege.issues;

import com.google.common.collect.ImmutableList;
import edu.stanford.protege.webprotege.common.EventId;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.common.UserId;
import org.junit.jupiter.api.Test;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.vocab.OWLRDFVocabulary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.json.JsonContent;
import uk.ac.manchester.cs.owl.owlapi.OWLClassImpl;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Contract-guard tests that pin the on-the-wire {@code @JsonTypeName} discriminator for
 * every event in the discussion namespace.
 *
 * <p>These events are routed across the JSON-RPC envelope by their {@code @JsonTypeName}
 * value. If a discriminator drifts (for example the canonical plural {@code discussions}
 * silently reverts to the singular {@code discussion}), the consumer treats the message as
 * an unknown type and drops it — no exception is thrown on either side. See
 * protegeproject/webprotege-backend-api#54.
 *
 * <p>The expected values below are hard-coded on purpose: asserting against each class's
 * own {@code CHANNEL} constant would let a constant rename slip through undetected. The
 * whole point of this test is to fail the build if any of these strings ever change.
 */
@JsonTest
class DiscussionEventChannelJsonTest {

    private static final String PROJECT_ID = "00000000-1111-2222-3333-444444444444";

    private static final String COMMENT_POSTED = "webprotege.events.discussions.CommentPosted";

    private static final String COMMENT_UPDATED = "webprotege.events.discussions.CommentUpdated";

    private static final String STATUS_CHANGED = "webprotege.events.discussions.DiscussionThreadStatusChanged";

    private static final String THREAD_CREATED = "webprotege.events.discussions.DiscussionThreadCreated";

    @Autowired
    private JacksonTester<CommentPostedEvent> commentPostedTester;

    @Autowired
    private JacksonTester<CommentUpdatedEvent> commentUpdatedTester;

    @Autowired
    private JacksonTester<DiscussionThreadStatusChangedEvent> statusChangedTester;

    @Autowired
    private JacksonTester<DiscussionThreadCreatedEvent> threadCreatedTester;

    private static EventId eventId() {
        return new EventId("event-id");
    }

    private static ProjectId projectId() {
        return new ProjectId(PROJECT_ID);
    }

    private static ThreadId threadId() {
        return ThreadId.valueOf("thread-id");
    }

    private static Comment comment() {
        return new Comment(CommentId.valueOf("comment-id"),
                           UserId.valueOf("the-user"),
                           0L,
                           Optional.empty(),
                           "body",
                           "renderedBody");
    }

    @Test
    void commentPostedEventSerializesWithPluralDiscriminator() throws Exception {
        var event = new CommentPostedEvent(eventId(), projectId(), threadId(), comment(),
                                           Optional.empty(), 0, 0);
        JsonContent<CommentPostedEvent> json = commentPostedTester.write(event);
        assertThat(json).extractingJsonPathStringValue("$.['@type']").isEqualTo(COMMENT_POSTED);
        assertThat(CommentPostedEvent.CHANNEL).isEqualTo(COMMENT_POSTED);
    }

    @Test
    void commentUpdatedEventSerializesWithPluralDiscriminator() throws Exception {
        var event = new CommentUpdatedEvent(eventId(), projectId(), threadId(), comment());
        JsonContent<CommentUpdatedEvent> json = commentUpdatedTester.write(event);
        assertThat(json).extractingJsonPathStringValue("$.['@type']").isEqualTo(COMMENT_UPDATED);
        assertThat(CommentUpdatedEvent.CHANNEL).isEqualTo(COMMENT_UPDATED);
    }

    @Test
    void discussionThreadStatusChangedEventSerializesWithPluralDiscriminator() throws Exception {
        var event = new DiscussionThreadStatusChangedEvent(eventId(), projectId(), threadId(),
                                                           Optional.empty(), 0, Status.OPEN);
        JsonContent<DiscussionThreadStatusChangedEvent> json = statusChangedTester.write(event);
        assertThat(json).extractingJsonPathStringValue("$.['@type']").isEqualTo(STATUS_CHANGED);
        assertThat(DiscussionThreadStatusChangedEvent.CHANNEL).isEqualTo(STATUS_CHANGED);
    }

    @Test
    void discussionThreadCreatedEventSerializesWithPluralDiscriminator() throws Exception {
        OWLClass entity = new OWLClassImpl(OWLRDFVocabulary.OWL_THING.getIRI());
        var thread = new EntityDiscussionThread(threadId(), projectId(), entity, Status.OPEN,
                                                ImmutableList.of());
        var event = new DiscussionThreadCreatedEvent(eventId(), projectId(), thread);
        JsonContent<DiscussionThreadCreatedEvent> json = threadCreatedTester.write(event);
        assertThat(json).extractingJsonPathStringValue("$.['@type']").isEqualTo(THREAD_CREATED);
        assertThat(DiscussionThreadCreatedEvent.CHANNEL).isEqualTo(THREAD_CREATED);
    }
}
