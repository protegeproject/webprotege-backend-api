package edu.stanford.protege.webprotege.sharing;

import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.dispatch.Result;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 07/02/15
 */
@JsonTypeName("webprotege.sharing.SetProjectSharingSettings")
public record SetProjectSharingSettingsResult() implements Result {

}
