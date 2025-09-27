package org.example.entities;

import java.util.ArrayList;
import java.util.List;

public class user {
    private String userId;
    private String name;
    private String hashedPassword;
    private List<ticket> ticketsBooked = new ArrayList<>();

    public user() {}

    public user(String userId, String name, String hashedPassword) {
        this.userId = userId;
        this.name = name;
        this.hashedPassword = hashedPassword;
    }

    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getHashedPassword() { return hashedPassword; }
    public void setHashedPassword(String hashedPassword) { this.hashedPassword = hashedPassword; }

    public List<ticket> getTicketsBooked() { return ticketsBooked; }
    public void setTicketsBooked(List<ticket> ticketsBooked) { this.ticketsBooked = ticketsBooked; }

    @Override public String toString() {
        return "User{" + name + ", id=" + userId + "}";
    }
}
