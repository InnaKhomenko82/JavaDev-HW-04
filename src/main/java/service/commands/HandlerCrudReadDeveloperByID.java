package service.commands;

import models.Developer;
import service.DeveloperService;
import util.Digitalization;

import java.util.Optional;

public class HandlerCrudReadDeveloperByID extends CommandHandler {
    public HandlerCrudReadDeveloperByID(CommandHandler handler) {
        super(handler);
    }

    @Override
    protected void apply(String[] command) {
        Optional<Developer> developer = new DeveloperService().readById(Developer.class, Digitalization.getLong(command[3]));
        System.out.println(developer.isPresent() ? developer.get(): "No such entity((");
    }

    @Override
    protected boolean isApplicable(String[] command) {
        return ("crud".equals(command[0]) && "read".equals(command[1]) && "Developer".equals(command[2]) && command.length==4);
    }
}
