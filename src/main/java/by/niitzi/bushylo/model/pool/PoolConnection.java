package by.niitzi.bushylo.model.pool;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static by.niitzi.bushylo.model.pool.PoolConfiguration.*;


public class PoolConnection implements Pool{

    private DataSource dataSource;
    private String login;
    private String password;
    private List<Connection> connectionPool;
    private List<Connection> usedConnections = new ArrayList<>();
    private static int CONNECTION_POOL_SIZE;

   public static PoolConnection create(String login, String password) throws SQLException{
       List<Connection> pool = new ArrayList<>(CONNECTION_POOL_SIZE);//почему-то не хочет работать CONNECTION_POOL_SIZE из пропертей,пришлось объявить выше
       //connection pool based on an ArrayList that stores 10 connections, which can be easily reused
       for(int i = 0; i < CONNECTION_POOL_SIZE; i++){
           pool.add(createConnection(login, password));
       }
       return new PoolConnection(login,password,pool);
   }
//И ПОТОМ В СЕРВЛЕТЕ, ЧТОБЫ ПОЛУЧИТЬ НАПРИМЕР КОННЕКТ ПИШЕШЬ Connection connection = PoolConnection.getConnection();..только вот где конкретно...
//   {
//       try{
//           InitialContext initialContext = new InitialContext();

    /* из JNDI(Java Naming and Directory Interface) - Java API для доступа к службам имен и каталогов
       JNDI нужен для того, чтобы мы могли из Java-кода получить Java-объект из некоторой "Регистратуры" объектов по имени объекта, привязанного к этому объекту
       InitialContext - корневой узел дерева,  class implements the Context interface and serves as our entry point to a naming system
    */

//           dataSource = (DataSource) initialContext.lookup(DB_HOST);// поиск объекта по имнени
//
//       }catch(NamingException e){
//           e.printStackTrace();
//       }
//   }

    public PoolConnection(String login, String password, List<Connection> pool)  {
       this.login = login;
       this.password = password;
    }

    @Override
    public Connection getConnection() throws SQLException {
       if(connectionPool.isEmpty()){
           if (usedConnections.size() < CONNECTION_POOL_SIZE){// if all available connections are taken and current pool size is less than max size of it, the method will create a new connection
               connectionPool.add(createConnection(login,password));
           }else{
               throw new RuntimeException("Maximum pool size reached, no available connections((");
           }
       }
       Connection connection = connectionPool.remove(connectionPool.size() - 1);

       if(!connection.isValid(Integer.parseInt(WAIT_CONNECTION_TIMEOUT))){//verifying whether the connection, obtained from the pool, is still alive before passing in to the client
           connection = createConnection(login, password);
       }
       usedConnections.add(connection);
        return connection;
    }

    @Override
    public boolean releaseConnection(Connection connection) {
       connectionPool.add(connection);
        return usedConnections.remove(connection);
    }

    private static Connection createConnection(String login, String password) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:8080/FinalTaskDatabase", "postgres", "root");
        //метод получился немножко тупым, т.к. вместо конретных данных тут должны быть (url, user, password) НО ОН ПОЧЕМУ-ТО ПОДЧЕРКИВАЕТ АААааааААА
        return connection;
    }

    public void shutdown(){
       usedConnections.forEach(this :: releaseConnection);

       for(Connection conn : connectionPool){
           try {
               conn.close();
           } catch (SQLException e) {
               e.printStackTrace();
           }
       }

       connectionPool.clear();
    }
}
