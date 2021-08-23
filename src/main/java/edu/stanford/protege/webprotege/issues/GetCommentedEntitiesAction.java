package edu.stanford.protege.webprotege.issues;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.dispatch.ProjectAction;
import edu.stanford.protege.webprotege.common.PageRequest;

import javax.annotation.Nonnull;
import java.util.Set;


/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 7 Mar 2017
 */


@JsonTypeName("GetCommentedEntities")
public record GetCommentedEntitiesAction(@JsonProperty("projectId") @Nonnull ProjectId projectId,
                                         @JsonProperty("userIdFilter") @Nonnull String userIdFilter,
                                         @JsonProperty("statusFilter") @Nonnull Set<Status> statusFilter,
                                         @JsonProperty("sortingKey") @Nonnull SortingKey sortingKey,
                                         @JsonProperty("pageRequest") @Nonnull PageRequest pageRequest) implements ProjectAction<GetCommentedEntitiesResult> {

    public static final String CHANNEL = "webprotege.discussions.GetCommentedEntities";

    @Override
    public String getChannel() {
        return CHANNEL;
    }
}
