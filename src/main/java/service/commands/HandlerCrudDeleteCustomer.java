package service.commands;

import models.Customer;
import service.CustomerService;
import util.Digitalization;

import java.util.Optional;

public class HandlerCrudDeleteCustomer extends CommandHandler {
    public HandlerCrudDeleteCustomer(CommandHandler handler) {
        super(handler);
    }

    @Override
    protected void apply(String[] command) {
        Optional<Customer> customer = new CustomerService().readById(Customer.class, Digitalization.getLong(command[3]));
        if (customer.isPresent()) {
            System.out.println("Deleting entity: " + customer.get());
            new CustomerService().deleteById(Customer.class, Digitalization.getLong(command[3]));
        } else {
            System.out.println("No such entity((");
        }
    }

    @Override
    protected boolean isApplicable(String[] command) {
        return ("crud".equals(command[0]) && "delete".equals(command[1]) && "Customer".equals(command[2]) && command.length==4);
    }
}
