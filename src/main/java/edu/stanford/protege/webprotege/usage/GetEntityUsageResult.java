package edu.stanford.protege.webprotege.usage;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.dispatch.Result;
import edu.stanford.protege.webprotege.entity.EntityNode;

import java.util.List;

/**
 * Author: Matthew Horridge<br>
 * Stanford University<br>
 * Bio-Medical Informatics Research Group<br>
 * Date: 11/07/2013
 */


@JsonTypeName("GetUsage")
public record GetEntityUsageResult(@JsonProperty("projectId") ProjectId projectId,
                                   @JsonProperty("entityNode") EntityNode entityNode,
                                   @JsonProperty("usageReferences") List<UsageReference> usageReferences,
                                   @JsonProperty("totalUsageCount") int totalUsageCount) implements Result {
}
