package edu.stanford.protege.webprotege.perspective;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.dispatch.ProjectAction;

import javax.annotation.Nonnull;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2020-09-03
 */


@JsonTypeName("GetPerspectiveDetails")
public record GetPerspectiveDetailsAction(@JsonProperty("projectId") @Nonnull ProjectId projectId) implements ProjectAction<GetPerspectiveDetailsResult> {

    public static final String CHANNEL = "webprotege.perspectives.GetPerspectiveDetails";

    @Override
    public String getChannel() {
        return CHANNEL;
    }
}
