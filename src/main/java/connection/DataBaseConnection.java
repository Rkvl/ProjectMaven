package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {

    private static final String JDBC_MYSQL_HOST = "jdbc:mysql://localhost:3306/";
    private static final String MYSQL_JDBC_DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
    private static final String DB_NAME = "travelagency";
    private static final String PARAMS = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "kvlukraine";

  public Connection getConnection() {

        Connection connection = null;


        try {
            Class.forName(MYSQL_JDBC_DRIVER_NAME);
            return DriverManager.getConnection(JDBC_MYSQL_HOST
                            + DB_NAME + PARAMS,
                    USERNAME,
                    PASSWORD);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
