package edu.stanford.protege.webprotege.viz;

import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.dispatch.Result;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2019-12-14
 */


@JsonTypeName("webprotege.graphs.SetEntityGraphActiveFilters")
public record SetEntityGraphActiveFiltersResult() implements Result {

}
