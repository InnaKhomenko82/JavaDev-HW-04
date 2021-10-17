package service;

import models.Developer;
import util.Digitalization;

import static controller.ConsoleController.read;

public class DeveloperService extends ServiceCrud<Developer, Long> {
    public static Developer developerBuilder(){
        String[] commandSpl = read();
        return Developer.builder()
                .id(Digitalization.getLong(commandSpl[0]))
                .name(commandSpl[1])
                .age(Digitalization.getInteger(commandSpl[2]))
                .salary(Digitalization.getInteger(commandSpl[3]))
                .build();
    }
}
