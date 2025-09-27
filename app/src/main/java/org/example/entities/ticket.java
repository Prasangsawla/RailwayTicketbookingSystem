package org.example.entities;

public class ticket {
    private String ticketId;
    private String userId;
    private String source;
    private String destination;
    private String dateOfTravel; // keep String for now (e.g., "2025-09-03")
    private Train train;

    public ticket() {}

    public ticket(String ticketId, String userId, String source, String destination,
                  String dateOfTravel, Train train) {
        this.ticketId = ticketId;
        this.userId = userId;
        this.source = source;
        this.destination = destination;
        this.dateOfTravel = dateOfTravel;
        this.train = train;
    }

    public String getTicketId() { return ticketId; }
    public void setTicketId(String ticketId) { this.ticketId = ticketId; }

    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }

    public String getSource() { return source; }
    public void setSource(String source) { this.source = source; }

    public String getDestination() { return destination; }
    public void setDestination(String destination) { this.destination = destination; }

    public String getDateOfTravel() { return dateOfTravel; }
    public void setDateOfTravel(String dateOfTravel) { this.dateOfTravel = dateOfTravel; }

    public Train getTrain() { return train; }
    public void setTrain(Train train) { this.train = train; }

    @Override public String toString() {
        return "Ticket{" + ticketId + " " + source + "->" + destination + " on " + dateOfTravel + "}";
    }
}
