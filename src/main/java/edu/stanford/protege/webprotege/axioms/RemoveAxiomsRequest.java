package edu.stanford.protege.webprotege.axioms;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.common.ProjectRequest;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2021-09-01
 *
 * Requests that the specified axioms are removed from the specified project.  The axioms will be removed from the ontology
 * that is specified by the ontology document.  If the ontology document identifies an anonymous ontology then the
 * axioms will be removed from the root ontology.
 * @param projectId The identifier for the project
 * @param ontologyDocument An ontology document containing the axioms serialized into a UTF-8 String.
 *                         The axioms will be removed from the ontology
 *                         that is identified by the ontology document header.  If this header specifies an anonymous
 *                         ontology then the axioms will be removed from the project root ontology.
 * @param mimeType The MIME type of the ontology document.
 * @param commitMessage The message that will be added to the change log
 */
@JsonTypeName("webprotege.axioms.RemoveAxioms")
public record RemoveAxiomsRequest(ProjectId projectId,
                                  String ontologyDocument,
                                  String mimeType,
                                  String commitMessage) implements ProjectRequest<RemoveAxiomsResponse> {

    public static final String CHANNEL = "webprotege.axioms.RemoveAxioms";

    @Override
    public String getChannel() {
        return CHANNEL;
    }
}
