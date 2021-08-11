package edu.stanford.protege.webprotege.tag;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.dispatch.Result;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Optional;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 18 Mar 2018
 */
@JsonTypeName("AddProjectTag")
public record AddProjectTagResult(Tag addedTag) implements Result {

    @JsonCreator
    public static AddProjectTagResult create(@JsonProperty("addedTag") @Nullable Tag addedTag) {
        return new AddProjectTagResult(addedTag);
    }

    /**
     * Gets the tag if it was added.
     * @return The tag.  If the tag was not added (likely due to a duplicate label, for example)
     * then the return value will be empty.
     */
    @Nonnull
    public Optional<Tag> getAddedTag() {
        return Optional.ofNullable(addedTag);
    }}
