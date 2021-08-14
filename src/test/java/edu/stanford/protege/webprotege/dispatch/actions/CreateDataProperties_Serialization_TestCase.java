package edu.stanford.protege.webprotege.dispatch.actions;

import com.google.common.collect.ImmutableSet;
import edu.stanford.protege.webprotege.dispatch.Action;
import edu.stanford.protege.webprotege.dispatch.Result;
import edu.stanford.protege.webprotege.entity.CreateDataPropertiesAction;
import edu.stanford.protege.webprotege.entity.CreateDataPropertiesResult;

import edu.stanford.protege.webprotege.common.ProjectId;
import org.junit.Test;

import java.io.IOException;

import static com.google.common.collect.ImmutableSet.of;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2021-04-06
 */
public class CreateDataProperties_Serialization_TestCase {
    
    @Test
    public void shouldSerializeAction() throws IOException {
        var action = new CreateDataPropertiesAction(ProjectId.generate(),
                                                       "P\nQ",
                                                       "en", of());

    }

    @Test
    public void shouldSerializeResult() throws IOException {
        var result = new CreateDataPropertiesResult(ProjectId.generate(),
                                                       ImmutableSet.of());

    }
}
