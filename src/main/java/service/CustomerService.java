package service;

import models.Customer;
import util.Digitalization;

import static controller.ConsoleController.read;

public class CustomerService extends ServiceCrud<Customer, Long> {
    public static Customer customerBuilder(){
        String[] commandSpl = read();
        return Customer.builder()
                .id(Digitalization.getLong(commandSpl[0]))
                .name(commandSpl[1])
                .category(commandSpl[2])
                .build();
    }
}
