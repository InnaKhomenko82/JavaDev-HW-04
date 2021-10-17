package service.commands;

import models.Customer;
import service.CustomerService;
import util.Digitalization;

import java.util.Optional;

public class HandlerCrudUpdateCustomer extends CommandHandler {
    public HandlerCrudUpdateCustomer(CommandHandler handler) {
        super(handler);
    }

    @Override
    protected void apply(String[] command) {
        System.out.println("Enter parametr's for update customer: [id|name|category]");
        Customer entityForUpdate = CustomerService.customerBuilder();
        Optional<Customer> customer = new CustomerService().readById(Customer.class, Digitalization.getLong(command[3]));
        if (customer.isPresent()){
            System.out.println("Updating entity: " + customer.get() + " on " + entityForUpdate);
            new CustomerService().updateEntity(Customer.class, entityForUpdate);
        } else {
            System.out.println("No such entity((");
        }
    }

    @Override
    protected boolean isApplicable(String[] command) {
        return ("crud".equals(command[0]) && "update".equals(command[1]) && "Customer".equals(command[2]) && command.length==4);
    }
}
