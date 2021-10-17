package service.commands;

import lombok.SneakyThrows;
import models.dto.DevWithSkillDto;
import service.ServiceQuery;

public class HandleQueryListDevsWithSkill extends CommandHandler {
    public HandleQueryListDevsWithSkill(CommandHandler handle) {
        super(handle);
    }
    @SneakyThrows
    @Override
    protected void apply(String[] command) {
        System.out.println(ServiceQuery.class
                .getDeclaredMethod(command[1], String.class, Class.class)
                .invoke(new ServiceQuery(), command[2], DevWithSkillDto.class));
    }

    @Override
    protected boolean isApplicable(String[] command) {
        return ("query".equals(command[0])&& "listDevsWithSkill".equals(command[1]) && command.length==3);
    }
}
