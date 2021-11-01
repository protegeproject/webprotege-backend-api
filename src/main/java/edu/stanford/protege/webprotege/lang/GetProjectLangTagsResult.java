package edu.stanford.protege.webprotege.lang;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.google.common.collect.ImmutableSet;
import edu.stanford.protege.webprotege.common.LangTag;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.dispatch.Result;

import javax.annotation.Nonnull;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2020-04-26
 */
@JsonTypeName("webprotege.projects.GetProjectLangTags")
public record GetProjectLangTagsResult(@Nonnull ProjectId projectId, @Nonnull ImmutableSet<LangTag> langTags) implements Result {

}
