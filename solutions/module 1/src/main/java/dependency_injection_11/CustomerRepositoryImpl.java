package dependency_injection_11;

public class CustomerRepositoryImpl implements CustomerRepository {
    @Override
    public String findCustomerById(int id) {
        // Simulating a database fetch
        System.out.println("Querying the database for customer ID: " + id + "...");

        // Mock data return
        if (id == 101) {
            return "Alice Smith";
        } else {
            return "Customer Not Found";
        }
    }
}
