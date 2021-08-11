package edu.stanford.protege.webprotege.merge_add;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.google.auto.value.AutoValue;
import edu.stanford.protege.webprotege.csv.DocumentId;
import edu.stanford.protege.webprotege.dispatch.ProjectAction;
import edu.stanford.protege.webprotege.common.ProjectId;
import org.semanticweb.owlapi.model.OWLOntologyID;

import javax.annotation.Nonnull;
import java.util.List;



@JsonTypeName("NewOntologyMergeAdd")
public record NewOntologyMergeAddAction(@JsonProperty("projectId") ProjectId projectId,
                                        @JsonProperty("documentId") DocumentId documentId,
                                        @JsonProperty("iri") String iri,
                                        @JsonProperty("ontologyList") List<OWLOntologyID> ontologyList) implements ProjectAction<NewOntologyMergeAddResult> {

}
