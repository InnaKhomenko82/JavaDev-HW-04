package service.commands;

public abstract class CommandHandler {

    private final CommandHandler handler;

    public CommandHandler(CommandHandler handler){
        this.handler = handler;
    }

    protected abstract void apply(String[] command);
    protected abstract boolean isApplicable(String[] command);

    public final void handle(String[] command){
        if (isApplicable(command)) apply(command);
        else handler.handle(command);
    }

    public static CommandHandler of(){
        return new HandlerCrud(
                new HandlerCrudCreateCompany(new HandlerCrudCreateCustomer(new HandlerCrudCreateDeveloper(
                new HandlerCrudCreateProject(new HandlerCrudCreateSkill(
                new HandlerCrudReadCompanyByID(new HandlerCrudReadCustomerByID(new HandlerCrudReadDeveloperByID(
                new HandlerCrudReadProjectByID(new HandlerCrudReadSkillByID(
                new HandlerCrudReadCompany(new HandlerCrudReadCustomer(new HandlerCrudReadDeveloper(
                new HandlerCrudReadProject(new HandlerCrudReadSkill(
                new HandlerCrudUpdateCompany(new HandlerCrudUpdateCustomer(new HandlerCrudUpdateDeveloper(
                new HandlerCrudUpdateProject(new HandlerCrudUpdateSkill(
                new HandlerCrudDeleteCompany(new HandlerCrudDeleteCustomer(new HandlerCrudDeleteDeveloper(
                new HandlerCrudDeleteProject(new HandlerCrudDeleteSkill(
                new HandlerQuery(new HandleQuerySalaryByProjectName(new HandleQueryListDevsInProject(
                new HandleQueryListDevsWithSkill(new HandleQueryListDevsWithLevel(
                new HandleQueryListOfProjects(
                new HandlerHelp(new HandlerExit(new HandlerException()
        ))))))))))))))))))))))))))))))))));
    }
}
