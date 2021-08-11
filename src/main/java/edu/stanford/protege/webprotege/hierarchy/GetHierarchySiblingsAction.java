package edu.stanford.protege.webprotege.hierarchy;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.google.auto.value.AutoValue;
import edu.stanford.protege.webprotege.dispatch.ProjectAction;
import edu.stanford.protege.webprotege.pagination.PageRequest;
import edu.stanford.protege.webprotege.common.ProjectId;
import org.semanticweb.owlapi.model.OWLEntity;

import javax.annotation.Nonnull;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 13 Sep 2018
 */


@JsonTypeName("GetHierarchySiblings")
public record GetHierarchySiblingsAction(@JsonProperty("projectId") ProjectId projectId,
                                         @JsonProperty("term") OWLEntity entity,
                                         @JsonProperty("hierarchyId") HierarchyId hierarchyId,
                                         @JsonProperty("pageRequest") PageRequest pageRequest) implements ProjectAction<GetHierarchySiblingsResult> {

}
