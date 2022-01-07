package edu.stanford.protege.webprotege.tag;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;
import edu.stanford.protege.webprotege.common.Event;
import edu.stanford.protege.webprotege.common.ProjectEvent;
import edu.stanford.protege.webprotege.common.ProjectId;

import javax.annotation.Nonnull;
import javax.inject.Inject;
import java.util.Collection;

import static com.google.common.base.MoreObjects.toStringHelper;
import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 26 Mar 2018
 */
@JsonTypeName("webprotege.tags.events.ProjectTagsChanged")
public record ProjectTagsChangedEvent(@Nonnull ProjectId projectId,
                                      @Nonnull Collection<Tag> projectTags) implements ProjectEvent {

    public static final String CHANNEL = "webprotege.tags.events.ProjectTagsChanged";

    @Override
    public String getChannel() {
        return CHANNEL;
    }
}
