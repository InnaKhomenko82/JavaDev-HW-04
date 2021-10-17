package service.commands;

import models.Project;
import service.ProjectService;

public class HandlerCrudReadProject extends CommandHandler {
    public HandlerCrudReadProject(CommandHandler handler) {
        super(handler);
    }

    @Override
    protected void apply(String[] command) {
        System.out.println(new ProjectService().findAll(Project.class));
    }

    @Override
    protected boolean isApplicable(String[] command) {
        return ("crud".equals(command[0]) && "read".equals(command[1]) && "Project".equals(command[2]) && command.length==3);
    }
}
