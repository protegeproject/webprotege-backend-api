package edu.stanford.protege.webprotege.search;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class EntitySearchFilterId_TestCase {

    public static final String ID = "12345678-1234-1234-1234-123456789abc";

    private EntitySearchFilterId filterId;

    @BeforeEach
    public void setUp() throws Exception {
        filterId = EntitySearchFilterId.get(ID);
    }

    @Test
    public void shouldReturnSuppliedUuid() {
        assertThat(filterId.getId(), is(ID));
    }

    /**
     * @noinspection ConstantConditions
     */
    public void shouldThrowNPEForNullId() {
        assertThrows(NullPointerException.class, () -> {
            EntitySearchFilterId.get(null);
        });
    }

    public void shouldThrowIllegalArgumentExceptionForNonUuid() {
        assertThrows(NullPointerException.class, () -> {
            EntitySearchFilterId.get("OtherId");
        });
    }
}