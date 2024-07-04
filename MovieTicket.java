import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MovieTicket {
    private static List<Movie> movies = new ArrayList<>();
    private static List<Showtime> showtimes = new ArrayList<>();
    private static List<Booking> bookings = new ArrayList<>();

    public static void main(String[] args) {
        // Sample data
        movies.add(new Movie("Inception", "Sci-Fi", 148));
        movies.add(new Movie("The Godfather", "Crime", 175));

        showtimes.add(new Showtime(movies.get(0), LocalDateTime.now().plusDays(1), 100));
        showtimes.add(new Showtime(movies.get(1), LocalDateTime.now().plusDays(2), 50));

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Browse Movies");
            System.out.println("2. View Showtimes");
            System.out.println("3. Book Tickets");
            System.out.println("4. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    browseMovies();
                    break;
                case 2:
                    viewShowtimes();
                    break;
                case 3:
                    bookTickets(scanner);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void browseMovies() {
        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }

    private static void viewShowtimes() {
        for (Showtime showtime : showtimes) {
            System.out.println(showtime);
        }
    }

    private static void bookTickets(Scanner scanner) {
        System.out.println("Enter your name:");
        String name = scanner.nextLine();
        System.out.println("Enter your email:");
        String email = scanner.nextLine();
        User user = new User(name, email);

        System.out.println("Select a showtime (index):");
        for (int i = 0; i < showtimes.size(); i++) {
            System.out.println(i + ". " + showtimes.get(i));
        }
        int showtimeIndex = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (showtimeIndex < 0 || showtimeIndex >= showtimes.size()) {
            System.out.println("Invalid showtime selected.");
            return;
        }

        Showtime showtime = showtimes.get(showtimeIndex);
        System.out.println("Enter number of seats to book:");
        int numberOfSeats = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (numberOfSeats <= 0 || numberOfSeats > showtime.getAvailableSeats()) {
            System.out.println("Invalid number of seats.");
            return;
        }

        if (Payment.processPayment(user, numberOfSeats * 10)) { // Assume $10 per seat
            for (int i = 0; i < numberOfSeats; i++) {
                showtime.bookSeat();
            }
            Booking booking = new Booking(user, showtime, numberOfSeats);
            bookings.add(booking);
            System.out.println("Booking successful: " + booking);
        } else {
            System.out.println("Payment failed.");
        }
    }
}
