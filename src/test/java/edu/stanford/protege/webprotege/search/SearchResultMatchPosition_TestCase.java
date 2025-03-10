package edu.stanford.protege.webprotege.search;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class SearchResultMatchPosition_TestCase {

    private final int start = 3;

    private final int end = 5;

    private SearchResultMatchPosition position;

    @BeforeEach
    public void setUp() throws Exception {
        position = SearchResultMatchPosition.get(start, end);
    }

    @Test
    public void shouldGetPositionWithSuppliedStart() {
        assertThat(position.getStart(), is(start));
    }

    @Test
    public void shouldGetPositionWithSuppliedEnd() {
        assertThat(position.getEnd(), is(end));
    }

    @Test
    public void compareToUsingDifferentStartPosition() {
        SearchResultMatchPosition otherPositionWithSmallerStart = SearchResultMatchPosition.get(start - 1, end);
        assertThat(position, is(greaterThan(otherPositionWithSmallerStart)));
    }

    @Test
    public void shouldCompareToUsingDifferentEndPosition() {
        SearchResultMatchPosition otherPositionWithSameStartSmallerEnd = SearchResultMatchPosition.get(start, end - 5);
        assertThat(position, is(greaterThan(otherPositionWithSameStartSmallerEnd)));
    }

    @Test
    public void shouldCompareEqual() {
        SearchResultMatchPosition equalPosition = SearchResultMatchPosition.get(start, end);
        assertThat(position, is(greaterThanOrEqualTo(equalPosition)));
        assertThat(position, is(lessThanOrEqualTo(equalPosition)));
    }
}