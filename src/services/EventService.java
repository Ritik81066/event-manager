package services;

import repository.EventRepository;
import models.Event;

import java.util.HashMap;
import java.util.List;

public class EventService {

    private EventRepository eventRepository;
    private HashMap<Integer, Event> eventCache;

    public EventService() {
        eventRepository = new EventRepository();
        eventCache = new HashMap<>();
    }

    public boolean createEvent(Event event) {

        boolean success = eventRepository.createEvent(event);

        if (success) {
            eventCache.put(event.getEventId(), event);
        }

        return success;
    }

    public boolean deleteEvent(int eventId) {

        boolean success = eventRepository.deleteEvent(eventId);

        if (success) {
            eventCache.remove(eventId);
        }

        return success;
    }

    public boolean updateEvent(Event event) {

        deleteEvent(event.getEventId());
        return createEvent(event);
    }

    public List<Event> getAllEvents() {
        return eventRepository.getAllEvents();
    }

    public Event getEventById(int eventId) {

        if (eventCache.containsKey(eventId)) {
            return eventCache.get(eventId);
        }

        Event event = eventRepository.getEventById(eventId);

        if (event != null) {
            eventCache.put(eventId, event);
        }

        return event;
    }
}