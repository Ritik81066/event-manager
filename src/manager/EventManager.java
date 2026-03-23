package manager;

import services.EventService;
import models.Event;

import java.util.List;

public class EventManager {

    private EventService eventService;

    public EventManager() {
        eventService = new EventService();
    }

    public void createEvent(Event event) {

        boolean success = eventService.createEvent(event);

        if (success) {
            System.out.println("Event created successfully.");
        } else {
            System.out.println("Failed to create event.");
        }
    }

    public void deleteEvent(int eventId) {

        boolean success = eventService.deleteEvent(eventId);

        if (success) {
            System.out.println("Event deleted successfully.");
        } else {
            System.out.println("Event not found.");
        }
    }

    public void updateEvent(Event event) {

        boolean success = eventService.updateEvent(event);

        if (success) {
            System.out.println("Event updated successfully.");
        } else {
            System.out.println("Update failed.");
        }
    }

    public void viewAllEvents() {

        List<Event> events = eventService.getAllEvents();

        if (events.isEmpty()) {
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

    public Event searchEventById(int eventId) {

        Event event = eventService.getEventById(eventId);

        if (event == null) {
            System.out.println("Event not found.");
        }

        return event;
    }
}