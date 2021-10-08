package edu.stanford.protege.webprotege.ontology;

import com.google.common.collect.ImmutableList;
import edu.stanford.protege.webprotege.common.BlobLocation;
import edu.stanford.protege.webprotege.common.Request;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2021-09-28
 *
 * @param sources The locations of the ontology sources.  The blob should either be an ontology document
 *                file or it can be a zip file of ontology document files.
 */
public record ProcessOntologySourcesRequest(BlobLocation sources) implements Request<ProcessOntologySourcesResponse> {

    public static final String CHANNEL = "ontologies.ProcessOntologySources";

    @Override
    public String getChannel() {
        return CHANNEL;
    }
}
