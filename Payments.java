public class Payments {
    public static boolean processPayment(User user, double amount) {
        // Simulate payment processing
        System.out.println("Processing payment for " + user.getName() + " of amount $" + amount);
        return true; // Assume payment is always successful
    }
}
