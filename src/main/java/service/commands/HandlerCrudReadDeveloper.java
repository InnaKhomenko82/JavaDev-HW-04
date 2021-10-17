package service.commands;

import models.Developer;
import service.DeveloperService;

public class HandlerCrudReadDeveloper extends CommandHandler {
    public HandlerCrudReadDeveloper(CommandHandler handler) {
        super(handler);
    }

    @Override
    protected void apply(String[] command) {
        System.out.println(new DeveloperService().findAll(Developer.class));
    }

    @Override
    protected boolean isApplicable(String[] command) {
        return ("crud".equals(command[0]) && "read".equals(command[1]) && "Developer".equals(command[2]) && command.length==3);
    }
}
