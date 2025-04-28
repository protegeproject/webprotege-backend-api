package edu.stanford.protege.webprotege.project;

import com.google.common.collect.ImmutableList;
import edu.stanford.protege.webprotege.authorization.BasicCapability;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;

@ExtendWith(MockitoExtension.class)
public class GetAvailableProjectsWithPermission_Serialization_TestCase {


    @Test
    public void shouldSerializeAction() throws IOException {
        var action = new GetAvailableProjectsWithPermissionAction(new BasicCapability("Something"));
    }

    @Test
    public void shouldSerializeResult() throws IOException {
        var result = new GetAvailableProjectsWithPermissionResult(ImmutableList.of());
    }
}
