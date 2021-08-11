package edu.stanford.protege.webprotege.match;

import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.dispatch.Result;
import edu.stanford.protege.webprotege.entity.EntityNode;
import edu.stanford.protege.webprotege.pagination.Page;

import javax.annotation.Nonnull;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 14 Jun 2018
 */


@JsonTypeName("GetMatchingEntitiesResult")
public record GetMatchingEntitiesResult(@Nonnull Page<EntityNode> entities) implements Result {

}
