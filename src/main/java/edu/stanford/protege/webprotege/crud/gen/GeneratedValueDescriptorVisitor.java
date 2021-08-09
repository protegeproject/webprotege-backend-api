package edu.stanford.protege.webprotege.crud.gen;

import javax.annotation.Nonnull;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2020-11-01
 */
public interface GeneratedValueDescriptorVisitor<R> {

    R visit(@Nonnull IncrementingPatternDescriptor incrementingPatternDescriptor);
}
