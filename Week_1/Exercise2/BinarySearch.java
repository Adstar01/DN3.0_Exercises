package Exercise2;

import java.util.Arrays;
import java.util.Comparator;

public class BinarySearch {
    public static Product binarySearch(Product[] products, String targetProductId) {
        int left = 0;
        int right = products.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = products[mid].getProductId().compareTo(targetProductId);
            if (comparison == 0) {
                return products[mid];
            }
            if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Product[] products = {
            new Product("001", "Laptop", "Electronics"),
            new Product("002", "Smartphone", "Electronics"),
            new Product("003", "Tablet", "Electronics")
        };

        Arrays.sort(products, Comparator.comparing(Product::getProductId));

        Product foundProduct = LinearSearch.linearSearch(products, "002");
        System.out.println("Linear Search - Found Product: " + (foundProduct != null ? foundProduct.getProductName() : "Not found"));

        foundProduct = binarySearch(products, "002");
        System.out.println("Binary Search - Found Product: " + (foundProduct != null ? foundProduct.getProductName() : "Not found"));
    }
}

