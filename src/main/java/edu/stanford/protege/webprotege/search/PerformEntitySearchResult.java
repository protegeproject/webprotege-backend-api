package edu.stanford.protege.webprotege.search;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.dispatch.Result;
import edu.stanford.protege.webprotege.common.Page;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 21 Apr 2017
 */


@JsonTypeName("PerformEntitySearch")
public record PerformEntitySearchResult(@JsonProperty("searchString") String searchString,
                                        @JsonProperty("results") Page<EntitySearchResult> results) implements Result {

}
