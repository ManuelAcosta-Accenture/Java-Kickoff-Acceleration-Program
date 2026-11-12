public class CreditCardPayment extends Payment {

    public CreditCardPayment(double amount) {
        super(amount);
    }

    @Override
    public void processPayment() {
        System.out.println(
                "Procesando pago con tarjeta de crédito: $"
                        + getAmount()
        );
    }
}