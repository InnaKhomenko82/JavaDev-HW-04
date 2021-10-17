package service.commands;

public class HandlerHelp extends CommandHandler {
    public HandlerHelp(CommandHandler handler) {
        super(handler);
    }

    @Override
    protected void apply(String[] command) {
        System.out.println("Команды из раздела CRUD позволяют выполнять операции CREATE, READ, UPDATE, DELETE\n" +
                "crud\n" +
                "crud|create|Company\n"+
                "5|CompanyX|10\n" +
                "6|CompanyY|100\n" +
                "7|CompanyZ|1000\n" +
                "\n" +
                "crud|create|Customer\n" +
                "4|CustomerX|lost\n" +
                "\n" +
                "crud|create|Developer\n" +
                "5|DeveloperX|48|600\n" +
                "\n" +
                "crud|create|Project\n" +
                "5|ProjectX|19.05.2021|5000\n" +
                "\n" +
                "crud|create|Skill\n" +
                "5|HTML|middle\n" +
                "\n" +
                "crud|read|Company\n" +
                "crud|read|Company|2\n" +
                "crud|read|Customer\n" +
                "crud|read|Customer|2\n" +
                "crud|read|Developer\n" +
                "crud|read|Developer|2\n" +
                "crud|read|Project\n" +
                "crud|read|Project|3\n" +
                "crud|read|Skill\n" +
                "crud|read|Skill|2\n" +
                "\n" +
                "crud|update|Company|5\n" +
                "crud|update|Customer|4\n" +
                "crud|update|Developer|5\n" +
                "crud|update|Project|5\n" +
                "crud|update|Skill|5\n" +
                "\n" +
                "crud|delete|Company|5\n" +
                "crud|delete|Customer|4\n" +
                "crud|delete|Developer|5\n" +
                "crud|delete|Project|5\n" +
                "crud|delete|Skill|5\n" +
                "\n" +
                "Команды из раздела QUERY вывести:\n" +
                "salaryByProjectName\n" +
                "зарплату(сумму) всех разработчиков отдельного проекта;\n" +
                "listDevsInProject\n" +
                "список разработчиков отдельного проекта;\n" +
                "listDevsWithSkill\n" +
                "список всех Java разработчиков;\n" +
                "listDevsWithLevel\n" +
                "список всех middle разработчиков;\n" +
                "listOfProjects\n" +
                "список проектов в следующем формате: дата создания - название проекта - количество разработчиков на этом проекте.");
    }

    @Override
    protected boolean isApplicable(String[] command) {
        return "help".equals(command[0]);
    }
}
