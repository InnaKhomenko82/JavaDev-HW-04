package service.commands;

public class HandlerQuery extends CommandHandler{

    public HandlerQuery(CommandHandler handler){
        super(handler);
    }

    @Override
    protected void apply(String[] command) {
        System.out.println("Your queries:\n" +
                "<salaryByProjectName><listDevsInProject><listDevsWithSkill><listDevsWithLevel><listOfProjects>");
    }

    @Override
    protected boolean isApplicable(String[] command) {
        return "query".equals(command[0]) && command.length==1;
    }
}
