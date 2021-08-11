package edu.stanford.protege.webprotege.frame;

import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.dispatch.Result;
import edu.stanford.protege.webprotege.entity.OWLEntityData;

import javax.annotation.Nonnull;

/**
 * @author Matthew Horridge, Stanford University, Bio-Medical Informatics Research Group, Date: 18/03/2014
 */


@JsonTypeName("GetManchesterSyntaxFrame")
public record GetManchesterSyntaxFrameResult(@Nonnull OWLEntityData subject,
                                             @Nonnull String rendering) implements Result {
}
