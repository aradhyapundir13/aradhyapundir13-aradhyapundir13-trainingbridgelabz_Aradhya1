package Consumer;

import java.util.*;
public class CustomerManagementSystem
{
    private Map<String, Consumer> customers = new HashMap<>();

    public void addCustomer(String id, String name, String email) {
        if (id == null || name == null || email == null) {
            throw new InvalidCustomerDataException("Customer data cannot be null.");
        }
        customers.put(id, new Consumer(id, name, email));
        log("Customer added: " + id);
    }

    public void updateCustomer(String id, String name, String email) throws CustomerNotFoundException {
        Consumer customer = customers.get(id);
        if (customer == null) {
            throw new CustomerNotFoundException("Customer with ID " + id + " not found.");
        }
        if (name != null) {
            customer.setName(name);
        }
        if (email != null) {
            customer.setEmail(email);
        }
        log("Customer updated: " + id);
    }

    public void deleteCustomer(String id) throws CustomerNotFoundException {
        Consumer customer = customers.remove(id);
        if (customer == null) {
            throw new CustomerNotFoundException("Customer with ID " + id + " not found.");
        }
        log("Customer deleted: " + id);
    }

    private void log(String message) {
        System.out.println("Log: " + message);
    }

    public static  void main(String[] args) {
        CustomerManagementSystem cms = new CustomerManagementSystem();
        try {
            cms.addCustomer("1", "John Doe", "john@example.com");
            cms.updateCustomer("1", "John Smith", "johnsmith@example.com");
            cms.deleteCustomer("1");
            cms.deleteCustomer("2");
        } catch (CustomerNotFoundException | InvalidCustomerDataException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}