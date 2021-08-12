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

@JsonTypeName("LiteralLexicalValueNotInDatatypeLexicalSpace")
public abstract class LiteralLexicalValueNotInDatatypeLexicalSpaceCriteria implements AnnotationValueCriteria {

    @JsonCreator
    @Nonnull
    public static LiteralLexicalValueNotInDatatypeLexicalSpaceCriteria get() {
        return new AutoValue_LiteralLexicalValueNotInDatatypeLexicalSpaceCriteria();
    }

    @Override
    public <R> R accept(@Nonnull AnnotationValueCriteriaVisitor<R> visitor) {
        return visitor.visit(this);
    }
}
