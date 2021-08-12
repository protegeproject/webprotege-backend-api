package edu.stanford.protege.webprotege.criteria;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.google.auto.value.AutoValue;

import javax.annotation.Nonnull;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 11 Jun 2018
 */
@AutoValue

@JsonTypeName("StringContainsRepeatedSpaces")
public abstract class StringContainsRepeatedSpacesCriteria implements LexicalValueCriteria {

    @JsonCreator
    @Nonnull
    public static StringContainsRepeatedSpacesCriteria get() {
        return new AutoValue_StringContainsRepeatedSpacesCriteria();
    }

    @Override
    public <R> R accept(@Nonnull AnnotationValueCriteriaVisitor<R> visitor) {
        return visitor.visit(this);
    }

    @Override
    public <R> R accept(@Nonnull LiteralCriteriaVisitor<R> visitor) {
        return visitor.visit(this);
    }
}
