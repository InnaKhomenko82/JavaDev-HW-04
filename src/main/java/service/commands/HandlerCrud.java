package service.commands;

public class HandlerCrud  extends CommandHandler{

    public HandlerCrud(CommandHandler handler) {
        super(handler);
    }

    @Override
    protected void apply(String[] command) {
        System.out.println("Commands: create|read|update|delete");
        System.out.println("Tables: Company|Customer|Developer|Project|Skill");
    }

    @Override
    protected boolean isApplicable(String[] command) {
        return "crud".equals(command[0]) && command.length==1;
    }
}
