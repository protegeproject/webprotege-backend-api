package edu.stanford.protege.webprotege.crud.persistence;

import edu.stanford.protege.webprotege.crud.EntityCrudKitId;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Author: Matthew Horridge<br>
 * Stanford University<br>
 * Bio-Medical Informatics Research Group<br>
 * Date: 13/08/2013
 */
public class EntityCrudKitIdTestCase {

    public void throwsNullPointerExceptionWithNullLexicalForm() {
        assertThrows(NullPointerException.class, () -> {
            EntityCrudKitId.get(null);
        });
    }

    @Test
    public void equalsIsTrueWithSameLexicalForms() {
        EntityCrudKitId idA = EntityCrudKitId.get("A");
        EntityCrudKitId idB = EntityCrudKitId.get("A");
        assertEquals(idA, idB);
    }

    @Test
    public void equalsIsFalseWithDifferentLexicalForms() {
        EntityCrudKitId idA = EntityCrudKitId.get("A");
        EntityCrudKitId idB = EntityCrudKitId.get("B");
        assertNotEquals(idA, idB);
    }

    @Test
    public void getLexicalFormIsEqualToTheConstructorLexicalForm() {
        EntityCrudKitId id = EntityCrudKitId.get("A");
        assertEquals(id.getLexicalForm(), "A");
    }
}
