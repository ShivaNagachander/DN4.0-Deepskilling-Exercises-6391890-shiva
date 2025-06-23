import java.util.Scanner;

class Order {
    int orderId;
    String customerName;
    double totalPrice;

    Order(int orderId, String customerName, double totalPrice) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.totalPrice = totalPrice;
    }

    void display() {
        System.out.println("Order ID: " + orderId + ", Customer: " + customerName + ", Total Price: " + totalPrice);
    }
}

public class Main {
    // Bubble Sort: O(n^2)
    public static void bubbleSort(Order[] orders) {
        int n = orders.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (orders[j].totalPrice > orders[j + 1].totalPrice) {
                    // swap
                    Order temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                }
            }
        }
    }
    // Quick Sort: O(n log n) average
    public static void quickSort(Order[] orders, int low, int high) {
        if (low < high) {
            int pi = partition(orders, low, high);
            quickSort(orders, low, pi - 1);
            quickSort(orders, pi + 1, high);
        }
    }

    private static int partition(Order[] orders, int low, int high) {
        double pivot = orders[high].totalPrice;
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (orders[j].totalPrice <= pivot) {
                i++;
                // swap
                Order temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }
        Order temp = orders[i + 1];
        orders[i + 1] = orders[high];
        orders[high] = temp;
        return i + 1;
    }

    public static void displayOrders(Order[] orders) {
        for (Order order : orders) {
            order.display();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of orders: ");
        int n = sc.nextInt();
        Order[] orders = new Order[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter Order ID, Customer Name, and Total Price: ");
            int id = sc.nextInt();
            String name = sc.next();
            double price = sc.nextDouble();
            orders[i] = new Order(id, name, price);
        }
        Order[] ordersBubble = orders.clone();
        Order[] ordersQuick = orders.clone();

        System.out.println("\n--- Sorted using Bubble Sort ---");
        bubbleSort(ordersBubble);
        displayOrders(ordersBubble);

        System.out.println("\n--- Sorted using Quick Sort ---");
        quickSort(ordersQuick, 0, n - 1);
        displayOrders(ordersQuick);

        sc.close();
    }
}
