package service;

import models.Project;
import util.Digitalization;

import static controller.ConsoleController.read;

public class ProjectService extends ServiceCrud<Project, Long>  {
    public static Project projectBuilder(){
        String[] commandSpl = read();
        return Project.builder()
                .id(Digitalization.getLong(commandSpl[0]))
                .name(commandSpl[1])
                .projectStart(Digitalization.getDate(commandSpl[2]))
                .cost(Digitalization.getInteger(commandSpl[3]))
                .build();
    }
}
