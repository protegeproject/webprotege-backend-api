package edu.stanford.protege.webprotege.tag;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.common.ChangeRequest;
import edu.stanford.protege.webprotege.common.ChangeRequestId;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.dispatch.ProjectAction;

import javax.annotation.Nonnull;
import java.util.List;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 24 Mar 2018
 */


@JsonTypeName("webprotege.tags.SetProjectTags")
public record SetProjectTagsAction(@JsonProperty("changeRequestId") ChangeRequestId changeRequestId,
                                   @JsonProperty("projectId") @Nonnull ProjectId projectId,
                                   @JsonProperty("tagData") @Nonnull List<TagData> tagData) implements ProjectAction<SetProjectTagsResult>, ChangeRequest {

    public static final String CHANNEL = "webprotege.tags.SetProjectTags";

    @Override
    public String getChannel() {
        return CHANNEL;
    }
}
