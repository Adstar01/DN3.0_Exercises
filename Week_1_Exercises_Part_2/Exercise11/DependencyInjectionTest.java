package Week_1_Exercises_Part_2.Exercise11;

public class DependencyInjectionTest {
    public static void main(String[] args) {
        CustomerRepository customerRepository = new CustomerRepositoryImpl();

        CustomerService customerService = new CustomerService(customerRepository);

        System.out.println("Customer with ID 1: " + customerService.getCustomerById(1));
        System.out.println("Customer with ID 2: " + customerService.getCustomerById(2));
        System.out.println("Customer with ID 3: " + customerService.getCustomerById(3));
    }
}

