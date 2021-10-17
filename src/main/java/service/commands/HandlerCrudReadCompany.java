package service.commands;

import lombok.SneakyThrows;
import models.Company;
import service.CompanyService;

public class HandlerCrudReadCompany extends CommandHandler {
    public HandlerCrudReadCompany(CommandHandler handler) {
        super(handler);
    }

    @SneakyThrows
    @Override
    protected void apply(String[] command) {
       System.out.println(new CompanyService().findAll(Company.class));
    }

    @Override
    protected boolean isApplicable(String[] command) {
        return ("crud".equals(command[0]) && "read".equals(command[1]) && "Company".equals(command[2]) && command.length==3);
    }
}
