package by.niitzi.bushylo.model.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

public interface Dao<T> {
    Optional<T> get(long id);
    List<T> getAll();
    void save(T t);
    void update(T t, String[] params);
    void delete(T t);
    // When a DAO is created, this connection is passed to it. That way all DAO's accessed from that particulary Dao uses the same connection.

    default void close(Statement statement){
        try{
            if(statement != null){
                statement.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    default void close(Connection connection){
        try{
            if(connection != null){
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }//НО скорее всего ПОТОМ МОЖНО БУДЕТ УБРАТЬ закрытие statement-a и connection-a, КОГДА НОРМАЛЬНО ПУЛ КОННЕКТОВ ПРОПИШЕШЬ
}
