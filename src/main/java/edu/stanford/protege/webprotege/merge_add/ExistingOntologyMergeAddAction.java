package edu.stanford.protege.webprotege.merge_add;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.csv.DocumentId;
import edu.stanford.protege.webprotege.dispatch.ProjectAction;
import org.semanticweb.owlapi.model.OWLOntologyID;

import java.util.List;



@JsonTypeName("ExistingOntologyMergeAdd")
public record ExistingOntologyMergeAddAction(@JsonProperty("projectId") ProjectId projectId,
                                             @JsonProperty("documentId") DocumentId documentId,
                                             @JsonProperty("selectedOntologies") List<OWLOntologyID> selectedOntologies,
                                             @JsonProperty("targetOntology") OWLOntologyID targetOntology) implements ProjectAction<ExistingOntologyMergeAddResult> {
}
