package service.commands;

import models.Project;
import service.ProjectService;

public class HandlerCrudCreateProject extends CommandHandler {
    public HandlerCrudCreateProject(CommandHandler handler) {
        super(handler);
    }

    @Override
    protected void apply(String[] command) {
        System.out.println("Enter parametr's for new project: [id|name|start|cost]");
        Project entityForCreate = ProjectService.projectBuilder();
        new ProjectService().createEntity(Project.class, entityForCreate);
        System.out.println("Created new entity: " + entityForCreate);
    }

    @Override
    protected boolean isApplicable(String[] command) {
        return ("crud".equals(command[0]) && "create".equals(command[1]) && "Project".equals(command[2]) && command.length==3);
    }
}
