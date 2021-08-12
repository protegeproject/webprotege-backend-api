package edu.stanford.protege.webprotege.criteria;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import javax.annotation.Nonnull;

import static com.fasterxml.jackson.annotation.JsonSubTypes.Type;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2019-12-02
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "match")
@JsonSubTypes(value = {
        @Type(RelationshipPropertyEqualsCriteria.class),
        @Type(AnyRelationshipPropertyCriteria.class)
})
public interface RelationshipPropertyCriteria extends Criteria {

    <R> R accept(@Nonnull RelationshipPropertyCriteriaVisitor<R> visitor);
}
