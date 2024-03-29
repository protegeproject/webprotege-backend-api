package edu.stanford.protege.webprotege.search;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.common.Page;
import edu.stanford.protege.webprotege.dispatch.Result;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 21 Apr 2017
 */


@JsonTypeName("webprotege.search.PerformEntitySearch")
public record PerformEntitySearchResult(@JsonProperty("searchString") String searchString,
                                        @JsonProperty("results") Page<EntitySearchResult> results) implements Result {

}
