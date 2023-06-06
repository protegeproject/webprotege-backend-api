package edu.stanford.protege.webprotege.usage;

import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.common.PageRequest;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.dispatch.ProjectAction;
import org.semanticweb.owlapi.model.OWLEntity;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Optional;

/**
 * Author: Matthew Horridge<br>
 * Stanford University<br>
 * Bio-Medical Informatics Research Group<br>
 * Date: 11/07/2013
 */


@JsonTypeName("webprotege.entities.GetEntityUsage")
@JsonClassDescription("Requests the entity usage for the specified entity.  The usage is the set of OWL axioms that mention the entity in their signature.")
public record GetEntityUsageAction(@JsonPropertyDescription("The entity whose usage will be returned")
                                   OWLEntity subject,
                                   @JsonPropertyDescription("The project id in which the entity is used")
                                   ProjectId projectId,
                                   @JsonPropertyDescription("The usage filter that specifies they types of axioms to be retrieved etc.")
                                   @Nullable UsageFilter usageFilter,
                                   @Nonnull
                                   PageRequest pageRequest) implements ProjectAction<GetEntityUsageResult> {

    public static final String CHANNEL = "webprotege.entities.GetEntityUsage";

    @Override
    public String getChannel() {
        return CHANNEL;
    }

    public Optional<UsageFilter> getUsageFilter() {
        return Optional.ofNullable(usageFilter);
    }
}
