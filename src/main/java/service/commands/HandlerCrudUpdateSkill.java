package service.commands;

import models.Skill;
import service.SkillService;
import util.Digitalization;

import java.util.Optional;

public class HandlerCrudUpdateSkill extends CommandHandler {
    public HandlerCrudUpdateSkill(CommandHandler handler) {
        super(handler);
    }

    @Override
    protected void apply(String[] command) {
        System.out.println("Enter parametr's for update skill: [id|field|level]");
        Skill entityForUpdate = SkillService.skillBuilder();
        Optional<Skill> skill = new SkillService().readById(Skill.class, Digitalization.getLong(command[3]));
        if (skill.isPresent()){
            System.out.println("Updating entity: " + skill.get() + " on " + entityForUpdate);
            new SkillService().updateEntity(Skill.class, entityForUpdate);
        } else {
            System.out.println("No such entity((");
        }
    }

    @Override
    protected boolean isApplicable(String[] command) {
        return ("crud".equals(command[0]) && "update".equals(command[1]) && "Skill".equals(command[2]) && command.length==4);
    }
}
