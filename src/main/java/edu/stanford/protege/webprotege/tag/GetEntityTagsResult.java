package edu.stanford.protege.webprotege.tag;

import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.dispatch.Result;

import java.util.Collection;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 18 Mar 2018
 */
@JsonTypeName("webprotege.tags.GetEntityTags")
public record GetEntityTagsResult(Collection<Tag> entityTags,
                                 Collection<Tag> projectTags) implements Result {

    public GetEntityTagsResult(Collection<Tag> entityTags, Collection<Tag> projectTags) {
        this.entityTags = checkNotNull(entityTags);
        this.projectTags = checkNotNull(projectTags);
    }
}
