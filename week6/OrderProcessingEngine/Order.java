
public class Order {
    private int id;
    private String customer;
    private String product;
    private int quantity;
    private double price;

    public Order(int id, String customer, String product,
                 int quantity, double price) {
        this.id = id;
        this.customer = customer;
        this.product = product;
        this.quantity = quantity;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public double calculateTotal() {
        double total = quantity * price;

        if (total > 5000) {
            total *= 0.90; // 10% discount
        }

        return total;
    }

    @Override
    public String toString() {
        return "Order " + id +
                " | Customer: " + customer +
                " | Product: " + product +
                " | Total: $" + calculateTotal();
    }
}
