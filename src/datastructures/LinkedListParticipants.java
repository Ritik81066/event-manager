package datastructures;

import models.Participant;

public class LinkedListParticipants {

    private static class Node {

        Participant data;
        Node next;

        Node(Participant data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;

    public void addParticipant(Participant p) {

        Node newNode = new Node(p);

        if (head == null) {
            head = newNode;
            return;
        }

        Node temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;
    }

    public void displayParticipants() {

        Node temp = head;

        while (temp != null) {

            System.out.println(temp.data.getName());
            temp = temp.next;
        }
    }

    public boolean removeParticipant(int participantId) {

        Node temp = head;
        Node prev = null;

        while (temp != null) {

            if (temp.data.getParticipantId() == participantId) {

                if (prev == null) {
                    head = temp.next;
                } else {
                    prev.next = temp.next;
                }

                return true;
            }

            prev = temp;
            temp = temp.next;
        }

        return false;
    }
}