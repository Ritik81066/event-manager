package algorithms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import models.Event;

public class GreedyScheduler {

    public static List<Event> scheduleEvents(List<Event> events) {

        events.sort(Comparator.comparing(Event::getEndTime));

        List<Event> selected = new ArrayList<>();

        Event lastEvent = null;

        for (Event e : events) {

            if (lastEvent == null ||
                    e.getStartTime().isAfter(lastEvent.getEndTime())) {

                selected.add(e);
                lastEvent = e;
            }
        }

        return selected;
    }
}