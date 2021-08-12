package edu.stanford.protege.webprotege.criteria;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2020-04-08
 */
public interface HierarchyPositionCriteriaVisitor<R> {


    R visit(CompositeHierarchyPositionCriteria criteria);

    R visit(SubClassOfCriteria subClassOfCriteria);

    R visit(InstanceOfCriteria instanceOfCriteria);

    R visit(NotSubClassOfCriteria notSubClassOfCriteria);

    R visit(IsLeafClassCriteria isALeafClassCriteria);
}
