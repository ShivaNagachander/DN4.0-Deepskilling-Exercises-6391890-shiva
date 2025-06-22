import java.util.Scanner;

class Product {
    int id;
    String name;
    String type;

    Product(int id, String name, String type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }
}

public class EcommerceSearch {
    public static Product linearSearch(Product[] products, String key) {
        for (int i = 0; i < products.length; i++) {
            if (products[i].name.equalsIgnoreCase(key)) {
                return products[i];
            }
        }
        return null;
    }

    public static Product binarySearch(Product[] products, String key) {
        int start = 0;
        int end = products.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            int cmp = products[mid].name.compareToIgnoreCase(key);

            if (cmp == 0) {
                return products[mid];
            } else if (cmp < 0) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return null;
    }

    public static void sortProducts(Product[] products) {
        int n = products.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (products[j].name.compareToIgnoreCase(products[j + 1].name) > 0) {
                    // Swap
                    Product temp = products[j];
                    products[j] = products[j + 1];
                    products[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of products: ");
        int n = sc.nextInt();
        sc.nextLine();

        Product[] items = new Product[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter product " + (i + 1) + " details:");
            System.out.print("ID: ");
            int id = sc.nextInt();
            sc.nextLine(); 
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Type: ");
            String type = sc.nextLine();

            items[i] = new Product(id, name, type);
        }

        System.out.print("\nEnter product name to search: ");
        String searchName = sc.nextLine();


        System.out.println("\n Linear Search Result:");
        Product result1 = linearSearch(items, searchName);
        if (result1 != null) {
            System.out.println("Found: " + result1.name + " (" + result1.type + ")");
        } else {
            System.out.println("Product not found.");
        }

        sortProducts(items);

        System.out.println("\nBinary Search Result on sorted products:");
        Product result2 = binarySearch(items, searchName);
        if (result2 != null) {
            System.out.println("Found: " + result2.name + " (" + result2.type + ")");
        } else {
            System.out.println("Product not found.");
        }


    }
}
