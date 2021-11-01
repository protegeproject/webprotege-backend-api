package edu.stanford.protege.webprotege.search;

import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.dispatch.Result;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2020-08-17
 */


@JsonTypeName("webprotege.search.SetSearchSettings")
public record SetSearchSettingsResult() implements Result {

}
