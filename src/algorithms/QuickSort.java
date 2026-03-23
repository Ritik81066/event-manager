package algorithms;

import java.util.List;
import models.Event;

public class QuickSort {

    public static void quickSort(List<Event> events, int low, int high) {

        if (low < high) {

            int pi = partition(events, low, high);

            quickSort(events, low, pi - 1);
            quickSort(events, pi + 1, high);
        }
    }

    private static int partition(List<Event> events, int low, int high) {

        int pivot = events.get(high).getCapacity();

        int i = low - 1;

        for (int j = low; j < high; j++) {

            if (events.get(j).getCapacity() <= pivot) {

                i++;

                Event temp = events.get(i);
                events.set(i, events.get(j));
                events.set(j, temp);
            }
        }

        Event temp = events.get(i + 1);
        events.set(i + 1, events.get(high));
        events.set(high, temp);

        return i + 1;
    }
}