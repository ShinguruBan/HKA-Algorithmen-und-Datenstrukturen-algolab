package de.hska.iwi.ads.solution.search;

import de.hska.iwi.ads.search.Search;
import de.hska.iwi.ads.search.SearchTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinarySearchTest extends SearchTest {
    @Override
    public <E extends Comparable<E>> Search<E> createSearch() {
        BinarySearch test = new BinarySearch();
        return new BinarySearch<>();
    }

    @Test
    void testSearchIntegerArray() {
        Search<Integer> search = createSearch();
        Integer [] a = {0, 1, 2, 3, 4, 5, 6};
        assertEquals(5, search.search(a, 5));
    }

    @Test
    void testSearchIntegerArrayLowerLimit() {
        Search<Integer> search = createSearch();
        Integer [] a = {0, 1, 2, 3, 4, 5, 6};
        assertEquals(5, search.search(a, 5, 3, 6));
    }

    @Test
    void testSearchIntegerArrayUpperLimit() {
        Search<Integer> search = createSearch();
        Integer [] a = {0, 1, 2, 3, 4, 5, 6};
        assertEquals(5, search.search(a, 5, 0, 5));
    }

    @Test
    void testSearchIntegerArrayLimit() {
        Search<Integer> search = createSearch();
        Integer [] a = {0, 1, 2, 3, 4, 5, 6};
        assertEquals(5, search.search(a, 5, 3, 5));
    }

    @Test
    void testSearchIntegerArrayOutOfBoundsLower() {
        Search<Integer> search = createSearch();
        Integer [] a = {0, 1, 2, 3, 4, 5, 6};
        assertEquals(3, search.search(a, 2, 4, 6));
    }

    @Test
    void testSearchIntegerArrayOutOfBoundsHigher() {
        Search<Integer> search = createSearch();
        Integer [] a = {0, 1, 2, 3, 4, 5, 6};
        assertEquals(4, search.search(a, 5, 0, 3));
    }
}
