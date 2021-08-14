package edu.stanford.protege.webprotege.event;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import edu.stanford.protege.webprotege.MockingUtils;
import edu.stanford.protege.webprotege.entity.EntityNode;
import edu.stanford.protege.webprotege.hierarchy.EntityHierarchyChangedEvent;
import edu.stanford.protege.webprotege.hierarchy.GraphModelChange;
import edu.stanford.protege.webprotege.hierarchy.GraphModelChangedEvent;
import edu.stanford.protege.webprotege.hierarchy.HierarchyId;
import edu.stanford.protege.webprotege.issues.*;
import edu.stanford.protege.webprotege.lang.DisplayNameSettings;
import edu.stanford.protege.webprotege.lang.DisplayNameSettingsChangedEvent;

import edu.stanford.protege.webprotege.projectsettings.*;
import edu.stanford.protege.webprotege.permissions.PermissionsChangedEvent;
import edu.stanford.protege.webprotege.revision.RevisionNumber;
import edu.stanford.protege.webprotege.revision.RevisionSummary;
import edu.stanford.protege.webprotege.common.DictionaryLanguage;
import edu.stanford.protege.webprotege.tag.EntityTagsChangedEvent;
import edu.stanford.protege.webprotege.tag.ProjectTagsChangedEvent;
import edu.stanford.protege.webprotege.watches.Watch;
import edu.stanford.protege.webprotege.watches.WatchAddedEvent;
import edu.stanford.protege.webprotege.watches.WatchRemovedEvent;
import edu.stanford.protege.webprotege.watches.WatchType;
import org.junit.Test;

import java.io.IOException;
import java.util.Collections;
import java.util.Optional;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2021-04-15
 */
public class EventsSerializationTestCase {

}
