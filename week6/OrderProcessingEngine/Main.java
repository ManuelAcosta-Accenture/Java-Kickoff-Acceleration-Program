
import java.nio.file.*;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.*;
import java.time.LocalDateTime;

public class Main {

    public static void main(String[] args) {

        // Thread pool with 3 threads
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // Thread-safe collection
        List<String> results = new CopyOnWriteArrayList<>();

        try {
            Path path = Path.of("Week6", "orders.csv");
            List<String> lines = Files.readAllLines(path);

            // 2. Process orders concurrently
            List<Future<String>> futures = new ArrayList<>();

            for (int i = 1; i < lines.size(); i++) {
                String line = lines.get(i);

                Callable<String> task = () -> {

                    // Validate order
                    Order order = parseOrder(line);

                    // Simulate processing
                    Thread.sleep(500);

                    // Calculate total and discount
                    return order.toString();
                };

                futures.add(executor.submit(task));
            }

            // 3. Collect results
            for (Future<String> future : futures) {
                try {
                    results.add(future.get());
                } catch (ExecutionException e) {
                    System.out.println(
                            "Invalid order: " + e.getCause().getMessage()
                    );
                }
            }

            // 4. Generate report
            List<String> report = new ArrayList<>();

            report.add("ORDER PROCESSING REPORT");
            report.add("Date: " + LocalDateTime.now());
            report.add("-------------------------");
            report.addAll(results);

            Files.write(Path.of("report.txt"), report);

            System.out.println("Orders processed!");
            results.forEach(System.out::println);

            System.out.println("\nReport generated: report.txt");

        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Processing interrupted");

        } finally {
            executor.shutdown();
        }
    }

    // Convert CSV line into Order object
    public static Order parseOrder(String line)
            throws InvalidOrder {

        try {
            String[] data = line.split(",");

            int id = Integer.parseInt(data[0].trim());
            String customer = data[1].trim();
            String product = data[2].trim();
            int quantity = Integer.parseInt(data[3].trim());
            double price = Double.parseDouble(data[4].trim());

            if (id <= 0 || quantity <= 0 || price <= 0 ||
                    customer.isEmpty() || product.isEmpty()) {
                throw new InvalidOrder("Invalid order data");
            }

            return new Order(id, customer, product, quantity, price);

        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            throw new InvalidOrder("Invalid CSV format");
        }
    }
}
