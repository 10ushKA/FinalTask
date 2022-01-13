package by.niitzi.bushylo.model.dao;

import by.niitzi.bushylo.model.entity.UserAccount;

import java.sql.*;
import java.util.*;

public class UserDAO implements Dao<UserAccount> {//прослойка между приложением и БД
//определяет общие методы использования соединения, его получение, закрытие и (или) возвращение в Connection Pool



//    public UserAccount getUserLoginNPassword(String login, String password) throws SQLException, ClassNotFoundException {
//        String url = "jdbc:postgresql://localhost:8080/FinalTaskDatabase";
//        String user = "postgres";
//        String pass = "root";
//
//        Class.forName("org.postgresql.Driver");
//        Connection connection = DriverManager.getConnection(url, user, pass);
//        PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE login = ? AND password = ?");
//        statement.setString(1,login);
//        statement.setString(2,password);
//
//        ResultSet result = statement.executeQuery();//получаем результат
//
//
//
//        UserAccount userAcc = null;
//        if(result.next()){
//            userAcc = new UserAccount();
//            userAcc.setLogin(result.getString("login"));
//        }
//        connection.close();
//
//        return userAcc;
//    }


    private static final Map<String, UserAccount> mapUsers = new HashMap<String, UserAccount>();
    public UserAccount findUser(String login, String password){
    UserAccount userAccount = mapUsers.get(login);
    if(userAccount != null && userAccount.getPassword().equals(password)){
        return userAccount;
    }
    return null;
}


//хранение USER-в в виде ArrayList(переписать методы для хранения в виде Map, выше..)

    private List<UserAccount> users = new ArrayList<>();

    @Override
    public Optional<UserAccount> get(long id) {
        return Optional.ofNullable(users.get((int) id));
    }

    @Override
    public List<UserAccount> getAll() {
        return users;
    }

    @Override
    public void save(UserAccount user) {
        users.add(user);
    }

    @Override
    public void update(UserAccount user, String[] params) {
        user.setLogin(Objects.requireNonNull(params[0], "Login cannot be null"));
        user.setPassword(Objects.requireNonNull(params[1], "Email cannot be null"));

        users.add(user);

    }

    @Override
    public void delete(UserAccount user) {
    users.remove(user);
    }
}
