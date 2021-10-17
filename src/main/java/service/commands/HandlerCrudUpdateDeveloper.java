package service.commands;

import models.Developer;
import service.DeveloperService;
import util.Digitalization;

import java.util.Optional;

public class HandlerCrudUpdateDeveloper extends CommandHandler {
    public HandlerCrudUpdateDeveloper(CommandHandler handler) {
        super(handler);
    }

    @Override
    protected void apply(String[] command) {
        System.out.println("Enter parametr's for update developer: [id|name|age|salary]");
        Developer entityForUpdate = DeveloperService.developerBuilder();
        Optional<Developer> developer = new DeveloperService().readById(Developer.class, Digitalization.getLong(command[3]));
        if (developer.isPresent()){
            System.out.println("Updating entity: " + developer.get() + " on " + entityForUpdate);
            new DeveloperService().updateEntity(Developer.class, entityForUpdate);
        } else {
            System.out.println("No such entity((");
        }
    }

    @Override
    protected boolean isApplicable(String[] command) {
        return ("crud".equals(command[0]) && "update".equals(command[1]) && "Developer".equals(command[2]) && command.length==4);
    }
}
