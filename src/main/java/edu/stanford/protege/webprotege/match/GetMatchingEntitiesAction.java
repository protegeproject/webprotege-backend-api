package edu.stanford.protege.webprotege.match;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.google.auto.value.AutoValue;
import edu.stanford.protege.webprotege.dispatch.ProjectAction;
import edu.stanford.protege.webprotege.match.criteria.Criteria;
import edu.stanford.protege.webprotege.pagination.PageRequest;
import edu.stanford.protege.webprotege.common.ProjectId;

import javax.annotation.Nonnull;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 14 Jun 2018
 */


@JsonTypeName("GetMatchingEntities")
public record GetMatchingEntitiesAction(@JsonProperty("projectId") ProjectId projectId,
                                        @JsonProperty("criteria") Criteria criteria,
                                        @JsonProperty("pageRequest") PageRequest pageRequest) implements ProjectAction<GetMatchingEntitiesResult> {

}
