package edu.stanford.protege.webprotege.entity;

import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.common.Response;

@JsonTypeName("webprotege.entities.SetEntityDeprecated")
public record SetEntityDeprecatedResponse() implements Response {

}
