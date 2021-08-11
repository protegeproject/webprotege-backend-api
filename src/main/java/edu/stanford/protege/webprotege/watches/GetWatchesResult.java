package edu.stanford.protege.webprotege.watches;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.dispatch.Result;

import java.util.Set;

/**
 * Author: Matthew Horridge<br>
 * Stanford University<br>
 * Bio-Medical Informatics Research Group<br>
 * Date: 20/03/2013
 */


@JsonTypeName("GetWatches")
public record GetWatchesResult(@JsonProperty("watches") Set<Watch> watches) implements Result {

}
