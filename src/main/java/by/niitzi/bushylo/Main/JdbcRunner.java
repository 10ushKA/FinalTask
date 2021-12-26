package by.niitzi.bushylo.Main;

import java.sql.*;

public class JdbcRunner {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:8080/FinalTaskDatabase";
        String user = "postgres";
        String pass = "root";
        Connection connection = null;


        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, user, pass);


            Statement statement = connection.createStatement();//делаем запрос

            ResultSet resultSet = statement.executeQuery("SELECT * FROM users");//получаем результат

            int i = 1;
             while(resultSet.next()){
                 System.out.println("#" + i + " - " + resultSet.getInt("id") + " " + resultSet.getString("login"));
                 i++;

             }

            String sql = "INSERT INTO users(id, login, password)" + "VALUES ('4', 'userlogin4', '4444')";
            //String sql = "INSERT INTO users(id, login) VALUES (?, ?)"; // + PreparedStatement...
            int row = statement.executeUpdate(sql);
             if(row > 0){
                 System.out.println("A new user has been inserted");
             }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }finally {
            if(connection != null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
