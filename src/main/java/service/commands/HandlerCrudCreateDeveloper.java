package service.commands;

import models.Developer;
import service.DeveloperService;

public class HandlerCrudCreateDeveloper extends CommandHandler {
    public HandlerCrudCreateDeveloper(CommandHandler handler) {
        super(handler);
    }

    @Override
    protected void apply(String[] command) {
        System.out.println("Enter parametr's for new developer: [id|name|age|salary]");
        Developer entityForCreate = DeveloperService.developerBuilder();
        new DeveloperService().createEntity(Developer.class, entityForCreate);
        System.out.println("Created new entity: " + entityForCreate);
    }

    @Override
    protected boolean isApplicable(String[] command) {
        return ("crud".equals(command[0]) && "create".equals(command[1]) && "Developer".equals(command[2]) && command.length==3);
    }
}
