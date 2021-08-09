package edu.stanford.protege.webprotege.crud.gen;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2020-11-01
 */
@JsonSubTypes({
        @JsonSubTypes.Type(value = IncrementingPatternDescriptor.class, name = IncrementingPatternDescriptor.TYPE_NAME)
})
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME)
public interface GeneratedValueDescriptor {

    <R> R accept(GeneratedValueDescriptorVisitor<R> visitor);
}
