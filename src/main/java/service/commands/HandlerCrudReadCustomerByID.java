package service.commands;

import models.Customer;
import service.CustomerService;
import util.Digitalization;

import java.util.Optional;

public class HandlerCrudReadCustomerByID extends CommandHandler {
    public HandlerCrudReadCustomerByID(CommandHandler handler) {
        super(handler);
    }

    @Override
    protected void apply(String[] command) {
        Optional<Customer> customer = new CustomerService().readById(Customer.class, Digitalization.getLong(command[3]));
        System.out.println(customer.isPresent() ? customer.get() : "No such entity((");
    }

    @Override
    protected boolean isApplicable(String[] command) {
        return ("crud".equals(command[0]) && "read".equals(command[1]) && "Customer".equals(command[2]) && command.length==4);
    }
}
