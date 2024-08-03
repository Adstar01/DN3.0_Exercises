package Week_1_Exercises_Part_2.Exercise11;

public class CustomerService {
    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public String getCustomerById(int id) {
        return customerRepository.findCustomerById(id);
    }
}

