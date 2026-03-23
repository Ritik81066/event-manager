import manager.EventManager;
import manager.ParticipantManager;
import models.Event;
import models.Participant;
import utils.InputUtil;

import java.time.LocalDate;
import java.time.LocalTime;

public class Main {

    public static void main(String[] args) {

        EventManager eventManager = new EventManager();
        ParticipantManager participantManager = new ParticipantManager();

        boolean running = true;

        while (running) {

            System.out.println("\n===== EVENT MANAGEMENT SYSTEM =====");
            System.out.println("1. Create Event");
            System.out.println("2. View All Events");
            System.out.println("3. Delete Event");
            System.out.println("4. Register Participant");
            System.out.println("5. View Participants");
            System.out.println("6. Search Event");
            System.out.println("7. Exit");

            int choice = InputUtil.readInt("Enter choice: ");

            switch (choice) {

                case 1 -> {

                    String name = InputUtil.readString("Event Name: ");

                    String date = InputUtil.readString("Event Date (YYYY-MM-DD): ");
                    String start = InputUtil.readString("Start Time (HH:MM): ");
                    String end = InputUtil.readString("End Time (HH:MM): ");

                    String venueName = InputUtil.readString("Venue : ");
                    String categoryName = InputUtil.readString("Category : ");
                    int capacity = InputUtil.readInt("Capacity: ");

                    Event event = new Event();

                    event.setEventName(name);
                    event.setEventDate(LocalDate.parse(date));
                    event.setStartTime(LocalTime.parse(start));
                    event.setEndTime(LocalTime.parse(end));
                    event.setVenueName(venueName);
                    event.setCategoryName(categoryName);
                    event.setCapacity(capacity);

                    eventManager.createEvent(event);
                }

                case 2 -> eventManager.viewAllEvents();

                case 3 -> {

                    int id = InputUtil.readInt("Enter Event ID to delete: ");
                    eventManager.deleteEvent(id);
                }

                case 4 -> {

                    int eventId = InputUtil.readInt("Event ID: ");

                    String name = InputUtil.readString("Participant Name: ");
                    String email = InputUtil.readString("Participant Email: ");

                    Participant p = new Participant();
                    p.setName(name);
                    p.setEmail(email);

                    participantManager.registerParticipant(eventId, p);
                }

                case 5 -> {

                    int eventId = InputUtil.readInt("Event ID: ");
                    participantManager.viewParticipants(eventId);
                }

                case 6 -> {

                    int eventId = InputUtil.readInt("Enter Event ID: ");
                    eventManager.searchEventById(eventId);
                }

                case 7 -> {

                    running = false;
                    System.out.println("Exiting system...");
                }

                default -> System.out.println("Invalid choice.");
            }
        }
    }
}