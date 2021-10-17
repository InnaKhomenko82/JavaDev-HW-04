package service.commands;

import lombok.SneakyThrows;
import models.dto.DevWithLevelDto;
import service.ServiceQuery;

public class HandleQueryListDevsWithLevel extends CommandHandler {
    public HandleQueryListDevsWithLevel(CommandHandler handler) {
        super(handler);
    }
    @SneakyThrows
    @Override
    protected void apply(String[] command) {
        System.out.println(ServiceQuery.class
                .getDeclaredMethod(command[1], String.class, Class.class)
                .invoke(new ServiceQuery(), command[2], DevWithLevelDto.class));
    }

    @Override
    protected boolean isApplicable(String[] command) {
        return ("query".equals(command[0])&& "listDevsWithLevel".equals(command[1]) && command.length==3);
    }
}
