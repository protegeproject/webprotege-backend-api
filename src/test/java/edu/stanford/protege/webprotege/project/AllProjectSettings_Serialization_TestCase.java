package edu.stanford.protege.webprotege.project;

import com.google.common.collect.ImmutableList;
import edu.stanford.protege.webprotege.color.Color;
import edu.stanford.protege.webprotege.crud.EntityCrudKitPrefixSettings;
import edu.stanford.protege.webprotege.crud.EntityCrudKitSettings;
import edu.stanford.protege.webprotege.crud.gen.GeneratedAnnotationsSettings;
import edu.stanford.protege.webprotege.crud.uuid.UuidSuffixSettings;
import edu.stanford.protege.webprotege.lang.DisplayNameSettings;

import edu.stanford.protege.webprotege.criteria.EntityIsDeprecatedCriteria;
import edu.stanford.protege.webprotege.project.PrefixDeclaration;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.search.ProjectSearchSettings;
import edu.stanford.protege.webprotege.sharing.PersonId;
import edu.stanford.protege.webprotege.sharing.ProjectSharingSettings;
import edu.stanford.protege.webprotege.sharing.SharingPermission;
import edu.stanford.protege.webprotege.sharing.SharingSetting;
import edu.stanford.protege.webprotege.common.DictionaryLanguage;
import edu.stanford.protege.webprotege.tag.Tag;
import edu.stanford.protege.webprotege.tag.TagId;
import org.junit.Test;

import java.io.IOException;
import java.util.Optional;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2020-08-24
 */
public class AllProjectSettings_Serialization_TestCase {

    @Test
    public void shouldRoundTripSettings() throws IOException {

    }
}
