package de.hska.iwi.ads.solution.search;

import de.hska.iwi.ads.search.Search;

public class BinarySearch<E extends Comparable<E>> implements Search<E> {
    @Override
    public int search(E[] a, E key, int left, int right) {
        if (key.compareTo(a[left]) < 0) {   //if key is below limit
            return left - 1;
        }
        if (key.compareTo(a[right]) > 0) {  //if key is above limit
            return right + 1;
        }

        int indexFound = -1;
        int beginning = left;
        int end = right;
        int median = (beginning + end) / 2;     //preparation
        while (beginning <= end) {              //until gone through the entire sequence
            if (a[median].compareTo(key) == 0) {        //when found
                indexFound = median;
                end = median - 1;
            }
            else if (key.compareTo(a[median]) < 0) {     //when key is in lower half
                end = median - 1;
            }
            else if (key.compareTo(a[median]) > 0) {    //when key is in upper half
                beginning = median + 1;
            }
            median = (beginning + end) / 2;     //adjust median
        }
        if (indexFound == -1) {        //if key is not part of the sequence
            return beginning;
        }
        return indexFound;
    }
}
