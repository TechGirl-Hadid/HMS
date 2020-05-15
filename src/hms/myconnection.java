package hms;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;

 class myconnection 
 {
    private static final String USERNAME="root";
    private static final String PASSWORD="123";
    private static final String CON_STRING="jdbc:mysql://localhost:3306/hospital";
    public static Connection getConnection(){
        Connection con =null;
        try {
            con =DriverManager.getConnection(CON_STRING,USERNAME,PASSWORD);
            System.out.println("Connected");
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
            
        }
    
    
    return con;
    }
   
}
