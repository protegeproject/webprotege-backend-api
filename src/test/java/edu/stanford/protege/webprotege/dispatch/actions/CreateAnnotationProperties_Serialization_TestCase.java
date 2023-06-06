package edu.stanford.protege.webprotege.dispatch.actions;

import com.google.common.collect.ImmutableSet;
import edu.stanford.protege.webprotege.common.ChangeRequestId;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.entity.CreateAnnotationPropertiesAction;
import edu.stanford.protege.webprotege.entity.CreateAnnotationPropertiesResult;
import org.junit.Test;

import java.io.IOException;

import static com.google.common.collect.ImmutableSet.of;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2021-04-06
 */
public class CreateAnnotationProperties_Serialization_TestCase {

    private final ChangeRequestId changeRequestId = ChangeRequestId.generate();

    private final ProjectId projectId = ProjectId.generate();

    @Test
    public void shouldSerializeAction() throws IOException {
        var action = new CreateAnnotationPropertiesAction(changeRequestId,
                                                          projectId,
                                                          "A\nB",
                                                          "en", of());
        
    }

    @Test
    public void shouldSerializeResult() throws IOException {
        var result = new CreateAnnotationPropertiesResult(ProjectId.generate(),
                                                          ImmutableSet.of());
        
    }
}
