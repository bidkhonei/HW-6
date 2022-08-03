package service;

import domain.Article;
import domain.User;
import repo.articleRepo;
import repo.userRepo;

import java.sql.SQLException;
import java.util.List;

import static service.Login.scanner;

public class AccessArticle {
    static Login login = new Login();
    Main_menu main_menu;

    public void addArticle() throws SQLException {
        System.out.println("ٍenter title");
        String title = scanner.next();
        System.out.println("enter brief");
        String brief = scanner.next();
        System.out.println("enter content");
        String content = scanner.next();
        System.out.println("enter createDate");
        String createDate = scanner.next();
        System.out.println("enter isPublished");
        Boolean isPublished = Boolean.valueOf(scanner.next());
        User user = userRepo.findByusername(login.uss);
        int user_id = user.getId();
        Article article = new Article(title, brief, content, createDate, isPublished, user_id);
        articleRepo.insert(article);

    }

    public static void editArticle() throws SQLException {
        User user = userRepo.findByusername(login.uss);
        int i1 = user.getId();
        Article article = articleRepo.findById(i1);
        if (article != null) {
            int x = article.getUser_id();
            System.out.println("Tell me the number of the article");
            if (i1 == x) {
                int id = scanner.nextInt();
                System.out.println("What is the new title?");
                String title = scanner.next();
                System.out.println("What is the new brief?");
                String brief = scanner.next();
                System.out.println("What is the new content?");
                String content = scanner.next();
                System.out.println("What is the new createDate?");
                String date = scanner.next();
                System.out.println("What is the new isPublished?");
                boolean isPublished = scanner.hasNext();
                articleRepo.updateByid(id, title, brief, content, date, isPublished);
            } else {
                System.out.println("You do not have an article");

            }

        }

    }
    public void ShowArticle() throws SQLException {
        List<Article> articles = articleRepo.findByispublished(true);
        articles.forEach(System.out::println);
    }
}
