package datastructures;

import models.Event;

import java.util.PriorityQueue;

public class EventHeap {

    private PriorityQueue<Event> heap =
            new PriorityQueue<>(
                    (a, b) ->
                            b.getParticipants().size() -
                                    a.getParticipants().size()
            );

    public void addEvent(Event event) {
        heap.add(event);
    }

    public Event getMostPopularEvent() {

        if (heap.isEmpty()) return null;

        return heap.peek();
    }
}