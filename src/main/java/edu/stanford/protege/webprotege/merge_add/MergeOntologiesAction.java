package edu.stanford.protege.webprotege.merge_add;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.csv.DocumentId;
import edu.stanford.protege.webprotege.dispatch.ProjectAction;
import org.semanticweb.owlapi.model.OWLOntologyID;

import java.util.List;



@JsonTypeName("MergeOntologies")
public record MergeOntologiesAction(@JsonProperty("projectId") ProjectId projectId,
                                    @JsonProperty("documentId") DocumentId documentId,
                                    @JsonProperty("iri") String iri,
                                    @JsonProperty("ontologyList") List<OWLOntologyID> ontologyList) implements ProjectAction<NewOntologyMergeAddResult> {

    public static final String CHANNEL = "webprotege.ontologies.MergeOntologies";

    @Override
    public String getChannel() {
        return CHANNEL;
    }
}
