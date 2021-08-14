package edu.stanford.protege.webprotege.viz;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.dispatch.Result;
import edu.stanford.protege.webprotege.common.UserId;

import javax.annotation.Nonnull;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2019-12-10
 */


@JsonTypeName("GetUserProjectEntityGraphCriteria")
public record GetUserProjectEntityGraphCriteriaResult(@JsonProperty("projectId") @Nonnull ProjectId projectId,
                                                      @JsonProperty("userId") @Nonnull UserId userId,
                                                      @JsonProperty("settings") @Nonnull EntityGraphSettings settings) implements Result {


}
