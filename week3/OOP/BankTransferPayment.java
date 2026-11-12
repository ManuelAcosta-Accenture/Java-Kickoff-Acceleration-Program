public class BankTransferPayment extends Payment {

    public BankTransferPayment(double amount) {
        super(amount);
    }

    @Override
    public void processPayment() {
        System.out.println(
                "Procesando transferencia bancaria: $"
                        + getAmount()
        );
    }
}