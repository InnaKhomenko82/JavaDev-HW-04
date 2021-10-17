package service.commands;

import models.Company;
import service.CompanyService;
import util.Digitalization;

import java.util.Optional;

public class HandlerCrudReadCompanyByID extends CommandHandler {
    public HandlerCrudReadCompanyByID(CommandHandler handler) {
        super(handler);
    }

    @Override
    protected void apply(String[] command) {
        Optional<Company> company = new CompanyService().readById(Company.class, Digitalization.getLong(command[3]));
        System.out.println(company.isPresent() ? company.get()  : "No such entity((");
    }

    @Override
    protected boolean isApplicable(String[] command) {
        return ("crud".equals(command[0]) && "read".equals(command[1]) && "Company".equals(command[2]) && command.length==4);
    }
}
