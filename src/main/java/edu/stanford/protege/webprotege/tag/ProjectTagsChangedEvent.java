package edu.stanford.protege.webprotege.tag;

import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.common.EventId;
import edu.stanford.protege.webprotege.common.ProjectEvent;
import edu.stanford.protege.webprotege.common.ProjectId;

import javax.annotation.Nonnull;
import java.util.Collection;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 26 Mar 2018
 */
@JsonTypeName("webprotege.events.tags.ProjectTagsChanged")
public record ProjectTagsChangedEvent(@Nonnull EventId eventId,
                                      @Nonnull ProjectId projectId,
                                      @Nonnull Collection<Tag> projectTags) implements ProjectEvent {

    public static final String CHANNEL = "webprotege.events.tags.ProjectTagsChanged";

    @Override
    public String getChannel() {
        return CHANNEL;
    }
}
