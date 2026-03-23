package repository;

import config.DatabaseConnection;
import models.Participant;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ParticipantRepository {

    public boolean createParticipant(Participant participant) {

        String query = """
                INSERT INTO participants (name, email)
                VALUES (?, ?)
                """;

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, participant.getName());
            stmt.setString(2, participant.getEmail());

            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean registerParticipant(int eventId, int participantId) {

        String query = """
                INSERT INTO registrations (event_id, participant_id)
                VALUES (?, ?)
                """;

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, eventId);
            stmt.setInt(2, participantId);

            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public List<Participant> getParticipantsByEvent(int eventId) {

        List<Participant> participants = new ArrayList<>();

        String query = """
                SELECT p.participant_id, p.name, p.email
                FROM participants p
                JOIN registrations r
                ON p.participant_id = r.participant_id
                WHERE r.event_id = ?
                """;

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, eventId);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                Participant p = new Participant();

                p.setParticipantId(rs.getInt("participant_id"));
                p.setName(rs.getString("name"));
                p.setEmail(rs.getString("email"));

                participants.add(p);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return participants;
    }
}