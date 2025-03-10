package edu.stanford.protege.webprotege.search;

import edu.stanford.protege.webprotege.common.LanguageMap;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.criteria.EntityIsDeprecatedCriteria;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.UUID;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2020-08-15
 */
public class EntitySearchFilter_Serialization_TestCase {

    @Test
    public void shouldSerializeAsJson() throws IOException {
        EntitySearchFilter in = EntitySearchFilter.get(EntitySearchFilterId.createFilterId(),
                ProjectId.valueOf(UUID.randomUUID().toString()),
                LanguageMap.of("en", "Hello"),
                EntityIsDeprecatedCriteria.get());


    }

}
