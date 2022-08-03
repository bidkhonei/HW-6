package service;

import com.sun.jdi.request.MethodExitRequest;
import domain.User;
import repo.userRepo;
import java.sql.SQLException;
import java.util.Scanner;


public class AppObject {

//This class is created to set up the main menu for printing menus//
    public static final String[] inputMenu = {" 1-login ", " 2-signin ", " 3-exit "};
    public static final String[] insideMenu = {" 1-Summary of your articles", " 2-addArticle",
            " 3-Change your Password", " 4-edit Article ", " 5-show Article ", " 6-exit"};
//A method to print the menu//
    public void printMenu(String[] menu) {
        for (int i = 0; i < menu.length; i++) {
            System.out.println(menu[i]);
        }
    }

//Primary menu method
    public void Primary() throws SQLException {

        while (true) {
            printMenu(inputMenu);
            System.out.println("Enter Number:");
            Scanner scanner = new Scanner(System.in);
            int menus = 0;
            try {
               menus= CheckTYPE.CheckType(scanner);
            } catch (Exception e) {
                e.printStackTrace();
            }

            if (menus == 1) {
                Login login = new Login();
                login.login(1);
                break;
            }

            if (menus == 2) {

                System.out.println(" enter Your User_name");
                String username = scanner.next();
                System.out.println(" enter nationalCode ");
                String nationalCode = scanner.next();
                System.out.println(" enter birthday");
                String birthday = scanner.next();
                User user1 = new User(username, nationalCode, birthday, nationalCode);
                userRepo.insert(user1);

                System.out.println("You are a member,PASSWORD:nationalCode");

            }
            if (menus == 3) {
                continue;
            }
            if (menus != 3 & menus != 2 & menus != 1) {
                System.out.println("Warning: Do not take a nap");

            }
        }
    }
}