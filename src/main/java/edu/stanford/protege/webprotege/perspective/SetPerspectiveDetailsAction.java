package edu.stanford.protege.webprotege.perspective;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.google.common.collect.ImmutableList;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.dispatch.ProjectAction;

import javax.annotation.Nonnull;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2020-09-03
 */
@JsonTypeName("webprotege.perspectives.SetPerspectiveDetails")
public record SetPerspectiveDetailsAction(ProjectId projectId,
                                          ImmutableList<PerspectiveDetails> perspectiveDetails) implements ProjectAction<SetPerspectiveDetailsResult> {

    public static final String CHANNEL = "webprotege.perspectives.SetPerspectiveDetails";


    @Override
    public String getChannel() {
        return CHANNEL;
    }
}
