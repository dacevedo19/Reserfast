package reserfast.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbContext {   
	
    private static final String DRIVER = "org.postgresql.Driver";
    private static final String URL = "jdbc:postgresql://localhost:5432/db_reserfast";
    private static final String USER = "reserfast";
    private static final String PASS = "password123";


    //Crear conexión
    public static Connection createConnection() {
            Connection conexionDB = null;
            try {
                    Class.forName(DRIVER);
            } catch (ClassNotFoundException e) {
                    e.printStackTrace();
            }
            try {
                    conexionDB = DriverManager.getConnection(URL, USER, PASS);
                    conexionDB.setAutoCommit(false);

            } catch (SQLException e) {
                    e.printStackTrace();
            }		
            return conexionDB;
    }	

}
