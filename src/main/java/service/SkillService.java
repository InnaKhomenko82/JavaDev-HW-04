package service;

import models.Skill;
import util.Digitalization;

import static controller.ConsoleController.read;

public class SkillService extends ServiceCrud<Skill, Long> {
    public static Skill skillBuilder(){
        String[] commandSpl = read();
        return Skill.builder()
                .id(Digitalization.getLong(commandSpl[0]))
                .skillsField(commandSpl[1])
                .skillsLevel(commandSpl[2])
                .build();
    }
}
