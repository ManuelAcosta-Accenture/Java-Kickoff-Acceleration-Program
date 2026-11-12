public abstract class Payment implements PaymentProcessor {

    private final double amount;

    public Payment(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException(
                    "El monto debe ser mayor que cero"
            );
        }

        this.amount = amount;
    }

    protected double getAmount() {
        return amount;
    }
}