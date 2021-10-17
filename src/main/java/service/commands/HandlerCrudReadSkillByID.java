package service.commands;

import models.Skill;
import service.SkillService;
import util.Digitalization;

import java.util.Optional;

public class HandlerCrudReadSkillByID extends CommandHandler {
    public HandlerCrudReadSkillByID(CommandHandler handler) {
        super(handler);
    }

    @Override
    protected void apply(String[] command) {
        Optional<Skill> skill = new SkillService().readById(Skill.class, Digitalization.getLong(command[3]));
        System.out.println(skill.isPresent() ? skill.get(): "No such entity((");
    }

    @Override
    protected boolean isApplicable(String[] command) {
        return ("crud".equals(command[0]) && "read".equals(command[1]) && "Skill".equals(command[2]) && command.length==4);
    }
}
