package edu.stanford.protege.webprotege.project;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.google.auto.value.AutoValue;
import com.google.common.collect.ImmutableList;
import edu.stanford.protege.webprotege.dispatch.Result;
import edu.stanford.protege.webprotege.lang.DictionaryLanguageUsage;
import edu.stanford.protege.webprotege.projectsettings.ProjectSettings;

import javax.annotation.Nonnull;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 21 Aug 2018
 */


@JsonTypeName("GetProjectInfo")
public record GetProjectInfoResult(@JsonProperty("projectSettings") @Nonnull ProjectSettings projectSettings,
                                   @JsonProperty("projectLanguages") @Nonnull ImmutableList<DictionaryLanguageUsage> projectLanguages) implements Result {
}
