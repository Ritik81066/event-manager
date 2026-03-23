package datastructures;

import models.Participant;

import java.util.LinkedList;

public class WaitingQueue {

    private LinkedList<Participant> queue = new LinkedList<>();

    public void enqueue(Participant p) {
        queue.addLast(p);
    }

    public Participant dequeue() {

        if (queue.isEmpty()) return null;

        return queue.removeFirst();
    }

    public Participant peek() {

        if (queue.isEmpty()) return null;

        return queue.getFirst();
    }
}