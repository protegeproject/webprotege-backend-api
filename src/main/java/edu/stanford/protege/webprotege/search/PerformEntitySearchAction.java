package edu.stanford.protege.webprotege.search;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import edu.stanford.protege.webprotege.common.LangTagFilter;
import edu.stanford.protege.webprotege.common.PageRequest;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.criteria.EntityMatchCriteria;
import edu.stanford.protege.webprotege.criteria.EntityTypeIsOneOfCriteria;
import edu.stanford.protege.webprotege.dispatch.ProjectAction;
import edu.stanford.protege.webprotege.project.HasProjectId;
import org.semanticweb.owlapi.model.EntityType;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Collections;
import java.util.Set;

import static java.util.Objects.requireNonNull;
import static java.util.Objects.requireNonNullElse;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 21 Apr 2017
 */


@JsonTypeName("webprotege.search.PerformEntitySearch")
public record PerformEntitySearchAction(
        @JsonProperty(value = "projectId", required = true) @Nonnull ProjectId projectId,
        @JsonProperty(value = "searchString", required = true) @Nonnull String searchString,
        @JsonProperty(value = "entityTypes", defaultValue = "[]") @Nonnull Set<EntityType<?>> entityTypes,
        @JsonProperty("langTagFilter") @Nonnull LangTagFilter langTagFilter,
        @JsonProperty("searchFilters") @Nonnull ImmutableList<EntitySearchFilter> searchFilters,
        @JsonProperty("pageRequest") @Nonnull PageRequest pageRequest,
        @JsonProperty("resultsSetFilter") @Nullable EntityMatchCriteria resultsSetFilter,
        @JsonProperty("deprecatedEntitiesTreatment") DeprecatedEntitiesTreatment deprecatedEntitiesTreatment) implements ProjectAction<PerformEntitySearchResult>, HasProjectId {

    public static final String CHANNEL = "webprotege.search.PerformEntitySearch";

    public PerformEntitySearchAction(@JsonProperty("projectId") @Nonnull ProjectId projectId,
                                     @JsonProperty("searchString") @Nonnull String searchString,
                                     @JsonProperty(value = "entityTypes") @Nonnull Set<EntityType<?>> entityTypes,
                                     @JsonProperty("langTagFilter") @Nonnull LangTagFilter langTagFilter,
                                     @JsonProperty("searchFilters") @Nonnull ImmutableList<EntitySearchFilter> searchFilters,
                                     @JsonProperty("pageRequest") @Nonnull PageRequest pageRequest,
                                     @JsonProperty("resultsSetFilter") @Nullable EntityMatchCriteria resultsSetFilter,
                                     @JsonProperty("deprecatedEntitiesTreatment") DeprecatedEntitiesTreatment deprecatedEntitiesTreatment) {
        this.projectId = requireNonNull(projectId);
        this.searchString = requireNonNull(searchString);
        this.entityTypes = requireNonNullElse(entityTypes, Collections.emptySet());
        this.langTagFilter = requireNonNullElse(langTagFilter, LangTagFilter.get(ImmutableSet.of()));
        this.searchFilters = requireNonNullElse(searchFilters, ImmutableList.of());
        this.pageRequest = requireNonNullElse(pageRequest, PageRequest.requestFirstPage());
        this.resultsSetFilter = requireNonNullElse(resultsSetFilter, EntityTypeIsOneOfCriteria.get(ImmutableSet.copyOf(entityTypes)));
        this.deprecatedEntitiesTreatment = requireNonNullElse(deprecatedEntitiesTreatment, DeprecatedEntitiesTreatment.INCLUDE_DEPRECATED_ENTITIES);
    }

    public PerformEntitySearchAction(@Nonnull ProjectId projectId, @Nonnull String searchString, @Nonnull Set<EntityType<?>> entityTypes, @Nonnull LangTagFilter langTagFilter, @Nonnull ImmutableList<EntitySearchFilter> searchFilters, @Nonnull PageRequest pageRequest) {
        this(projectId, searchString, entityTypes, langTagFilter, searchFilters, pageRequest, null, DeprecatedEntitiesTreatment.INCLUDE_DEPRECATED_ENTITIES);
    }

    @Override
    public String getChannel() {
        return CHANNEL;
    }
}
