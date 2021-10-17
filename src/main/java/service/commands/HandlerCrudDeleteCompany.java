package service.commands;

import models.Company;
import service.CompanyService;
import util.Digitalization;

import java.util.Optional;


public class HandlerCrudDeleteCompany extends CommandHandler {
    public HandlerCrudDeleteCompany(CommandHandler handler) {
        super(handler);
    }
    @Override
    protected void apply(String[] command) {
        Optional<Company> company = new CompanyService().readById(Company.class, Digitalization.getLong(command[3]));
        if (company.isPresent()){
            System.out.println("Deleting entity: " + company.get());
            new CompanyService().deleteById(Company.class, Digitalization.getLong(command[3]));
        } else {
            System.out.println("No such entity((");
        }
    }

    @Override
    protected boolean isApplicable(String[] command) {
        return ("crud".equals(command[0]) && "delete".equals(command[1]) && "Company".equals(command[2]) && command.length==4);
    }
}