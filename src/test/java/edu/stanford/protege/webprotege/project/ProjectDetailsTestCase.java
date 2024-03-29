package edu.stanford.protege.webprotege.project;

import edu.stanford.protege.webprotege.common.DictionaryLanguage;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.common.UserId;
import edu.stanford.protege.webprotege.lang.DisplayNameSettings;
import edu.stanford.protege.webprotege.projectsettings.EntityDeprecationSettings;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static junit.framework.Assert.assertEquals;

/**
 * Author: Matthew Horridge<br>
 * Stanford University<br>
 * Bio-Medical Informatics Research Group<br>
 * Date: 17/10/2013
 */
@RunWith(MockitoJUnitRunner.class)
public class ProjectDetailsTestCase {

    public static final boolean IN_TRASH = true;

    private ProjectId projectId = ProjectId.generate();

    private UserId owner = new UserId("UserX");

    private final long createdAt = 22L;

    private UserId createdBy = new UserId("UserA");

    private final long modifiedAt = 33L;

    private UserId modifiedBy = new UserId("UserY");


    private String displayName;

    private String description;

    private ProjectDetails projectDetails;

    @Mock
    private EntityDeprecationSettings entityDeprecationSettings;

    @Before
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
