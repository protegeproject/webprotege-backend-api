package edu.stanford.protege.webprotege.form;

import com.google.common.collect.ImmutableMap;
import edu.stanford.protege.webprotege.dispatch.ProjectAction;
import edu.stanford.protege.webprotege.form.data.FormData;
import edu.stanford.protege.webprotege.common.ProjectId;
import org.semanticweb.owlapi.model.OWLEntity;

import javax.annotation.Nonnull;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2019-11-01
 */
public record SetEntityFormsDataAction(@Nonnull ProjectId projectId,
                                      @Nonnull OWLEntity entity,
                                      @Nonnull ImmutableMap<FormId, FormData> pristineFormsData,
                                      @Nonnull FormDataByFormId editedFormsData) implements ProjectAction<SetEntityFormDataResult> {
}
