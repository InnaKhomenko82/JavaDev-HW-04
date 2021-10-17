package service.commands;

import models.Project;
import service.ProjectService;
import util.Digitalization;

import java.util.Optional;

public class HandlerCrudUpdateProject extends CommandHandler {
    public HandlerCrudUpdateProject(CommandHandler handler) {
        super(handler);
    }

    @Override
    protected void apply(String[] command) {
        System.out.println("Enter parametr's for update project: [id|name|start|cost]");
        Project entityForUpdate = ProjectService.projectBuilder();
        Optional<Project> project = new ProjectService().readById(Project.class, Digitalization.getLong(command[3]));
        if (project.isPresent()){
            System.out.println("Updating entity: " + project.get() + " on " + entityForUpdate);
            new ProjectService().updateEntity(Project.class, entityForUpdate);
        } else {
            System.out.println("No such entity((");
        }
    }

    @Override
    protected boolean isApplicable(String[] command) {
        return ("crud".equals(command[0]) && "update".equals(command[1]) && "Project".equals(command[2]) && command.length==4);
    }
}
