package service.commands;

import models.Customer;
import service.CustomerService;

public class HandlerCrudReadCustomer extends CommandHandler {
    public HandlerCrudReadCustomer(CommandHandler handler) {
        super(handler);
    }

    @Override
    protected void apply(String[] command) {
        System.out.println(new CustomerService().findAll(Customer.class));
    }

    @Override
    protected boolean isApplicable(String[] command) {
        return ("crud".equals(command[0]) && "read".equals(command[1]) && "Customer".equals(command[2]) && command.length==3);
    }
}
