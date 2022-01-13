package by.niitzi.bushylo.model.dao;

import by.niitzi.bushylo.model.entity.UserAccount;
import by.niitzi.bushylo.model.pool.*;

import java.sql.*;

public class UserDAOO {

    public UserAccount findUser(String login, String password) throws SQLException, ClassNotFoundException {
        String url = "jdbc:postgresql://localhost:8080/FinalTaskDatabase";
        String user = "postgres";
        String pass = "root";

        String roleDB = "";

        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection(url, user, pass);
        //вместо предыдущей что-то а-ля ДЛЯ ПОДКЛЮЧЕНИЯ ПУЛА КОННЕКТОВ connection = DriverManager.getConnection(connectionPool, null);
        //OR use DataSource object instead of DriverManager (в PoolConnection есть спойлер насчет этого)
        //Once a DataSource object is registered, the application retrieves it from the JNDI naming service in the standard way
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE login = ? AND password = ? AND role = ?");
        statement.setString(1,login);
        statement.setString(2,password);

        ResultSet result = statement.executeQuery();//получаем результат


        UserAccount userAcc = null;
        if(result.next()){
            userAcc = new UserAccount();
            userAcc.setLogin(result.getString("login"));
        }
        connection.close();

        return userAcc;
    }
}
