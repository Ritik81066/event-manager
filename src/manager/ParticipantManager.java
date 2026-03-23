package manager;

import services.ParticipantService;
import models.Participant;

import java.util.List;

public class ParticipantManager {

    private ParticipantService participantService;

    public ParticipantManager() {
        participantService = new ParticipantService();
    }

    public void registerParticipant(int eventId, Participant participant) {

        boolean success = participantService.registerParticipant(eventId, participant);

        if (success) {
            System.out.println("Participant registered successfully.");
        } else {
            System.out.println("Registration failed.");
        }
    }

    public void removeParticipant(int eventId, int participantId) {

        boolean success = participantService.removeParticipant(eventId, participantId);

        if (success) {
            System.out.println("Participant removed.");
        } else {
            System.out.println("Participant not found.");
        }
    }

    public void viewParticipants(int eventId) {

        List<Participant> participants =
                participantService.getParticipants(eventId);

        if (participants.isEmpty()) {
            System.out.println("No participants.");
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