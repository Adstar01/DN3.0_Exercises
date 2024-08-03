package Week_1_Exercises_Part_2.Exercise11;

import java.util.HashMap;
import java.util.Map;

public class CustomerRepositoryImpl implements CustomerRepository {
    private Map<Integer, String> customers;

    public CustomerRepositoryImpl() {
        customers = new HashMap<>();
        customers.put(1, "John Doe");
        customers.put(2, "Jane Doe");
    }

    @Override
    public String findCustomerById(int id) {
        return customers.get(id);
    }
}
