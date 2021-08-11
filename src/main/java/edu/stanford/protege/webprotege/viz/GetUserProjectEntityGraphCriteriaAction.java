package edu.stanford.protege.webprotege.viz;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.google.auto.value.AutoValue;
import edu.stanford.protege.webprotege.dispatch.ProjectAction;
import edu.stanford.protege.webprotege.common.ProjectId;

import javax.annotation.Nonnull;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2019-12-10
 */


@JsonTypeName("GetUserProjectEntityGraphCriteria")
public record GetUserProjectEntityGraphCriteriaAction(@JsonProperty("projectId") @Nonnull ProjectId projectId) implements ProjectAction<GetUserProjectEntityGraphCriteriaResult> {

}
