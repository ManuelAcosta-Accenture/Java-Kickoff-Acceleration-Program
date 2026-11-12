import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<PaymentProcessor> payments = List.of(
                new CreditCardPayment(1000),
                new PayPalPayment(500),
                new BankTransferPayment(2500)
        );

        for (PaymentProcessor payment : payments) {
            payment.processPayment();
        }
    }
}