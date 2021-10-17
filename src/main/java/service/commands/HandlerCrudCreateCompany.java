package service.commands;

import models.Company;
import service.CompanyService;

public class HandlerCrudCreateCompany extends CommandHandler {
    public HandlerCrudCreateCompany(CommandHandler handler) {
        super(handler);
    }

    @Override
    protected void apply(String[] command) {
            System.out.println("Enter parametr's for new company: [id|name|quantity_staff]");
            Company entityForCreate = CompanyService.companyBuilder();
            new CompanyService().createEntity(Company.class, entityForCreate);
            System.out.println("Created new entity: " + entityForCreate);
    }

    @Override
    protected boolean isApplicable(String[] command) {
        return ("crud".equals(command[0]) && "create".equals(command[1]) && "Company".equals(command[2]) && command.length==3);
    }
}
