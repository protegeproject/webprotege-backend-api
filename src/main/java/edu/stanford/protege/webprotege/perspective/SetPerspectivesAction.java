package edu.stanford.protege.webprotege.perspective;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.google.common.collect.ImmutableList;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.dispatch.ProjectAction;
import edu.stanford.protege.webprotege.common.UserId;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Optional;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 18/02/16
 */


@JsonTypeName("SetPerspectives")
public record SetPerspectivesAction(@Nonnull ProjectId projectId,
                                    @Nullable UserId userId,
                                    @Nonnull ImmutableList<PerspectiveDescriptor> perspectiveIds) implements ProjectAction<SetPerspectivesResult> {

    @JsonIgnore
    public Optional<UserId> getUserId() {
        return Optional.ofNullable(userId);
    }


}

