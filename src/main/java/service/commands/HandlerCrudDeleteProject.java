package service.commands;

import models.Project;
import service.ProjectService;
import util.Digitalization;

import java.util.Optional;

public class HandlerCrudDeleteProject extends CommandHandler {
    public HandlerCrudDeleteProject(CommandHandler handler) {
        super(handler);
    }

    @Override
    protected void apply(String[] command) {
        Optional<Project> project = new ProjectService().readById(Project.class, Digitalization.getLong(command[3]));
        if (project.isPresent()) {
            System.out.println("Deleting entity: " + project.get());
            new ProjectService().deleteById(Project.class, Digitalization.getLong(command[3]));
        } else {
            System.out.println("No such entity((");
        }
    }

    @Override
    protected boolean isApplicable(String[] command) {
        return ("crud".equals(command[0]) && "delete".equals(command[1]) && "Project".equals(command[2]) && command.length==4);
    }
}
