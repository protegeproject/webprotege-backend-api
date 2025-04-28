package edu.stanford.protege.webprotege.search;

import edu.stanford.protege.webprotege.common.LanguageMap;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.criteria.EntityMatchCriteria;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@ExtendWith(MockitoExtension.class)
public class EntitySearchFilter_TestCase {

    private final ProjectId projectId = ProjectId.generate();

    @Mock
    private EntitySearchFilterId id;

    @Mock
    private LanguageMap label;

    @Mock
    private EntityMatchCriteria matchCriteria;

    private EntitySearchFilter filter;

    @BeforeEach
    public void setUp() throws Exception {
        filter = EntitySearchFilter.get(id,
                projectId,
                label,
                matchCriteria);
    }

    @Test
    public void shouldReturnProvidedId() {
        assertThat(filter.getId(), is(id));
    }

    @Test
    public void shouldReturnProvidedProjectId() {
        assertThat(filter.getProjectId(), is(projectId));
    }

    @Test
    public void shouldReturnProvidedLabel() {
        assertThat(filter.getLabel(), is(label));
    }

    @Test
    public void shouldReturnProvidedCriteria() {
        assertThat(filter.getEntityMatchCriteria(), is(matchCriteria));
    }
}