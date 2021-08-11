package edu.stanford.protege.webprotege.permissions;

import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.dispatch.Action;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 11 Apr 2017
 */
@JsonTypeName("RebuildPermissions")
public record RebuildPermissionsAction() implements Action<RebuildPermissionsResult> {

}
