package edu.stanford.protege.webprotege.watches;

import edu.stanford.protege.webprotege.common.UserId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.semanticweb.owlapi.model.OWLEntity;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
public class Watch_TestCase {

    private final WatchType type = WatchType.ENTITY;

    private final UserId userId = new UserId("UserA");

    private Watch watch;

    @Mock
    private OWLEntity entity;

    @BeforeEach
    public void setUp()
            throws Exception {
        watch = Watch.create(userId, entity, type);
    }

    @SuppressWarnings("ConstantConditions")
    public void shouldThrowNullPointerExceptionIf_userId_IsNull() {
        assertThrows(NullPointerException.class, () -> {
            Watch.create(null, entity, type);
        });
    }

    @Test
    public void shouldReturnSupplied_userId() {
        assertThat(watch.getUserId(), is(this.userId));
    }

    @SuppressWarnings("ConstantConditions")
    public void shouldThrowNullPointerExceptionIf_entity_IsNull() {
        assertThrows(NullPointerException.class, () -> {
            Watch.create(userId, null, type);
        });
    }

    @Test
    public void shouldReturnSupplied_entity() {
        assertThat(watch.getEntity(), is(this.entity));
    }

    @SuppressWarnings("ConstantConditions")
    public void shouldThrowNullPointerExceptionIf_type_IsNull() {
        assertThrows(NullPointerException.class, () -> {
            Watch.create(userId, entity, null);
        });
    }

    @Test
    public void shouldReturnSupplied_type() {
        assertThat(watch.getType(), is(this.type));
    }

    @Test
    public void shouldBeEqualToSelf() {
        assertThat(watch, is(watch));
    }

    @Test
    @SuppressWarnings("ObjectEqualsNull")
    public void shouldNotBeEqualToNull() {
        assertThat(watch.equals(null), is(false));
    }

    @Test
    public void shouldBeEqualToOther() {
        assertThat(watch, is(Watch.create(userId, entity, type)));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_userId() {
        assertThat(watch,
                is(not(Watch.create(new UserId("OtherUser"), entity, type))));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_entity() {
        assertThat(watch,
                is(not(Watch.create(userId,
                        mock(OWLEntity.class),
                        type))));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_type() {
        assertThat(watch,
                is(not(Watch.create(userId,
                        entity,
                        WatchType.BRANCH))));
    }

    @Test
    public void shouldBeEqualToOtherHashCode() {
        assertThat(watch.hashCode(), is(Watch.create(userId, entity, type).hashCode()));
    }

    @Test
    public void shouldImplementToString() {
        assertThat(watch.toString(), startsWith("Watch"));
    }

}
