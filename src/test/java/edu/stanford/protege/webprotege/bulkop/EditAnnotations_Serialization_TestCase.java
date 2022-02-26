package edu.stanford.protege.webprotege.bulkop;

import com.google.common.collect.ImmutableSet;
import edu.stanford.protege.webprotege.MockingUtils;
import edu.stanford.protege.webprotege.common.ChangeRequestId;
import edu.stanford.protege.webprotege.dispatch.Action;
import edu.stanford.protege.webprotege.dispatch.Result;

import edu.stanford.protege.webprotege.common.ProjectId;
import org.junit.Test;

import java.io.IOException;
import java.util.Optional;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2021-04-06
 */
public class EditAnnotations_Serialization_TestCase {


    @Test
    public void shouldSerializeAction() throws IOException {
        var action = new EditAnnotationsAction(
                ChangeRequestId.generate(),
                ProjectId.generate(),
                ImmutableSet.of(),
                Operation.DELETE, Optional.empty(),
                Optional.empty(),
                false,
                Optional.empty(),
                NewAnnotationData.get(Optional.empty(),
                                      Optional.empty(),
                                      Optional.empty()),
                "Msg"
        );

    }

    @Test
    public void shouldSerializeResult() throws IOException {
        var result = new EditAnnotationsResult();

    }
}
