package edu.stanford.protege.webprotege.ontology;

import edu.stanford.protege.webprotege.common.BlobLocation;
import edu.stanford.protege.webprotege.common.Response;

import javax.annotation.Nullable;

public record ProcessOntologySourcesResponse(@Nullable BlobLocation location,
                                             @Nullable OntologySourcesProcessingSummary summary,
                                             @Nullable OntologySourcesProcessingError error) implements Response {

}
