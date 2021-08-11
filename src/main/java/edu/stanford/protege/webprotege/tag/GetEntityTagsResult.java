package edu.stanford.protege.webprotege.tag;

import edu.stanford.protege.webprotege.dispatch.Result;

import java.util.Collection;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 18 Mar 2018
 */
public record GetEntityTagsResult(Collection<Tag> entityTags,
                                 Collection<Tag> projectTags) implements Result {
}
