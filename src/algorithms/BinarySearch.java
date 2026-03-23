package algorithms;

import java.util.List;
import models.Event;

public class BinarySearch {

    public static Event searchById(List<Event> events, int targetId) {

        int left = 0;
        int right = events.size() - 1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            Event midEvent = events.get(mid);

            if (midEvent.getEventId() == targetId) {
                return midEvent;
            }

            else if (midEvent.getEventId() < targetId) {
                left = mid + 1;
            }

            else {
                right = mid - 1;
            }
        }

        return null;
    }
}