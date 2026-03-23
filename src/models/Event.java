package models;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.LinkedList;

public class Event {

    private int eventId;
    private String eventName;
    private LocalDate eventDate;
    private LocalTime startTime;
    private LocalTime endTime;
    private String venueName;
    private String categoryName;
    private int capacity;

    // LinkedList for participants (DSA usage)
    private LinkedList<Participant> participants;

    public Event() {
        participants = new LinkedList<>();
    }

    public Event(int eventId, String eventName, LocalDate eventDate,
                 LocalTime startTime, LocalTime endTime,
                 String venueName, String categoryName, int capacity) {

        this.eventId = eventId;
        this.eventName = eventName;
        this.eventDate = eventDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.venueName = venueName;
        this.categoryName = categoryName;
        this.capacity = capacity;
        this.participants = new LinkedList<>();
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public LocalDate getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public String getVenueName() {
        return venueName;
    }

    public void setVenueName(String venueName) {
        this.venueName = venueName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public LinkedList<Participant> getParticipants() {
        return participants;
    }


}