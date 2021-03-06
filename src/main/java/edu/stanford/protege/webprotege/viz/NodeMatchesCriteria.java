package edu.stanford.protege.webprotege.viz;

import edu.stanford.protege.webprotege.criteria.EntityMatchCriteria;

import javax.annotation.Nonnull;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2019-12-06
 *
 * A node that matches some term matching criteria
 */
public interface NodeMatchesCriteria extends EdgeNodeCriteria  {

    @Nonnull
    EntityMatchCriteria getNodeCriteria();
}
