package edu.stanford.protege.webprotege.user;

import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.common.UserId;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class UserIdProjectIdKey_TestCase {

    private final UserId userId = new UserId("UserA");

    private final ProjectId projectId = ProjectId.generate();

    private UserIdProjectIdKey userIdProjectIdKey;

    @BeforeEach
    public void setUp()
            throws Exception {
        userIdProjectIdKey = new UserIdProjectIdKey(userId, projectId);
    }

    public void shouldThrowNullPointerExceptionIf_userId_IsNull() {
        assertThrows(NullPointerException.class, () -> {
            new UserIdProjectIdKey(null, projectId);
        });
    }

    @Test
    public void shouldReturnSupplied_userId() {
        assertThat(userIdProjectIdKey.getUserId(), is(this.userId));
    }

    public void shouldThrowNullPointerExceptionIf_projectId_IsNull() {
        assertThrows(NullPointerException.class, () -> {
            new UserIdProjectIdKey(userId, null);
        });
    }

    @Test
    public void shouldReturnSupplied_projectId() {
        assertThat(userIdProjectIdKey.getProjectId(), is(this.projectId));
    }

    @Test
    public void shouldBeEqualToSelf() {
        assertThat(userIdProjectIdKey, is(userIdProjectIdKey));
    }

    @Test
    public void shouldNotBeEqualToNull() {
        assertThat(userIdProjectIdKey.equals(null), is(false));
    }

    @Test
    public void shouldBeEqualToOther() {
        assertThat(userIdProjectIdKey, is(new UserIdProjectIdKey(userId, projectId)));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_userId() {
        assertThat(userIdProjectIdKey, is(Matchers.not(new UserIdProjectIdKey(new UserId("OtherUser"), projectId))));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_projectId() {
        assertThat(userIdProjectIdKey, is(Matchers.not(new UserIdProjectIdKey(userId, ProjectId.generate()))));
    }

    @Test
    public void shouldBeEqualToOtherHashCode() {
        assertThat(userIdProjectIdKey.hashCode(), is(new UserIdProjectIdKey(userId, projectId).hashCode()));
    }

    @Test
    public void shouldImplementToString() {
        assertThat(userIdProjectIdKey.toString(), Matchers.startsWith("UserIdProjectIdKey"));
    }

}
