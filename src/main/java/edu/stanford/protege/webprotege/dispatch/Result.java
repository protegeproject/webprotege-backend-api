package edu.stanford.protege.webprotege.dispatch;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import edu.stanford.protege.webprotege.app.GetApplicationSettingsResult;
import edu.stanford.protege.webprotege.app.SetApplicationSettingsResult;
import edu.stanford.protege.webprotege.bulkop.EditAnnotationsResult;
import edu.stanford.protege.webprotege.bulkop.MoveEntitiesToParentResult;
import edu.stanford.protege.webprotege.bulkop.SetAnnotationValueResult;
import edu.stanford.protege.webprotege.change.GetProjectChangesResult;
import edu.stanford.protege.webprotege.change.RevertRevisionResult;
import edu.stanford.protege.webprotege.common.Response;
import edu.stanford.protege.webprotege.crud.GetEntityCrudKitsResult;
import edu.stanford.protege.webprotege.crud.SetEntityCrudKitSettingsResult;
import edu.stanford.protege.webprotege.entity.*;
import edu.stanford.protege.webprotege.frame.*;
import edu.stanford.protege.webprotege.hierarchy.*;
import edu.stanford.protege.webprotege.individuals.GetIndividualsPageContainingIndividualResult;
import edu.stanford.protege.webprotege.individuals.GetIndividualsResult;
import edu.stanford.protege.webprotege.issues.*;
import edu.stanford.protege.webprotege.user.GetUserIdCompletionsResult;
import edu.stanford.protege.webprotege.lang.GetProjectLangTagsResult;
import edu.stanford.protege.webprotege.mail.GetEmailAddressResult;
import edu.stanford.protege.webprotege.mail.SetEmailAddressResult;
import edu.stanford.protege.webprotege.match.GetMatchingEntitiesResult;
import edu.stanford.protege.webprotege.merge.ComputeProjectMergeResult;
import edu.stanford.protege.webprotege.merge.MergeUploadedProjectResult;
import edu.stanford.protege.webprotege.merge_add.ExistingOntologyMergeAddResult;
import edu.stanford.protege.webprotege.merge_add.GetUploadedOntologiesResult;
import edu.stanford.protege.webprotege.merge_add.MergeOntologiesResult;
import edu.stanford.protege.webprotege.obo.*;
import edu.stanford.protege.webprotege.ontology.GetOntologyAnnotationsResult;
import edu.stanford.protege.webprotege.ontology.GetRootOntologyIdResult;
import edu.stanford.protege.webprotege.ontology.SetOntologyAnnotationsResult;
import edu.stanford.protege.webprotege.permissions.GetProjectPermissionsResult;
import edu.stanford.protege.webprotege.permissions.RebuildPermissionsResult;
import edu.stanford.protege.webprotege.perspective.*;
import edu.stanford.protege.webprotege.project.*;
import edu.stanford.protege.webprotege.projectsettings.GetProjectSettingsResult;
import edu.stanford.protege.webprotege.projectsettings.SetProjectSettingsResult;
import edu.stanford.protege.webprotege.renderer.GetEntityHtmlRenderingResult;
import edu.stanford.protege.webprotege.renderer.GetEntityRenderingResult;
import edu.stanford.protege.webprotege.revision.GetHeadRevisionNumberResult;
import edu.stanford.protege.webprotege.revision.GetRevisionSummariesResult;
import edu.stanford.protege.webprotege.search.GetSearchSettingsResult;
import edu.stanford.protege.webprotege.search.PerformEntitySearchResult;
import edu.stanford.protege.webprotege.search.SetSearchSettingsResult;
import edu.stanford.protege.webprotege.sharing.GetProjectSharingSettingsResult;
import edu.stanford.protege.webprotege.sharing.SetProjectSharingSettingsResult;
import edu.stanford.protege.webprotege.tag.*;
import edu.stanford.protege.webprotege.usage.GetEntityUsageResult;
import edu.stanford.protege.webprotege.viz.GetEntityGraphResult;
import edu.stanford.protege.webprotege.viz.GetUserProjectEntityGraphCriteriaResult;
import edu.stanford.protege.webprotege.viz.SetEntityGraphActiveFiltersResult;
import edu.stanford.protege.webprotege.viz.SetUserProjectEntityGraphSettingsResult;
import edu.stanford.protege.webprotege.watches.GetWatchesResult;
import edu.stanford.protege.webprotege.watches.SetEntityWatchesResult;


/**
 * Author: Matthew Horridge<br>
 * Stanford University<br>
 * Bio-Medical Informatics Research Group<br>
 * Date: 20/01/2013
 * <p>
 *     The basic interface for results which are returned from the dispatch service
 * </p>
 */
public interface Result extends Response {

}