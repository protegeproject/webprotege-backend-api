package edu.stanford.protege.webprotege.entity;

import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.dispatch.Result;
import edu.stanford.protege.webprotege.pagination.Page;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 16 Jun 2017
 */


@JsonTypeName("GetDeprecatedEntities")
public record GetDeprecatedEntitiesResult(Page<OWLEntityData> entities) implements Result {

}
