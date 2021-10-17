package service.commands;

import models.Developer;
import service.DeveloperService;
import util.Digitalization;

import java.util.Optional;

public class HandlerCrudDeleteDeveloper extends CommandHandler {
    public HandlerCrudDeleteDeveloper(CommandHandler handler) {
        super(handler);
    }

    @Override
    protected void apply(String[] command) {
        Optional<Developer> developer = new DeveloperService().readById(Developer.class, Digitalization.getLong(command[3]));
        if (developer.isPresent()) {
            System.out.println("Deleting entity: " + developer.get());
            new DeveloperService().deleteById(Developer.class, Digitalization.getLong(command[3]));
        } else {
            System.out.println("No such entity((");
        }
    }

    @Override
    protected boolean isApplicable(String[] command) {
        return ("crud".equals(command[0]) && "delete".equals(command[1]) && "Developer".equals(command[2]) && command.length==4);
    }
}
