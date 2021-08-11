package edu.stanford.protege.webprotege.crud;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.auto.value.AutoValue;
import edu.stanford.protege.webprotege.match.criteria.CompositeHierarchyPositionCriteria;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2020-04-07
 */


public record ConditionalIriPrefix(String iriPrefix,
                                   CompositeHierarchyPositionCriteria criteria){
}
