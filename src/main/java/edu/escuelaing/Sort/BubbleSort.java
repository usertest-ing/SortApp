package edu.escuelaing.Sort;

public class BubbleSort<T extends Comparable<? super T>> {

    public T[] bubbleSort(T[] array) {
        int n = array.length;
        while (n > 0) {
            int lastModifiedIndex = 0;
            for (int currentIndex = 1; currentIndex < n; currentIndex++) {
                if (array[currentIndex - 1].compareTo(array[currentIndex]) > 0) {
                    T temp = array[currentIndex - 1];
                    array[currentIndex - 1] = array[currentIndex];
                    array[currentIndex] = temp;
                    lastModifiedIndex = currentIndex;
                }
            }
            n = lastModifiedIndex;
        }
        return array;
    }
}