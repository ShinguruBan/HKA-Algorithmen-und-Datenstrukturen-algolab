package de.hska.iwi.ads.solution.sorting;

import de.hska.iwi.ads.sorting.Reverse;

public class ReverseArray<E extends Comparable<E>> implements Reverse<E> {
    @Override
    public void reverse(E[] a, int from, int to) {
        E additionalStorage;

        if (from < 0 || to >= a.length) {
            throw new ArrayIndexOutOfBoundsException();
        }

        while (from < to) {
            additionalStorage = a[from];
            a[from] = a[to];
            a[to] = additionalStorage;      //switch the places of the outer values
            from++;
            to--;                           //work from the outside in
        }
    }
}
