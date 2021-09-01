package edu.stanford.protege.webprotege.dispatch;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import edu.stanford.protege.webprotege.app.GetApplicationSettingsAction;
import edu.stanford.protege.webprotege.app.SetApplicationSettingsAction;
import edu.stanford.protege.webprotege.bulkop.EditAnnotationsAction;
import edu.stanford.protege.webprotege.bulkop.MoveEntitiesToParentAction;
import edu.stanford.protege.webprotege.bulkop.SetAnnotationValueAction;
import edu.stanford.protege.webprotege.change.GetProjectChangesAction;
import edu.stanford.protege.webprotege.change.RevertRevisionAction;
import edu.stanford.protege.webprotege.common.Request;
import edu.stanford.protege.webprotege.crud.GetEntityCrudKitsAction;
import edu.stanford.protege.webprotege.crud.SetEntityCrudKitSettingsAction;
import edu.stanford.protege.webprotege.entity.*;
import edu.stanford.protege.webprotege.frame.*;
import edu.stanford.protege.webprotege.hierarchy.*;
import edu.stanford.protege.webprotege.individuals.GetIndividualsAction;
import edu.stanford.protege.webprotege.individuals.GetIndividualsPageContainingIndividualAction;
import edu.stanford.protege.webprotege.issues.*;
import edu.stanford.protege.webprotege.user.GetUserIdCompletionsAction;
import edu.stanford.protege.webprotege.lang.GetProjectLangTagsAction;
import edu.stanford.protege.webprotege.mail.GetEmailAddressAction;
import edu.stanford.protege.webprotege.mail.SetEmailAddressAction;
import edu.stanford.protege.webprotege.match.GetMatchingEntitiesAction;
import edu.stanford.protege.webprotege.merge.ComputeProjectMergeAction;
import edu.stanford.protege.webprotege.merge.MergeUploadedProjectAction;
import edu.stanford.protege.webprotege.merge_add.ExistingOntologyMergeAddAction;
import edu.stanford.protege.webprotege.merge_add.GetUploadedOntologiesAction;
import edu.stanford.protege.webprotege.merge_add.MergeOntologiesAction;
import edu.stanford.protege.webprotege.obo.*;
import edu.stanford.protege.webprotege.ontology.GetOntologyAnnotationsAction;
import edu.stanford.protege.webprotege.ontology.GetRootOntologyIdAction;
import edu.stanford.protege.webprotege.ontology.SetOntologyAnnotationsAction;
import edu.stanford.protege.webprotege.permissions.GetProjectPermissionsAction;
import edu.stanford.protege.webprotege.permissions.RebuildPermissionsAction;
import edu.stanford.protege.webprotege.perspective.*;
import edu.stanford.protege.webprotege.project.*;
import edu.stanford.protege.webprotege.projectsettings.GetProjectSettingsAction;
import edu.stanford.protege.webprotege.projectsettings.SetProjectSettingsAction;
import edu.stanford.protege.webprotege.renderer.GetEntityHtmlRenderingAction;
import edu.stanford.protege.webprotege.renderer.GetEntityRenderingAction;
import edu.stanford.protege.webprotege.revision.GetHeadRevisionNumberAction;
import edu.stanford.protege.webprotege.revision.GetRevisionSummariesAction;
import edu.stanford.protege.webprotege.search.GetSearchSettingsAction;
import edu.stanford.protege.webprotege.search.PerformEntitySearchAction;
import edu.stanford.protege.webprotege.search.SetSearchSettingsAction;
import edu.stanford.protege.webprotege.sharing.GetProjectSharingSettingsAction;
import edu.stanford.protege.webprotege.sharing.SetProjectSharingSettingsAction;
import edu.stanford.protege.webprotege.tag.*;
import edu.stanford.protege.webprotege.usage.GetEntityUsageAction;
import edu.stanford.protege.webprotege.viz.GetEntityGraphAction;
import edu.stanford.protege.webprotege.viz.GetUserProjectEntityGraphCriteriaAction;
import edu.stanford.protege.webprotege.viz.SetEntityGraphActiveFiltersAction;
import edu.stanford.protege.webprotege.viz.SetUserProjectEntityGraphSettingsAction;
import edu.stanford.protege.webprotege.watches.GetWatchesAction;
import edu.stanford.protege.webprotege.watches.SetEntityWatchesAction;


/**
 * Author: Matthew Horridge<br>
 * Stanford University<br>
 * Bio-Medical Informatics Research Group<br>
 * Date: 20/01/2013
 * <p>
 *     The basic interface for actions that are sent to the dispatch service
 * </p>
 */
public interface Action<R extends Result> extends Request<R> {
}
