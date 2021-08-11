package edu.stanford.protege.webprotege.crud;

import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.dispatch.Result;

import java.util.List;

/**
 * Author: Matthew Horridge<br>
 * Stanford University<br>
 * Bio-Medical Informatics Research Group<br>
 * Date: 8/19/13
 */
@JsonTypeName("GetEntityCrudKits")
public record GetEntityCrudKitsResult(List<EntityCrudKit> kits,
                                      EntityCrudKitSettings currentSettings) implements Result {
}
