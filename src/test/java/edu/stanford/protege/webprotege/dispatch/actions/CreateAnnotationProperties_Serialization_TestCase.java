package edu.stanford.protege.webprotege.dispatch.actions;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import edu.stanford.protege.webprotege.dispatch.Action;
import edu.stanford.protege.webprotege.dispatch.Result;
import edu.stanford.protege.webprotege.entity.CreateAnnotationPropertiesAction;
import edu.stanford.protege.webprotege.entity.CreateAnnotationPropertiesResult;

import edu.stanford.protege.webprotege.common.ProjectId;
import org.junit.Test;

import java.io.IOException;

import static com.google.common.collect.ImmutableSet.*;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2021-04-06
 */
public class CreateAnnotationProperties_Serialization_TestCase {

    @Test
    public void shouldSerializeAction() throws IOException {
        var action = new CreateAnnotationPropertiesAction(ProjectId.generate(),
                                                          "A\nB",
                                                          "en", of());
        
    }

    @Test
    public void shouldSerializeResult() throws IOException {
        var result = new CreateAnnotationPropertiesResult(ProjectId.generate(),
                                                          ImmutableSet.of());
        
    }
}
