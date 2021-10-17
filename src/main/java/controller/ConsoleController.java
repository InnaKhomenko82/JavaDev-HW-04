package controller;

import service.commands.CommandHandler;

import java.util.Scanner;

public class ConsoleController{
    private static final Scanner scanner = new Scanner(System.in);

    public static void mainMenu() {
            System.out.println("Hello, friend!");
            while (true) {
            System.out.println("Choose your command ('crud' or 'query'), 'help' or 'exit':");
            CommandHandler.of().handle(read());
        }
    }

    public static String[] read(){
        String command = scanner.next();
        return command.split("\\|");
    }
}
