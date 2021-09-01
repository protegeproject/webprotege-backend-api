package edu.stanford.protege.webprotege.axioms;

import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.common.Response;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2021-09-01
 */
public record AddAxiomsResponse(ProjectId projectId,
                                int addedAxiomsCount) implements Response {

}
