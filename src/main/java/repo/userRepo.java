package repo;

import domain.User;
import service.ApplicationConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class userRepo {


    private int userId;

    public static User insert(User user) throws SQLException {
        String sql = """
                INSERT INTO "User"(username,nationalCode,birthday,password)
                VALUES (?, ?, ?, ?)
                """;
        PreparedStatement insertStatement = ApplicationConnection.getConnection()
                .prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        insertStatement.setString(1, user.getUsername());
        insertStatement.setString(2, user.getNationalCode());
        insertStatement.setString(3, user.getBirthday());
        insertStatement.setString(4, user.getPassword());

        insertStatement.execute();
        ResultSet generatedIds = insertStatement.getGeneratedKeys();
        generatedIds.next();
        int id = generatedIds.getInt(1);
        user.setId(id);
        return user;
    }


    public static boolean loadById(String userName) throws SQLException {
        String sql = """
                SELECT * from "User"
                WHERE userName=?;
                """;
        PreparedStatement loadByIdStatement = ApplicationConnection.getConnection()
                .prepareStatement(sql);
        loadByIdStatement.setString(1, userName);
        loadByIdStatement.execute();
        ResultSet resultSet = loadByIdStatement.executeQuery();
        if (resultSet.next()) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean loadByPassWord(String passWord) throws SQLException {
        String sql = """
                SELECT * from "User"
                WHERE password=?;
                """;
        PreparedStatement loadByPassWordstatment = ApplicationConnection.getConnection()
                .prepareStatement(sql);
        loadByPassWordstatment.setString(1, passWord);
        loadByPassWordstatment.execute();
        ResultSet resultSet = loadByPassWordstatment.executeQuery();
        if (resultSet.next()) {
            return true;
        } else {
            return false;
        }


    }

    public static User findByusername(String username) throws SQLException {
        String sql = """
                 SELECT * from "User"
                                WHERE username=?;
                """;
        PreparedStatement findByIdStatement = ApplicationConnection.getConnection().prepareStatement(sql);
        findByIdStatement.setString(1, username);

        ResultSet result = findByIdStatement.executeQuery();


        if (result.next()) {
            int id = result.getInt("id");
            String nationalcode = result.getString("nationalcode");
            String password = result.getString("password");
            username = result.getString("username");
            String birthday = result.getString("birthday");

            User user = new User(
                    id,
                    username,
                    password,
                    nationalcode,
                    birthday
            );
            findByIdStatement.close();
            return user;
        } else {
            findByIdStatement.close();
            return null;

        }

    }

    public static int updateByUsername(String username, String password) throws SQLException {
        String sql = """
                 UPDATE "User"
                 SET password = ?
                 WHERE username = ?;
                """;
        PreparedStatement updateByUsername = ApplicationConnection.getConnection().prepareStatement(sql);
        updateByUsername.setString(1, password);
        updateByUsername.setString(2, username);
        int result = updateByUsername.executeUpdate();
        return result;
    }
}


