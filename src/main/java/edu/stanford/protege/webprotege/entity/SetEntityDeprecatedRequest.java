package edu.stanford.protege.webprotege.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.common.ProjectRequest;
import org.semanticweb.owlapi.model.IRI;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2021-09-01
 */
@JsonTypeName("webprotege.entities.SetEntityDeprecated")
public record SetEntityDeprecatedRequest(@JsonProperty(value = "projectId", required = true) ProjectId projectId,
                                         @JsonProperty(value = "entityIri", required = true) IRI entityIri) implements ProjectRequest<SetEntityDeprecatedResponse> {

    public static final String CHANNEL = "webprotege.entities.SetEntityDeprecated";

    @Override
    public String getChannel() {
        return CHANNEL;
    }
}
