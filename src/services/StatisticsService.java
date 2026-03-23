package services;

import models.Event;

import java.util.List;
import java.util.PriorityQueue;

public class StatisticsService {

    public Event getMostPopularEvent(List<Event> events) {

        PriorityQueue<Event> heap =
                new PriorityQueue<>(
                        (a, b) ->
                                b.getParticipants().size() -
                                        a.getParticipants().size()
                );

        heap.addAll(events);

        return heap.peek();
    }
}