package repo;

import domain.Article;
import service.ApplicationConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class articleRepo {

    public static Object findByUser_Id;
    private int userId;

    public static Article insert(Article article) throws SQLException {


        String sql = """
                INSERT INTO "Article"(title,brief,content,createDate,isPublished,user_id)
                VALUES (?, ?, ?, ?, ?,?)
                """;
        PreparedStatement insertStatement = ApplicationConnection.getConnection()
                .prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        insertStatement.setString(1, article.getTitle());
        insertStatement.setString(2, article.getBrief());
        insertStatement.setString(3, article.getContent());
        insertStatement.setString(4, article.getCreateDate());
        insertStatement.setBoolean(5, article.getPublish());
        insertStatement.setInt(6, article.getUser_id());
        insertStatement.execute();
        ResultSet generatedIds = insertStatement.getGeneratedKeys();
        generatedIds.next();
        int id = generatedIds.getInt(1);
        article.setId(id);
        return article;

    }


    public static List<String> findByUser_Id(int user_id) throws SQLException {

        String sql = """
                SELECT * FROM "Article" WHERE user_id = ?
                """;
        PreparedStatement findByUserIdStatement = ApplicationConnection.getConnection().prepareStatement(sql);
        findByUserIdStatement.setInt(1, user_id);
        ResultSet result = findByUserIdStatement.executeQuery();
        List<String> articles = new ArrayList<String>();


        while (result.next()) {
            int id = result.getInt("id");
            user_id = result.getInt("user_id");
            String title = result.getString("title");
            String brief = result.getString("brief");
            Article article = new Article(
                    id,
                    user_id,
                    title,
                    brief);

            articles.add(article.getBrief() +"||"+ article.getTitle() +"||"+ article.getId());
        }

        return articles;

    }

    public static int updateByid(int id, String title, String brief, String content, String createdate, boolean ispublished) throws SQLException {
        String sql = """
                 UPDATE "Article"
                 SET  title=?,brief=?,content=?,createdate=?,ispublished=?
                 
                 WHERE id = ?;
                """;
        PreparedStatement updateByid = ApplicationConnection.getConnection().prepareStatement(sql);
        updateByid.setString(1, title);
        updateByid.setString(2, brief);
        updateByid.setString(3, content);
        updateByid.setString(4, createdate);
        updateByid.setBoolean(5, ispublished);
        updateByid.setInt(6, id);
        int result = updateByid.executeUpdate();
        return result;
    }

    public static Article findById(int id) throws SQLException {
        String sql = """
                 SELECT * from "Article"
                                WHERE id=?;
                """;
        PreparedStatement findByIdStatement = ApplicationConnection.getConnection().prepareStatement(sql);
        findByIdStatement.setInt(1, id);

        ResultSet result = findByIdStatement.executeQuery();


        if (result.next()) {
            id = result.getInt("id");
            String title = result.getString("title");
            String brief = result.getString("brief");
            String content = result.getString("content");
            String createdate = result.getString("createdate");
            boolean ispublished = result.getBoolean("ispublished");
            int user_id = result.getInt("user_id");

            Article article = new Article(
                    id,
                    title,
                    brief,
                    content,
                    user_id
            );
            findByIdStatement.close();
            return article;
        } else {
            findByIdStatement.close();
            return null;
        }


    }

    public static List<Article> findByispublished(boolean ispublished) throws SQLException {

        String sql = """
                SELECT * FROM "Article" WHERE ispublished = ? 
                """;
        PreparedStatement findByUserIdStatement = ApplicationConnection.getConnection().prepareStatement(sql);
        findByUserIdStatement.setBoolean(1, ispublished);
        ResultSet result = findByUserIdStatement.executeQuery();
        List<Article> articles = new ArrayList<Article>();
        while (result.next()) {
            int id = result.getInt("id");
            int user_id = result.getInt("user_id");
            String title = result.getString("title");
            String brief = result.getString("brief");
            String content = result.getString("content");
            String createDate = result.getString("createDate");
            boolean isPublished = result.getBoolean("isPublished");
            Article article = new Article(
                    id,
                    user_id,
                    title,
                    brief,
                    content,
                    createDate,
                    isPublished);

            articles.add(article);

        }

        return articles;

    }
}
