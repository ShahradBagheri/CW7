package menu;

import entity.User;
import service.UserService;
import service.UserServiceImpl;

import java.sql.SQLException;
import java.util.Scanner;

public class Page {
    static Scanner scanner = new Scanner(System.in);
    static String[] entryMenu = {"login","signup","exit"};
    UserService userService = new UserServiceImpl();
    public void start() throws SQLException {
        Printer.printItem(entryMenu);
        String option =  scanner.nextLine();
        switch (option){
            case "1" -> login();
            case "2" -> singup();
            case "3" -> exit();
            default  -> System.out.println("not a valid option");
        }
        start();
    }
    private void login() throws SQLException {
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();
        if (userService.loginValidation(username,password))
            System.out.println("logged on");
        else
            System.out.println("Wrong password or username");
    }

    private void singup() throws SQLException {
        System.out.println("Firstname: ");
        String firstname = scanner.nextLine();
        System.out.println("Lastname: ");
        String lastname = scanner.nextLine();
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();
        System.out.println("National code: ");
        String nationalCode = scanner.nextLine();

        User user = new User(firstname,lastname,username,password,nationalCode);

        if (!userService.usernameValidation(user.getUsername()) && !userService.natCodeValidation(user.getNastionalCode()))
            userService.save(user);
        else
            System.out.println("already signed up");
    }

    private void exit(){
        System.exit(0);
    }
}