package edu.stanford.protege.webprotege.merge;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.diff.DiffElement;
import edu.stanford.protege.webprotege.dispatch.Result;

import java.util.List;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 26/01/15
 */


@JsonTypeName("webprotege.projects.ComputeProjectMerge")
public record ComputeProjectMergeResult(@JsonProperty("diff") List<DiffElement<String, String>> diff) implements Result {

}
