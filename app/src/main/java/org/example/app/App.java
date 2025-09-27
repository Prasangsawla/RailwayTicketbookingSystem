package org.example.app;

import org.example.entities.Train;
import org.example.entities.user;
import org.example.services.BookingService;
import org.example.services.TrainBooking;
import org.example.services.userservice;
import org.example.util.Ids;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        TrainBooking trainService = new TrainBooking();
        userservice userService = new userservice();
        BookingService bookingService = new BookingService(trainService, userService);

        Scanner sc = new Scanner(System.in);

        System.out.println("=== Train Booking CLI ===");
        user current = null;

        while (true) {
            if (current == null) {
                System.out.println("\n1) Sign Up  2) Login  0) Exit");
                String ch = sc.nextLine().trim();
                if (ch.equals("1")) {
                    System.out.print("Name: "); String name = sc.nextLine();
                    System.out.print("Password: "); String pass = sc.nextLine();
                    current = userService.signUp(name, pass, Ids.newId());
                    System.out.println("Signed up as " + current);
                } else if (ch.equals("2")) {
                    System.out.print("Name: "); String name = sc.nextLine();
                    System.out.print("Password: "); String pass = sc.nextLine();
                    Optional<user> u = userService.login(name, pass);
                    if (u.isPresent()) {
                        current = u.get();
                        System.out.println("Logged in as " + current);
                    } else {
                        System.out.println("Login failed.");
                    }
                } else if (ch.equals("0")) {
                    System.out.println("Bye!");
                    break;
                }
            } else {
                System.out.println("\nHello, " + current.getName());
                System.out.println("1) Search trains  2) View my tickets  3) Cancel ticket  9) Logout  0) Exit");
                String ch = sc.nextLine().trim();

                if (ch.equals("1")) {
                    System.out.print("Source: "); String src = sc.nextLine();
                    System.out.print("Destination: "); String dst = sc.nextLine();
                    System.out.print("Travel date (YYYY-MM-DD): "); String dt = sc.nextLine();

                    List<Train> results = trainService.searchTrains(src, dst);
                    if (results.isEmpty()) {
                        System.out.println("No trains found.");
                        continue;
                    }
                    for (int i = 0; i < results.size(); i++) {
                        System.out.println((i+1) + ") " + results.get(i));
                    }
                    System.out.print("Choose train #: ");
                    int pick = Integer.parseInt(sc.nextLine()) - 1;
                    if (pick < 0 || pick >= results.size()) {
                        System.out.println("Invalid.");
                        continue;
                    }

                    Train chosen = results.get(pick);
                    System.out.println("Enter seat row and col (0-based):");
                    System.out.print("Row: "); int row = Integer.parseInt(sc.nextLine());
                    System.out.print("Col: "); int col = Integer.parseInt(sc.nextLine());

                    boolean ok = bookingService.bookSeat(current, chosen, row, col, src, dst, dt);
                    System.out.println(ok ? "Booked!" : "Seat not available / invalid.");
                }
                else if (ch.equals("2")) {
                    if (current.getTicketsBooked().isEmpty()) {
                        System.out.println("No tickets yet.");
                    } else {
                        current.getTicketsBooked().forEach(System.out::println);
                    }
                }
                else if (ch.equals("3")) {
                    System.out.print("Enter ticketId to cancel: ");
                    String tid = sc.nextLine();
                    boolean ok = bookingService.cancelTicket(current, tid);
                    System.out.println(ok ? "Cancelled." : "Ticket not found.");
                }
                else if (ch.equals("9")) {
                    current = null;
                }
                else if (ch.equals("0")) {
                    System.out.println("Bye!");
                    break;
                }
            }
        }
    }
}
