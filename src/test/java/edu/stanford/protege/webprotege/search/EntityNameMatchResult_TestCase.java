package edu.stanford.protege.webprotege.search;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Author: Matthew Horridge<br>
 * Stanford University<br>
 * Bio-Medical Informatics Research Group<br>
 * Date: 14/11/2013
 */
public class EntityNameMatchResult_TestCase {


    public void shouldThrowIllegalArgumentExceptionForNegativeStart() {
        assertThrows(NullPointerException.class, () -> {
            EntityNameMatchResult.get(-1, 0, EntityNameMatchType.SUB_STRING_MATCH, PrefixNameMatchType.NOT_IN_PREFIX_NAME);
        });
    }

    public void shouldThrowIllegalArgumentExceptionForNegativeEnd() {
        assertThrows(NullPointerException.class, () -> {
            EntityNameMatchResult.get(0, -1, EntityNameMatchType.SUB_STRING_MATCH, PrefixNameMatchType.NOT_IN_PREFIX_NAME);
        });
    }

    public void shouldThrowIllegalArgumentExceptionForEndLessThanStart() {
        assertThrows(NullPointerException.class, () -> {
            EntityNameMatchResult.get(1, 0, EntityNameMatchType.SUB_STRING_MATCH, PrefixNameMatchType.NOT_IN_PREFIX_NAME);
        });
    }

    public void shouldThrowNullPointerExceptionForNullType() {
        assertThrows(NullPointerException.class, () -> {
            EntityNameMatchResult.get(0, 1, null, PrefixNameMatchType.NOT_IN_PREFIX_NAME);
        });
    }

    public void shouldThrowNullPointerExceptionForNullPrefixNameMatchType() {
        assertThrows(NullPointerException.class, () -> {
            EntityNameMatchResult.get(0, 1, EntityNameMatchType.SUB_STRING_MATCH, null);
        });
    }

    @Test
    public void shouldAcceptStartEqualToEnd() {
        EntityNameMatchResult.get(1, 1, EntityNameMatchType.SUB_STRING_MATCH, PrefixNameMatchType.NOT_IN_PREFIX_NAME);
    }

    @Test
    public void shouldReturnTrueForEqualButDifferentEntityMatchResults() {
        EntityNameMatchResult resultA = EntityNameMatchResult.get(1, 2, EntityNameMatchType.SUB_STRING_MATCH, PrefixNameMatchType.NOT_IN_PREFIX_NAME);
        EntityNameMatchResult resultB = EntityNameMatchResult.get(1, 2, EntityNameMatchType.SUB_STRING_MATCH, PrefixNameMatchType.NOT_IN_PREFIX_NAME);
        assertEquals(resultA, resultB);
    }

    @Test
    public void shouldReturnSameHashCodeForEqualButDifferentEntityMatchResults() {
        EntityNameMatchResult resultA = EntityNameMatchResult.get(1, 2, EntityNameMatchType.SUB_STRING_MATCH, PrefixNameMatchType.NOT_IN_PREFIX_NAME);
        EntityNameMatchResult resultB = EntityNameMatchResult.get(1, 2, EntityNameMatchType.SUB_STRING_MATCH, PrefixNameMatchType.NOT_IN_PREFIX_NAME);
        assertEquals(resultA.hashCode(), resultB.hashCode());
    }

    @Test
    public void shouldReturnZeroForComparisonOfEqual() {
        EntityNameMatchResult resultA = EntityNameMatchResult.get(0, 1, EntityNameMatchType.WORD_MATCH, PrefixNameMatchType.NOT_IN_PREFIX_NAME);
        EntityNameMatchResult resultB = EntityNameMatchResult.get(0, 1, EntityNameMatchType.WORD_MATCH, PrefixNameMatchType.NOT_IN_PREFIX_NAME);
        assertEquals(0, resultA.compareTo(resultB));
    }

