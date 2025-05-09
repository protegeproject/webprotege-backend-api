package edu.stanford.protege.webprotege.perspective;

import edu.stanford.protege.webprotege.common.LanguageMap;
import org.junit.jupiter.api.Test;

import java.io.IOException;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2020-09-01
 */
public class PerspectiveDescriptor_Serialization_TestCase {

    @Test
    public void shouldSerialize() throws IOException {
        var descriptor = PerspectiveDescriptor.get(
                PerspectiveId.generate(), LanguageMap.of("en", "Hello"), true
        );

    }
}
