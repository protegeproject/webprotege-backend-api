package edu.stanford.protege.webprotege.viz;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@ExtendWith(MockitoExtension.class)
public class EntityGraphFilter_TestCase {


    private static final String THE_DESCRIPTION = "TheDescription";


    private EntityGraphFilter filter;

    @Mock
    private FilterName filterName;

    @Mock
    private CompositeEdgeCriteria inclusionCriteria;

    @Mock
    private CompositeEdgeCriteria exclusionCriteria;

    @BeforeEach
    public void setUp() {
        filter = EntityGraphFilter.get(filterName,
                THE_DESCRIPTION,
                inclusionCriteria,
                exclusionCriteria,
                true);
    }

    @Test
    public void shouldGetSuppliedName() {
        assertThat(filter.getName(), is(filterName));
    }

    @Test
    public void shouldGetSuppliedInclusionCriteria() {
        assertThat(filter.getInclusionCriteria(), is(inclusionCriteria));
    }

    @Test
    public void shouldGetSuppliedExclusionCriteria() {
        assertThat(filter.getExclusionCriteria(), is(exclusionCriteria));
    }
}
