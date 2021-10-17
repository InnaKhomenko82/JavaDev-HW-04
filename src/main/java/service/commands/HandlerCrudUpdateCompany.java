package service.commands;

import controller.ConsoleController;
import models.Company;
import service.CompanyService;
import util.Digitalization;

import java.util.Optional;

public class HandlerCrudUpdateCompany extends CommandHandler {
    public HandlerCrudUpdateCompany(CommandHandler handler) {
        super(handler);
    }

    @Override
    protected void apply(String[] command) {
        System.out.println("Enter parametr's for update company: [id|name|quantity_staff]");
        Company entityForUpdate = CompanyService.companyBuilder();
        Optional<Company> company = new CompanyService().readById(Company.class, Digitalization.getLong(command[3]));
        if (company.isPresent()){
            System.out.println("Updating entity: " + company.get() + " on " + entityForUpdate);
            new CompanyService().updateEntity(Company.class, entityForUpdate);
        } else {
            System.out.println("No such entity((");
        }
    }

    @Override
    protected boolean isApplicable(String[] command) {
        return ("crud".equals(command[0]) && "update".equals(command[1]) && "Company".equals(command[2]) && command.length==4);
    }
}
