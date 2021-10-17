package service.commands;

import lombok.SneakyThrows;
import models.dto.SalaryByProjectNameDto;
import service.ServiceQuery;


public class HandleQuerySalaryByProjectName extends CommandHandler {
    public HandleQuerySalaryByProjectName(CommandHandler handler) {
        super(handler);
    }

    @SneakyThrows
    @Override
    protected void apply(String[] command) {

        System.out.println(ServiceQuery.class
                .getDeclaredMethod(command[1], String.class, Class.class)
                .invoke(new ServiceQuery(), command[2], SalaryByProjectNameDto.class));
    }

    @Override
    protected boolean isApplicable(String[] command) {
        return ("query".equals(command[0]) && "salaryByProjectName".equals(command[1]) && command.length==3);
    }
}
