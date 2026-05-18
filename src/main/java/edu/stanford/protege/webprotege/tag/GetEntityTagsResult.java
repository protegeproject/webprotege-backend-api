package edu.stanford.protege.webprotege.tag;

import com.fasterxml.jackson.annotation.JsonProperty;
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
public record GetEntityTagsResult(@JsonProperty("entityTags") Collection<Tag> entityTags,
                                 @JsonProperty("projectTags") Collection<Tag> projectTags) implements Result {

    public GetEntityTagsResult(@JsonProperty("entityTags") Collection<Tag> entityTags,
                               @JsonProperty("projectTags") Collection<Tag> projectTags) {
        this.entityTags = checkNotNull(entityTags);
        this.projectTags = checkNotNull(projectTags);
    }
}
