package edu.stanford.protege.webprotege.tag;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.dispatch.Result;

import java.util.Map;
import java.util.Set;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 18 Mar 2018
 */
@JsonTypeName("webprotege.tags.GetProjectTags")
public record GetProjectTagsResult(@JsonProperty("tags") Set<Tag> tags,
                                   @JsonProperty("tagUsage") Map<TagId, Integer> tagUsage) implements Result {

    public GetProjectTagsResult(@JsonProperty("tags") Set<Tag> tags,
                                @JsonProperty("tagUsage") Map<TagId, Integer> tagUsage) {
        this.tags = checkNotNull(tags);
        this.tagUsage = checkNotNull(tagUsage);
    }
}
