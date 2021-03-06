package edu.stanford.protege.webprotege.merge;

import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.dispatch.Result;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 26/01/15
 */


@JsonTypeName("webprotege.projects.MergeUploadedProject")
public record MergeUploadedProjectResult() implements Result {

}
