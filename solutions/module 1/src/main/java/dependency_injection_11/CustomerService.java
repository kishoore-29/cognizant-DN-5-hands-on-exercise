package dependency_injection_11;

public class CustomerService {
    // Relying on the abstraction, not the concrete implementation
    private final CustomerRepository customerRepository;

    // Dependency Injection via Constructor
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    // Business logic method
    public void displayCustomerDetails(int id) {
        System.out.println("Fetching details for Customer ID " + id + "...");
        String customerName = customerRepository.findCustomerById(id);
        System.out.println("Result: " + customerName);
    }
}