package service.commands;

public class HandlerException extends CommandHandler {

    public HandlerException(){
        super(null);
    }

    @Override
    public void apply(String [] command) {
        throw new RuntimeException("Your command is unknown((");
    }

    @Override
    protected boolean isApplicable(String [] command) {
        return true;
    }
}
