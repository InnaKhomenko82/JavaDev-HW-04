package service.commands;

import models.Project;
import service.ProjectService;
import util.Digitalization;

import java.util.Optional;

public class HandlerCrudReadProjectByID extends CommandHandler {
    public HandlerCrudReadProjectByID(CommandHandler handler) {
        super(handler);
    }

    @Override
    protected void apply(String[] command) {
        Optional<Project> project = new ProjectService().readById(Project.class, Digitalization.getLong(command[3]));
        System.out.println(project.isPresent()? project.get(): "No such entity((");
    }

    @Override
    protected boolean isApplicable(String[] command) {
        return ("crud".equals(command[0]) && "read".equals(command[1]) && "Project".equals(command[2]) && command.length==4);
    }
}
