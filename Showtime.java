import java.time.LocalDateTime;

public class Showtime {
    private Movie movie;
    private LocalDateTime dateTime;
    private int availableSeats;

    public Showtime(Movie movie, LocalDateTime dateTime, int availableSeats) {
        this.movie = movie;
        this.dateTime = dateTime;
        this.availableSeats = availableSeats;
    }

    public Movie getMovie() {
        return movie;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void bookSeat() {
        if (availableSeats > 0) {
            availableSeats--;
        } else {
            throw new IllegalStateException("No available seats");
        }
    }

    @Override
    public String toString() {
        return "Showtime{" +
                "movie=" + movie +
                ", dateTime=" + dateTime +
                ", availableSeats=" + availableSeats +
                '}';
    }
}
