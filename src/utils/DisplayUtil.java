package utils;

import models.Event;
import models.Participant;

import java.util.List;

public class DisplayUtil {

    public static void displayEvents(List<Event> events) {

        if (events == null || events.isEmpty()) {
            System.out.println("No events available.");
            return;
        }

        for (Event e : events) {

            System.out.println(
                    "ID: " + e.getEventId() +
                            " | Name: " + e.getEventName() +
                            " | Date: " + e.getEventDate() +
                            " | Capacity: " + e.getCapacity()
            );
        }
    }

    public static void displayParticipants(List<Participant> participants) {

        if (participants == null || participants.isEmpty()) {
            System.out.println("No participants found.");
            return;
        }

        for (Participant p : participants) {

            System.out.println(
                    "ID: " + p.getParticipantId() +
                            " | Name: " + p.getName() +
                            " | Email: " + p.getEmail()
            );
        }
    }
}