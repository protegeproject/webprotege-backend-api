package edu.stanford.protege.webprotege.merge_add;

import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.dispatch.Result;




@JsonTypeName("NewOntologyMergeAdd")
public record NewOntologyMergeAddResult() implements Result {

}
