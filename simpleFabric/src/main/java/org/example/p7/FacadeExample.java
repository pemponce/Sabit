package org.example.p7;

class TicketAvailabilityService {

    public boolean checkAvailability(String trainNumber, String date) {
        System.out.println("Checking availability for train " + trainNumber + " on date " + date);
        return true;
    }
}

class ReservationService {

    public String reserveTicket(String trainNumber, String passengerName) {
        System.out.println(
                "Reserving ticket for train " + trainNumber + " for passenger " + passengerName);
        return "RES12345";
    }

    public void unReserveTicket(String trainNumber, String passengerName) {
        System.out.println(
                "Unreserving ticket for train " + trainNumber + " for passenger " + passengerName);
    }
}

class PaymentService {

    public boolean processPayment(String reservationId, double amount) {
        System.out.println(
                "Processing payment for reservation " + reservationId + " of amount " + amount);
        return true;
    }
}

class TicketBookingFacade {

    private final TicketAvailabilityService availabilityService = new TicketAvailabilityService();
    private final ReservationService reservationService = new ReservationService();
    private final PaymentService paymentService = new PaymentService();

    public void bookTicket(String trainNumber, String date, String passengerName, double amount) {
        if (!availabilityService.checkAvailability(trainNumber, date)) {
            System.out.println("Tickets are not available for the selected train and date.");
            return;
        }
        String reservationId = reservationService.reserveTicket(trainNumber, passengerName);
        if (paymentService.processPayment(reservationId, amount)) {
            System.out.println("Ticket booked successfully with reservation ID: " + reservationId);
        } else {
            reservationService.unReserveTicket(trainNumber, passengerName);
            System.out.println("Payment failed. Could not complete the booking.");
        }
    }
}

public class FacadeExample {

    public static void main(String[] args) {
        TicketBookingFacade bookingFacade = new TicketBookingFacade();
        bookingFacade.bookTicket("123A", "2024-12-25", "John Doe", 50.0);
    }
}