package edu.stanford.protege.webprotege.match;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.dispatch.ProjectAction;
import edu.stanford.protege.webprotege.criteria.Criteria;
import edu.stanford.protege.webprotege.common.PageRequest;

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
