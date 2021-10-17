package service.commands;

import lombok.SneakyThrows;
import models.dto.ProjectDto;
import service.ServiceQuery;


public class HandleQueryListOfProjects extends CommandHandler {
    public HandleQueryListOfProjects(CommandHandler handler) {
        super(handler);
    }

    @SneakyThrows
    @Override
    protected void apply(String[] command) {

       System.out.println(ServiceQuery.class
               .getDeclaredMethod(command[1], Class.class)
               .invoke(new ServiceQuery(), ProjectDto.class));
    }

    @Override
    protected boolean isApplicable(String[] command) {
        return ("query".equals(command[0]) && command.length==2);
    }
}
