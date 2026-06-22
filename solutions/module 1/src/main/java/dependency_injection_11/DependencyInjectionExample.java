package dependency_injection_11;

public class DependencyInjectionExample {
    public static void main(String[] args) {
        System.out.println("--- Customer Management System Initialized ---\n");

        // 1. Create the concrete dependency (Low-level module)
        CustomerRepository repository = new CustomerRepositoryImpl();

        // 2. Inject the dependency into the service (High-level module)
        CustomerService customerService = new CustomerService(repository);

        // 3. Use the service
        customerService.displayCustomerDetails(101);

        System.out.println("\n-----------------------------------\n");

        customerService.displayCustomerDetails(999);
    }
}