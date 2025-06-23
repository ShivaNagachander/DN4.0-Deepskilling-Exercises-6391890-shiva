import java.util.HashMap;
import java.util.Scanner;

class Product {
    int productId;
    String productName;
    int quantity;
    double price;

    Product(int productId, String productName, int quantity, double price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    void display() {
        System.out.println("ID: " + productId + ", Name: " + productName + 
                           ", Quantity: " + quantity + ", Price: " + price);
    }
}

class InventoryManager {
    HashMap<Integer, Product> inventory = new HashMap<>();

    void addProduct(Product p) {
        if (inventory.containsKey(p.productId)) {
            System.out.println("Product ID already exists!");
        } else {
            inventory.put(p.productId, p);
            System.out.println("Product added successfully.");
        }
    }

    void updateProduct(int id, int quantity, double price) {
        if (inventory.containsKey(id)) {
            Product p = inventory.get(id);
            p.quantity = quantity;
            p.price = price;
            System.out.println("Product updated successfully.");
        } else {
            System.out.println("Product not found.");
        }
    }

    void deleteProduct(int id) {
        if (inventory.containsKey(id)) {
            inventory.remove(id);
            System.out.println("Product deleted successfully.");
        } else {
            System.out.println("Product not found.");
        }
    }

    void displayInventory() {
        if (inventory.isEmpty()) {
            System.out.println("Inventory is empty.");
        } else {
            System.out.println("\nCurrent Inventory:");
            for (Product p : inventory.values()) {
                p.display();
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        InventoryManager manager = new InventoryManager();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Inventory Management ---");
            System.out.println("1. Add Product");
            System.out.println("2. Update Product");
            System.out.println("3. Delete Product");
            System.out.println("4. View Inventory");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter ID, Name, Quantity, Price: ");
                    int id = sc.nextInt();
                    String name = sc.next();
                    int qty = sc.nextInt();
                    double price = sc.nextDouble();
                    Product p = new Product(id, name, qty, price);
                    manager.addProduct(p);
                    break;
                case 2:
                    System.out.print("Enter ID to update: ");
                    id = sc.nextInt();
                    System.out.print("Enter new Quantity and Price: ");
                    qty = sc.nextInt();
                    price = sc.nextDouble();
                    manager.updateProduct(id, qty, price);
                    break;
                case 3:
                    System.out.print("Enter ID to delete: ");
                    id = sc.nextInt();
                    manager.deleteProduct(id);
                    break;
                case 4:
                    manager.displayInventory();
                    break;
                case 5:
                    System.out.println("Exiting system.");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 5);

        sc.close();
    }
}
