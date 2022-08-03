package service;

import repo.userRepo;

import java.sql.SQLException;

import java.util.Scanner;

public class Login {
    public static Scanner scanner = new Scanner(System.in);
    public static String uss;

    public static void login(int menus) throws SQLException {
        if (menus == 1) {

            System.out.println(" Enter UserName??");
            uss = scanner.next();
            boolean userName = userRepo.loadById(uss);
            System.out.println(" Enter password??");
            boolean passWord = userRepo.loadByPassWord(scanner.next());

            if (passWord == (true) && userName == (true)) {
                Main_menu main_menu = new Main_menu();
                main_menu.mainMenu();
            } else if (passWord == (false) && userName == (true)) {
                System.out.println("""
                        Your password is wrong
                        ......................
                        """);
                login(1);

            } else if (passWord == (true) && userName == (false)) {
                System.out.println("""
                        User with this ID not found
                        ...........................
                        """);
                login(1);
            }

        }
    }

    public static String getUss() {
        return uss;
    }
}