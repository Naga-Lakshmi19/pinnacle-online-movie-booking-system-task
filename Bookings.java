public class Bookings {
    private User user;
    private Showtime showtime;
    private int numberOfSeats;

    public Booking(User user, Showtime showtime, int numberOfSeats) {
        this.user = user;
        this.showtime = showtime;
        this.numberOfSeats = numberOfSeats;
    }

    public User getUser() {
        return user;
    }

    public Showtime getShowtime() {
        return showtime;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "user=" + user +
                ", showtime=" + showtime +
                ", numberOfSeats=" + numberOfSeats +
                '}';
    }
}
