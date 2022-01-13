package by.niitzi.bushylo.model.dao;

import by.niitzi.bushylo.model.entity.UserAccount;

import java.sql.*;

public class UserDAOOO {
    public String findUser(UserAccount userAccount)
    {
        String login = userAccount.getLogin();
        String password = userAccount.getPassword();

        String loginDB = "";
        String passwordDB = "";
        String roleDB = "";

        try
        {
            Connection con = createConnection();
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery("select login,password,role from users");
//В БД АДМИНОВ ОТДЕЛЬНО, ЮЗЕРОВ ОТДЕЛЬНО ИЛИ В ОДНОЙ таблице?...
            while(resultSet.next())
            {
                loginDB = resultSet.getString("login");
                passwordDB = resultSet.getString("password");
                roleDB = resultSet.getString("role");

                if(login.equals(loginDB) && password.equals(passwordDB) && roleDB.equals("admin"))
                    return "Admin_Role";
                else if(login.equals(loginDB) && password.equals(passwordDB) && roleDB.equals("user"))
                    return "User_Role";
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }

return "Invalid user credentials";

}



public static Connection createConnection(){
    String url = "jdbc:postgresql://localhost:8080/FinalTaskDatabase";
    String user = "postgres";
    String pass = "root";

    Connection con = null;

    try
    {
        try
        {
            Class.forName("org.postgresql.Driver");
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        con = DriverManager.getConnection(url, user, pass);
        System.out.println("Post establishing a DB connection - " + con);
    }
    catch (SQLException e)
    {
        System.out.println("An error occurred. Maybe user/password is invalid");
        e.printStackTrace();
    }
    return con;
}
}

