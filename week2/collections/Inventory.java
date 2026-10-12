import java.util.LinkedList;

class Product {
    private int id;
    private String name;
    private double price;
    private int quantity;
    private int minStock;

    public Product(int id, String name, double price,
                   int quantity, int minStock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.minStock = minStock;
    }

    public int getId() {
        return id;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getMinStock() {
        return minStock;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void display() {
        IO.println("ID: " + id + "\nNombre: " + name + "\nPrecio: $" + price + "\nCantidad: " + quantity + "\nStock minimo: " + minStock
        );
    }
}

class StockMovement {
            private int productId;
            private String type;
            private int amount;

            public StockMovement(int productId, String type, int amount) {
                this.productId = productId;
                this.type = type;
                this.amount = amount;
            }

            public void display() {
                IO.println(
                        "Producto ID: " + productId + "\nTipo: " + type + "\nCantidad: " + amount
                );
            }
        }


        class Inventory {
            private LinkedList<Product> products = new LinkedList<>();
            private LinkedList<StockMovement> movements = new LinkedList<>();

            // Add
            public void addProduct(Product product) {
                if (searchProduct(product.getId()) != null) {
                    IO.println("Ya existe un producto con ese ID.");
                    return;
                }

                products.add(product);
                IO.println("Producto agregado correctamente.");
            }

            // Search
            public Product searchProduct(int id) {
                for (Product product : products) {
                    if (product.getId() == id) {
                        return product;
                    }
                }

                return null;
            }

            // Show
            public void showInventory() {
                if (products.isEmpty()) {
                    IO.println("El inventario esta vacio.");
                    return;
                }

                for (Product product : products) {
                    product.display();
                }
            }

            // Register stock
            public void stockMovement(int id, int amount, boolean entry) {
                Product product = searchProduct(id);

                if (product == null) {
                    IO.println("Producto no encontrado.");
                    return;
                }

                if (amount <= 0) {
                    IO.println("La cantidad debe ser mayor que cero.");
                    return;
                }

                int newQuantity;

                if (entry) {
                    newQuantity = product.getQuantity() + amount;
                } else {
                    if (amount > product.getQuantity()) {
                        IO.println("No hay suficiente stock.");
                        return;
                    }

                    newQuantity = product.getQuantity() - amount;
                }

                product.setQuantity(newQuantity);

                String type = entry ? "ENTRADA" : "SALIDA";
                movements.add(new StockMovement(id, type, amount));

                IO.println("Movimiento registrado correctamente.");
                IO.println("Stock actual: " + newQuantity);
            }

            // Show movement
            public void showMovements() {
                if (movements.isEmpty()) {
                    IO.println("No hay movimientos registrados.");
                    return;
                }

                for (StockMovement movement : movements) {
                    movement.display();
                    IO.println("--------------------");
                }
            }

            // Detect low stock
            public void detectLowStock() {
                boolean found = false;

                for (Product product : products) {
                    if (product.getQuantity() <= product.getMinStock()) {
                        IO.println("ALERTA: STOCK BAJO");
                        product.display();
                        found = true;
                    }
                }

                if (!found) {
                    IO.println("No hay productos con stock bajo.");
                }
            }
        }

        void main() {
            Inventory inventory = new Inventory();
            int opc;

            do {
                IO.println("""
                1. Agregar producto
                2. Mostrar inventario
                3. Buscar producto
                4. Agregar stock de un producto
                5. Quitar stock de un producto
                6. Detectar stock bajo
                7. Mostrar movimientos
                8. Salir
                """);

                opc = Integer.parseInt(IO.readln("Elige una opcion: "));

                switch (opc) {
                    case 1 -> {
                        int id = Integer.parseInt(IO.readln("ID: "));
                        String name = IO.readln("Nombre: ");
                        double price = Double.parseDouble(IO.readln("Precio: "));
                        int quantity = Integer.parseInt(IO.readln("Cantidad inicial: "));
                        int minStock = Integer.parseInt(IO.readln("Stock minimo: "));

                        if (price < 0 || quantity < 0 || minStock < 0) {
                            IO.println("Precio, cantidad y stock minimo no pueden ser negativos.");
                            break;
                        }

                        Product product = new Product(
                                id, name, price, quantity, minStock
                        );

                        inventory.addProduct(product);
                    }

                    case 2 -> inventory.showInventory();

                    case 3 -> {
                        int id = Integer.parseInt(
                                IO.readln("ID del producto a buscar: ")
                        );

                        Product product = inventory.searchProduct(id);

                        if (product != null) {
                            product.display();
                        } else {
                            IO.println("Producto no encontrado.");
                        }
                    }

                    case 4, 5 -> {
                        int id = Integer.parseInt(
                                IO.readln("ID del producto: ")
                        );

                        int amount = Integer.parseInt(
                                IO.readln("Cantidad: ")
                        );

                        inventory.stockMovement(id, amount, opc == 4);
                    }

                    case 6 -> inventory.detectLowStock();

                    case 7 -> inventory.showMovements();

                    case 8 -> IO.println("byee...");

                    default -> IO.println("Opcion no valida.");
                }

            } while (opc != 8);
        }