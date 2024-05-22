package edu.stanford.protege.webprotege.hierarchy;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.dispatch.Result;
import edu.stanford.protege.webprotege.entity.OWLEntityData;
import org.semanticweb.owlapi.model.OWLEntity;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;


/**
 * Matthew Horridge Stanford Center for Biomedical Informatics Research 28 Nov 2017
 */

@JsonTypeName("webprotege.hierarchies.GetHierarchyParents")
public record GetHierarchyParentsResult(@JsonProperty("entity") @Nullable OWLEntity entity,
                                        @JsonProperty("parents") @Nonnull List<OWLEntityData> parents) implements Result {
}
