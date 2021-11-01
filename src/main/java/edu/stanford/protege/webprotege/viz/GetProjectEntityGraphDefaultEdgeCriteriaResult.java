package edu.stanford.protege.webprotege.viz;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.google.common.collect.ImmutableList;
import edu.stanford.protege.webprotege.dispatch.Result;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2019-12-07
 */
@JsonTypeName("webprotege.graphs.GetProjectEntityGraphDefaultEdgeCriteria")
public record GetProjectEntityGraphDefaultEdgeCriteriaResult(ImmutableList<EdgeCriteria> edgeCriteria) implements Result {

}
