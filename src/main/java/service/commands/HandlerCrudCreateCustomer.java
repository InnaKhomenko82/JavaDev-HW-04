package service.commands;

import models.Customer;
import service.CustomerService;

public class HandlerCrudCreateCustomer extends CommandHandler {
    public HandlerCrudCreateCustomer(CommandHandler handler) {
        super(handler);
    }

    @Override
    protected void apply(String[] command) {
        System.out.println("Enter parametr's for new customer: [id|name|category]");
        Customer entityForCreate = CustomerService.customerBuilder();
        new CustomerService().createEntity(Customer.class, entityForCreate);
        System.out.println("Created new entity: " + entityForCreate);
    }

    @Override
    protected boolean isApplicable(String[] command) {
        return ("crud".equals(command[0]) && "create".equals(command[1]) && "Customer".equals(command[2]) && command.length==3);
    }
}
