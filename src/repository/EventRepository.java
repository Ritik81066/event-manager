package repository;

import config.DatabaseConnection;
import models.Event;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EventRepository {

    public boolean createEvent(Event event) {

        String query = """
                INSERT INTO events
                (event_name, event_date, start_time, end_time,
                 venue_name, category_name, capacity)
                VALUES (?, ?, ?, ?, ?, ?, ?)
                """;

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, event.getEventName());
            stmt.setDate(2, Date.valueOf(event.getEventDate()));
            stmt.setTime(3, Time.valueOf(event.getStartTime()));
            stmt.setTime(4, Time.valueOf(event.getEndTime()));
            stmt.setString(5, event.getVenueName());
            stmt.setString(6, event.getCategoryName());
            stmt.setInt(7, event.getCapacity());

            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean deleteEvent(int eventId) {

        String query = "DELETE FROM events WHERE event_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, eventId);

            int rows = stmt.executeUpdate();
            return rows > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public List<Event> getAllEvents() {

        List<Event> events = new ArrayList<>();

        String query = "SELECT * FROM events";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {

                Event event = new Event();

                event.setEventId(rs.getInt("event_id"));
                event.setEventName(rs.getString("event_name"));
                event.setEventDate(rs.getDate("event_date").toLocalDate());
                event.setStartTime(rs.getTime("start_time").toLocalTime());
                event.setEndTime(rs.getTime("end_time").toLocalTime());
                event.setVenueName(rs.getString("venue_name"));
                event.setCategoryName(rs.getString("category_name"));
                event.setCapacity(rs.getInt("capacity"));

                events.add(event);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return events;
    }

    public Event getEventById(int eventId) {

        String query = "SELECT * FROM events WHERE event_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, eventId);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {

                Event event = new Event();

                event.setEventId(rs.getInt("event_id"));
                event.setEventName(rs.getString("event_name"));
                event.setEventDate(rs.getDate("event_date").toLocalDate());
                event.setStartTime(rs.getTime("start_time").toLocalTime());
                event.setEndTime(rs.getTime("end_time").toLocalTime());
                event.setVenueName(rs.getString("venue_name"));
                event.setCategoryName(rs.getString("category_name"));
                event.setCapacity(rs.getInt("capacity"));

                return event;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}