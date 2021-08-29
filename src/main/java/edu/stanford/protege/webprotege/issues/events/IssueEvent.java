package edu.stanford.protege.webprotege.issues.events;

import edu.stanford.protege.webprotege.common.Event;
import edu.stanford.protege.webprotege.common.ProjectEvent;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.common.UserId;

import javax.annotation.Nonnull;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 26 Sep 16
 */
public interface IssueEvent extends ProjectEvent {

    @Nonnull
    ProjectId projectId();

    @Nonnull
    UserId userId();

    long timestamp();
}
