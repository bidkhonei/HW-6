package service;

import domain.User;
import repo.userRepo;

import java.sql.SQLException;
import java.util.Scanner;

import static service.Login.scanner;
import static service.Login.uss;

public class Main_menu {
    public void mainMenu() throws SQLException {
        {
            while (true) {
                System.out.println("""
                        wellcom
                        ....... """);
                Scanner scanner3 = new Scanner(System.in);
                AppObject appObject = new AppObject();
                appObject.printMenu(AppObject.insideMenu);
                System.out.println("Enter number");
                int menus2;
                menus2 = scanner3.nextInt();
                User user;

                if (menus2 == 1) {
                    System.out.println("""
                            If you want to continue, press key 1
                             or you want to cancel, press key 6
                            """);
                    if (scanner.nextInt() == 6) {
                        mainMenu();
                    }
                    AccessArticle accessArticle = new AccessArticle();
                    accessArticle.Summary();
                    continue;

                } else if (menus2 == 2) {
                    System.out.println("""
                            If you want to continue, press key 2
                             or you want to cancel, press key 6
                            """);
                    if (scanner.nextInt() == 6) {
                        mainMenu();
                    }
                    AccessArticle addArticle = new AccessArticle();
                    addArticle.addArticle();
                    continue;

                } else if (menus2 == 3) {
                    System.out.println("""
                            If you want to continue, press key 3
                             or you want to cancel, press key 6
                            """);
                    if (scanner.nextInt() == 6) {
                        mainMenu();
                    }
                    System.out.println("enter new password:");
                    String newPassword = scanner.next();
                    userRepo.updateByUsername(uss, newPassword);
                    continue;

                } else if (menus2 == 4) {
                    System.out.println("""
                            If you want to continue, press key 4
                             or you want to cancel, press key 6
                            """);
                    if (scanner.nextInt() == 6) {
                        mainMenu();
                    }
                    AccessArticle editArticle = new AccessArticle();
                    AccessArticle.editArticle();
                    continue;

                } else if (menus2 == 5) {
                    System.out.println("""
                            If you want to continue, press key 5
                             or you want to cancel, press key 6
                            """);
                    if (scanner.nextInt() == 6) {
                        mainMenu();
                    }
                    AccessArticle showArticle = new AccessArticle();
                    showArticle.ShowArticle();
                    continue;
                } else if (menus2 == 6) {
                    appObject.app();
                }

            }
        }
    }
}
