
package hms;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class regretration2 {
    
  
     public void insertionEditDelete(char operation,String Name,String lname,String password,String rPassword)
    
 { 
 Connection con=myconnection.getConnection();
    PreparedStatement ps;
    if(operation=='i')
    {
     try {
         ps=con.prepareStatement("insert into user (Name,lname, password,rPassword)values(?,?,?,?)");
         ps.setString(1,Name);
          ps.setString(2,lname);
          ps.setString(3,password);
          ps.setString(4,rPassword);
          
          
             if(ps.executeUpdate()>0)
             {
               JOptionPane.showMessageDialog(null,"Record inseretd successfully !" );
             }
             else
             {
               JOptionPane.showMessageDialog(null,"Record not inseretd successfully !" );   
             }
            } catch (SQLException ex) {
             Logger.getLogger(adD1.class.getName()).log(Level.SEVERE, null, ex);
            }
    
 }      
 }
}


