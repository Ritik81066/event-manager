package datastructures;

import models.Participant;

import java.util.PriorityQueue;

public class PriorityWaitingQueue {

    private PriorityQueue<Participant> pq =
            new PriorityQueue<>(
                    (a, b) -> a.getParticipantId() - b.getParticipantId()
            );

    public void addParticipant(Participant p) {
        pq.add(p);
    }

    public Participant getNextParticipant() {

        if (pq.isEmpty()) return null;

        return pq.poll();
    }
}