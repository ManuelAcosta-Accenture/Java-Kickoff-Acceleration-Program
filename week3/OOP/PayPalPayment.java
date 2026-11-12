public class PayPalPayment extends Payment {

    public PayPalPayment(double amount) {
        super(amount);
    }

    @Override
    public void processPayment() {
        System.out.println(
                "Procesando pago con PayPal: $"
                        + getAmount()
        );
    }
}