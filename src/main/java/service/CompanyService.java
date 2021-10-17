package service;

import models.Company;
import util.Digitalization;

import static controller.ConsoleController.read;

public class CompanyService extends ServiceCrud<Company, Long> {
    public static Company companyBuilder(){
        String[] commandSpl = read();;
        return Company.builder()
                .id(Digitalization.getLong(commandSpl[0]))
                .name(commandSpl[1])
                .quantityStaff(Digitalization.getLong(commandSpl[2]))
                .build();
    }
}
