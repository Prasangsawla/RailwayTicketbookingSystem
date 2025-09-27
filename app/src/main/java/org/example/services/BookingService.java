package org.example.services;

import org.example.entities.ticket;
import org.example.entities.Train;
import org.example.entities.user;
import org.example.util.Ids;

import java.util.List;

public class BookingService {
    private final TrainBooking trainService;
    private final userservice userService;

    public BookingService(TrainBooking trainService, userservice userService) {
        this.trainService = trainService;
        this.userService = userService;
    }

    public boolean bookSeat(user user, Train train, int row, int col,
                            String source, String destination, String dateOfTravel) {
        List<List<Integer>> seats = train.getseat();

        if (row < 0 || row >= seats.size()) return false;
        if (col < 0 || col >= seats.get(row).size()) return false;

        if (seats.get(row).get(col) == 1) return false; // already booked

        // mark as booked
        seats.get(row).set(col, 1);
        train.setSeat(seats);
        trainService.upsertTrain(train);

        // create ticket
        ticket t = new ticket(
                Ids.newId(),
                user.getUserId(),
                source,
                destination,
                dateOfTravel,
                train
        );
        user.getTicketsBooked().add(t);
        userService.update(user);

        return true;
    }

    public boolean cancelTicket(user user, String ticketId) {
        boolean removed = user.getTicketsBooked()
                .removeIf(t -> t.getTicketId().equalsIgnoreCase(ticketId));
        if (removed) {
            userService.update(user);
        }
        return removed;
    }
}
