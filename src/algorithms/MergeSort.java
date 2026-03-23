package algorithms;

import java.util.List;
import models.Event;

public class MergeSort {

    public static void mergeSort(List<Event> events, int left, int right) {

        if (left < right) {

            int mid = (left + right) / 2;

            mergeSort(events, left, mid);
            mergeSort(events, mid + 1, right);

            merge(events, left, mid, right);
        }
    }

    private static void merge(List<Event> events, int left, int mid, int right) {

        int n1 = mid - left + 1;
        int n2 = right - mid;

        Event[] L = new Event[n1];
        Event[] R = new Event[n2];

        for (int i = 0; i < n1; i++)
            L[i] = events.get(left + i);

        for (int j = 0; j < n2; j++)
            R[j] = events.get(mid + 1 + j);

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {

            if (L[i].getEventDate().isBefore(R[j].getEventDate())) {
                events.set(k++, L[i++]);
            } else {
                events.set(k++, R[j++]);
            }
        }

        while (i < n1)
            events.set(k++, L[i++]);

        while (j < n2)
            events.set(k++, R[j++]);
    }
}