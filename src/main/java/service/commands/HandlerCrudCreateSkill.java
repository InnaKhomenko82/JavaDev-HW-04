package service.commands;

import models.Skill;
import service.SkillService;

public class HandlerCrudCreateSkill extends CommandHandler {
    public HandlerCrudCreateSkill(CommandHandler handler) {
        super(handler);
    }

    @Override
    protected void apply(String[] command) {
        System.out.println("Enter parametr's for new skill: [id|field|level]");
        Skill entityForCreate = SkillService.skillBuilder();
        new SkillService().createEntity(Skill.class, entityForCreate);
        System.out.println("Created new entity: " + entityForCreate);
    }

    @Override
    protected boolean isApplicable(String[] command) {
        return ("crud".equals(command[0]) && "create".equals(command[1]) && "Skill".equals(command[2]) && command.length==3);
    }
}
