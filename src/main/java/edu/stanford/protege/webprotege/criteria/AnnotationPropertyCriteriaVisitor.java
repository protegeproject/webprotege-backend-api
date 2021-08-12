package edu.stanford.protege.webprotege.criteria;

import javax.annotation.Nonnull;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 11 Jun 2018
 */
public interface AnnotationPropertyCriteriaVisitor<R> {

    R visit(@Nonnull AnyAnnotationPropertyCriteria criteria);

    R visit(@Nonnull IriEqualsCriteria criteria);
}