    @Test
    public void shouldReturnNegativeIntegerForExactComparedToWord() {
        EntityNameMatchResult resultA = EntityNameMatchResult.get(1, 2, EntityNameMatchType.EXACT_MATCH, PrefixNameMatchType.NOT_IN_PREFIX_NAME);
        EntityNameMatchResult resultB = EntityNameMatchResult.get(0, 1, EntityNameMatchType.WORD_MATCH, PrefixNameMatchType.NOT_IN_PREFIX_NAME);
        assertTrue(resultA.compareTo(resultB) < 0);
    }


    @Test
    public void shouldReturnNegativeIntegerForWordComparedToWordPrefix() {
        EntityNameMatchResult resultA = EntityNameMatchResult.get(1, 2, EntityNameMatchType.WORD_MATCH, PrefixNameMatchType.NOT_IN_PREFIX_NAME);
        EntityNameMatchResult resultB = EntityNameMatchResult.get(0, 1, EntityNameMatchType.WORD_PREFIX_MATCH, PrefixNameMatchType.NOT_IN_PREFIX_NAME);
        assertTrue(resultA.compareTo(resultB) < 0);
    }

    @Test
    public void shouldReturnNegativeIntegerForWordPrefixComparedToSubString() {
        EntityNameMatchResult resultA = EntityNameMatchResult.get(1, 2, EntityNameMatchType.WORD_PREFIX_MATCH, PrefixNameMatchType.NOT_IN_PREFIX_NAME);
        EntityNameMatchResult resultB = EntityNameMatchResult.get(0, 1, EntityNameMatchType.SUB_STRING_MATCH, PrefixNameMatchType.NOT_IN_PREFIX_NAME);
        assertTrue(resultA.compareTo(resultB) < 0);
    }

    @Test
    public void shouldReturnNegativeIntegerForSmallerStartThanLargerStart() {
        EntityNameMatchResult resultA = EntityNameMatchResult.get(0, 1, EntityNameMatchType.EXACT_MATCH, PrefixNameMatchType.NOT_IN_PREFIX_NAME);
        EntityNameMatchResult resultB = EntityNameMatchResult.get(1, 1, EntityNameMatchType.EXACT_MATCH, PrefixNameMatchType.NOT_IN_PREFIX_NAME);
        assertTrue(resultA.compareTo(resultB) < 0);
    }

    @Test
    public void shouldReturnNegativeIntegerForSmallerEndThanLargerEnd() {
        EntityNameMatchResult resultA = EntityNameMatchResult.get(1, 1, EntityNameMatchType.EXACT_MATCH, PrefixNameMatchType.NOT_IN_PREFIX_NAME);
        EntityNameMatchResult resultB = EntityNameMatchResult.get(1, 2, EntityNameMatchType.EXACT_MATCH, PrefixNameMatchType.NOT_IN_PREFIX_NAME);
        assertTrue(resultA.compareTo(resultB) < 0);
    }

    @Test
    public void shouldReturnNegativeIntegerForNotInPrefixNameComparedToInPrefixName() {
        EntityNameMatchResult resultA = EntityNameMatchResult.get(0, 1, EntityNameMatchType.WORD_MATCH, PrefixNameMatchType.NOT_IN_PREFIX_NAME);
        EntityNameMatchResult resultB = EntityNameMatchResult.get(0, 1, EntityNameMatchType.WORD_MATCH, PrefixNameMatchType.IN_PREFIX_NAME);
        assertTrue(resultA.compareTo(resultB) < 0);
    }

    @Test
    public void shouldReturnNegativeIntegerWithPrefixNameMatchDifferenceOverLowerStartIndex() {
        EntityNameMatchResult resultA = EntityNameMatchResult.get(3, 4, EntityNameMatchType.SUB_STRING_MATCH, PrefixNameMatchType.NOT_IN_PREFIX_NAME);
        EntityNameMatchResult resultB = EntityNameMatchResult.get(0, 1, EntityNameMatchType.SUB_STRING_MATCH, PrefixNameMatchType.IN_PREFIX_NAME);
        assertTrue(resultA.compareTo(resultB) < 0);
    }


}
