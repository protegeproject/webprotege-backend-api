package edu.stanford.protege.webprotege.project;

import edu.stanford.protege.webprotege.common.DictionaryLanguage;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.common.UserId;
import edu.stanford.protege.webprotege.lang.DisplayNameSettings;
import edu.stanford.protege.webprotege.projectsettings.EntityDeprecationSettings;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class ProjectDetailsTestCase {

    public static final boolean IN_TRASH = true;

    private final long createdAt = 22L;

    private final long modifiedAt = 33L;

    private final ProjectId projectId = ProjectId.generate();

    private final UserId owner = new UserId("UserX");

    private final UserId createdBy = new UserId("UserA");

    private final UserId modifiedBy = new UserId("UserY");


    private String displayName;

    private String description;

    private ProjectDetails projectDetails;

    @Mock
    private EntityDeprecationSettings entityDeprecationSettings;

    @BeforeEach
    public void setUp() throws Exception {
        displayName = "DisplayName";
        description = "Description";
        projectDetails = ProjectDetails.get(projectId, displayName, description,
                owner,
                IN_TRASH,
                DictionaryLanguage.rdfsLabel(""),
                DisplayNameSettings.empty(),
                createdAt,
                createdBy,
                modifiedAt,
                modifiedBy,
                entityDeprecationSettings);
    }

    @Test
    public void emptyDisplayNameInConstructorIsOK() {
        assertEquals(projectDetails.getDisplayName(), displayName);
    }

    @Test
    public void emptyDescriptionInConstructorIsOK() {
        assertEquals(projectDetails.getDescription(), description);
    }

    @Test
    public void suppliedProjectIdIsReturnedByAccessor() {
        assertEquals(projectDetails.projectId(), projectId);
    }

    @Test
    public void suppliedUserIdIsReturnedByAccessor() {
        assertEquals(projectDetails.getOwner(), owner);
    }

    @Test
    public void suppliedTrashValueIsReturnedByAccessor() {
        assertEquals(projectDetails.isInTrash(), IN_TRASH);
    }
}
