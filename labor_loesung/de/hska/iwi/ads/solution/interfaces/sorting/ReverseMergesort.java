package de.hska.iwi.ads.solution.sorting;

import de.hska.iwi.ads.sorting.AbstractMergesort;
import de.hska.iwi.ads.sorting.Reverse;

public class ReverseMergesort<E extends Comparable<E>> extends AbstractMergesort<E> {
    @Override
    protected void mergesort(E[] a, int left, int right) {
        int middle = (left + right) / 2;    //split in half
        if (left < right) {
            mergesort(a, left, middle);     //sort first half
            mergesort(a, middle + 1, right);    //sort second half
            merge(a, left, middle, right);
        }
    }

    private void merge(E[] a, int left, int middle, int right) {
        ReverseArray<E> reverseCursedTechnique = new ReverseArray<>();
        int leftIndex = left;
        int rightIndex = right;
        reverseCursedTechnique.reverse(a, middle + 1, right);   //reverse second half of the sequence

        for (int i = left; i <= right; i++) {       //go through sequence
            if ((leftIndex <= middle && a[leftIndex].compareTo(a[rightIndex]) <= 0)) {    //when current entry on the left side is smaller than current entry on the right side
                b[i] = a[leftIndex];    //store entry
                leftIndex++;            //update to increase index on the left side
            }
            else {      //when current entry on the right side is smaller than current entry on the left side
                b[i] = a[rightIndex];   //store entry
                rightIndex--;           //update to decrease index on the right side
            }
        }

        for (int i = left; i <= right; i++) {
            a[i] = b[i];                //copy sorted sequence in storage to the main sequence
        }
    }
}
