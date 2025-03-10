package edu.stanford.protege.webprotege.shortform;

import edu.stanford.protege.webprotege.common.ShortFormMatchPosition;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ShortFormMatchPosition_TestCase {

    @Test
    public void shouldCompareLessThanOnStart() {
        var p1 = ShortFormMatchPosition.get(1, 4);
        var p2 = ShortFormMatchPosition.get(2, 4);
        assertThat(p1.compareTo(p2), lessThan(0));
    }

    @Test
    public void shouldCompareLessThanOnEnd() {
        var p1 = ShortFormMatchPosition.get(1, 3);
        var p2 = ShortFormMatchPosition.get(1, 4);
        assertThat(p1.compareTo(p2), lessThan(0));
    }

    @Test
    public void shouldCompareEqual() {
        var p1 = ShortFormMatchPosition.get(1, 3);
        var p2 = ShortFormMatchPosition.get(1, 3);
        assertThat(p1.compareTo(p2), equalTo(0));
    }

    public void shouldThrowExceptionForStartGreaterThanEnd() {
        assertThrows(NullPointerException.class, () -> {
            ShortFormMatchPosition.get(3, 2);
        });
    }

    public void shouldThrowExceptionForStartLessThanZero() {
        assertThrows(NullPointerException.class, () -> {
            ShortFormMatchPosition.get(-2, 2);
        });
    }
}