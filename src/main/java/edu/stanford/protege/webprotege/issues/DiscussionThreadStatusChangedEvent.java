package edu.stanford.protege.webprotege.issues;


import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.common.Event;
import edu.stanford.protege.webprotege.common.ProjectId;
import org.semanticweb.owlapi.model.OWLEntity;

import javax.annotation.Nonnull;
import java.util.Optional;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 12 Oct 2016
 */
@JsonTypeName("DiscussionThreadStatusChangedEvent")
public record DiscussionThreadStatusChangedEvent(@Nonnull ProjectId projectId,
                                                @Nonnull ThreadId threadId,
                                                @Nonnull Optional<OWLEntity> entity,
                                                int openCommentsCountForEntity,
                                                @Nonnull Status status) implements Event {

    public static final String CHANNEL = "webprotege.discussion.events.DiscussionThreadStatusChanged";

    @Override
    public String getChannel() {
        return CHANNEL;
    }}
