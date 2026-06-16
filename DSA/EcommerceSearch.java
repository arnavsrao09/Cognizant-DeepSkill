package DSA;

import java.util.Arrays;
import java.util.Comparator;

class Product {
    int productId;
    String productName;
    String category;

    Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    @Override
    public String toString() {
        return productId + " - " + productName + " (" + category + ")";
    }
}

public class EcommerceSearch {

    // Linear Search
    public static Product linearSearch(Product[] products, String target) {
        for (Product product : products) {
            if (product.productName.equalsIgnoreCase(target)) {
                return product;
            }
        }
        return null;
    }

    // Binary Search
    public static Product binarySearch(Product[] products, String target) {
        int left = 0;
        int right = products.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            int comparison =
                    products[mid].productName.compareToIgnoreCase(target);

            if (comparison == 0)
                return products[mid];
            else if (comparison < 0)
                left = mid + 1;
            else
                right = mid - 1;
        }

        return null;
    }

    public static void main(String[] args) {

        Product[] products = {
                new Product(101, "Laptop", "Electronics"),
                new Product(102, "Phone", "Electronics"),
                new Product(103, "Keyboard", "Accessories"),
                new Product(104, "Mouse", "Accessories"),
                new Product(105, "Monitor", "Electronics")
        };

        // Linear Search
        Product result1 = linearSearch(products, "Mouse");
        System.out.println("Linear Search Result:");
        System.out.println(result1);

        // Sort array before Binary Search
        Arrays.sort(products,
                Comparator.comparing(p -> p.productName));

        Product result2 = binarySearch(products, "Mouse");
        System.out.println("\nBinary Search Result:");
        System.out.println(result2);
    }
}