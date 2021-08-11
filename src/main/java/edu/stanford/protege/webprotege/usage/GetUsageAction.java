package edu.stanford.protege.webprotege.usage;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.dispatch.ProjectAction;
import org.semanticweb.owlapi.model.OWLEntity;

import javax.annotation.Nullable;

/**
 * Author: Matthew Horridge<br>
 * Stanford University<br>
 * Bio-Medical Informatics Research Group<br>
 * Date: 11/07/2013
 */


@JsonTypeName("GetUsage")
public record GetUsageAction(@JsonProperty("subject") OWLEntity subject,
                             @JsonProperty("projectId") ProjectId projectId,
                             @JsonProperty("usageFilter") @Nullable UsageFilter usageFilter) implements ProjectAction<GetUsageResult> {
}
