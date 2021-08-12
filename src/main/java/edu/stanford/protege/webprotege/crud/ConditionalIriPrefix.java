package edu.stanford.protege.webprotege.crud;

import edu.stanford.protege.webprotege.criteria.CompositeHierarchyPositionCriteria;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2020-04-07
 */


public record ConditionalIriPrefix(String iriPrefix,
                                   CompositeHierarchyPositionCriteria criteria){
}
