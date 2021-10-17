package service.commands;

public class HandlerExit extends CommandHandler {
    public HandlerExit(CommandHandler handler) {
        super(handler);
    }

    @Override
    protected void apply(String[] command) {
        System.out.println("Have a good day)))");
        System.exit(0);
    }

    @Override
    protected boolean isApplicable(String[] command) {
        return "exit".equals(command[0]);
    }
}
