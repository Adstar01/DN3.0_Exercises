package Exercise3;

public class QuickSort {
    public static void quickSort(Order[] orders, int low, int high) {
        if (low < high) {
            int pi = partition(orders, low, high);
            quickSort(orders, low, pi - 1);
            quickSort(orders, pi + 1, high);
        }
    }

    private static int partition(Order[] orders, int low, int high) {
        double pivot = orders[high].getTotalPrice();
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (orders[j].getTotalPrice() <= pivot) {
                i++;
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

    public static void main(String[] args) {
        Order[] orders = {
            new Order("001", "Alice", 250.0),
            new Order("002", "Bob", 150.0),
            new Order("003", "Charlie", 300.0),
            new Order("004", "David", 100.0)
        };


        System.out.println("Bubble Sort:");
        BubbleSort.bubbleSort(orders);
        for (Order order : orders) {
            System.out.println(order);
        }


        orders = new Order[]{
            new Order("001", "Alice", 250.0),
            new Order("002", "Bob", 150.0),
            new Order("003", "Charlie", 300.0),
            new Order("004", "David", 100.0)
        };


        System.out.println("\nQuick Sort:");
        QuickSort.quickSort(orders, 0, orders.length - 1);
        for (Order order : orders) {
            System.out.println(order);
        }
    }
}

