package service.commands;

import models.Skill;
import service.SkillService;

public class HandlerCrudReadSkill extends CommandHandler {
    public HandlerCrudReadSkill(CommandHandler handler) {
        super(handler);
    }

    @Override
    protected void apply(String[] command) {
        System.out.println(new SkillService().findAll(Skill.class));
    }

    @Override
    protected boolean isApplicable(String[] command) {
        return ("crud".equals(command[0]) && "read".equals(command[1]) && "Skill".equals(command[2]) && command.length==3);
    }
}
