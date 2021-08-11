package edu.stanford.protege.webprotege.tag;

import edu.stanford.protege.webprotege.dispatch.Result;

import java.util.Map;
import java.util.Set;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 18 Mar 2018
 */
public record GetProjectTagsResult(Set<Tag> tags,
                                   Map<TagId, Integer> tagUsage) implements Result {

}
