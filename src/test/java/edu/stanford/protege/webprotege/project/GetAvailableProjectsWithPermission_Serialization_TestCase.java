package edu.stanford.protege.webprotege.project;

import com.google.common.collect.ImmutableList;
import edu.stanford.protege.webprotege.authorization.ActionId;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.IOException;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2021-04-07
 */
@RunWith(MockitoJUnitRunner.class)
public class GetAvailableProjectsWithPermission_Serialization_TestCase {


    @Test
    public void shouldSerializeAction() throws IOException {
        var action = new GetAvailableProjectsWithPermissionAction(new ActionId("Something"));
    }

    @Test
    public void shouldSerializeResult() throws IOException {
        var result = new GetAvailableProjectsWithPermissionResult(ImmutableList.of());
    }
}
