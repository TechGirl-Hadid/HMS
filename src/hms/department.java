
package hms;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class department {
        public static void insertion(char opration,String id,String dep_name)
        {
        Connection con;
         con = myconnection.getConnection();
          PreparedStatement ps;
           if (opration=='i')
           {
            try {
                ps=con.prepareStatement("insert  into department(id,dep_name)values(?,?)");
                
                ps.setString(1, id);
             ps.setString(2, dep_name);
            
             if(ps.executeUpdate()>0)
             {
             
             JOptionPane.showMessageDialog(null," Record  Inserted  Successfully !! ");
             }
             else
             {
             JOptionPane.showMessageDialog(null," Sorry !! Record  Not  Inserted ");
             }  
                
            }
            catch (SQLException ex) {
                Logger.getLogger(department.class.getName()).log(Level.SEVERE, null, ex);
            }
           
     
           }
        
        
        }
         public void Report8(JTable table,String valuesearch)
     {
     Connection con = myconnection.getConnection();
     PreparedStatement ps;
         try {
             ps=con.prepareStatement("select * from department where CONCAT('id','dep_name')like ?");
             ps.setString(1, "%"+valuesearch+"%");
             ResultSet rs=ps.executeQuery();
             DefaultTableModel model =(DefaultTableModel)table.getModel();
             model.setRowCount(0);
             Object [] row;
             while(rs.next())
             {
               row=new Object[2] ;
               row[0]=rs.getString(1);
               row[1]=rs.getString(2);
              
                model.addRow(row);
            }
             
         } catch (SQLException ex) {
             Logger.getLogger(department.class.getName()).log(Level.SEVERE, null, ex);
         }
}
 public void update(char opration,String id,String dep_name){
          Connection con;
         con = myconnection.getConnection();
          PreparedStatement ps;
          
          if (opration=='u')// for ypdate
        {
        try {
            ps=con.prepareStatement("update department set dep_name=? where id=?");
           
             ps.setString(1, dep_name);
            
              ps.setString(2, id);//ps.setString(8, gender);
             
             if(ps.executeUpdate()>0)
              { 
               JOptionPane.showMessageDialog(null," Record  Updated Successfully !! ");
              }
             else
             {
              JOptionPane.showMessageDialog(null," Sorry !! Record  Not Updated  ");
             }
             
             
             
        } catch (SQLException ex) {
            Logger.getLogger(department.class.getName()).log(Level.SEVERE, null, ex);
        }
      
        }
     }
           public void delete(char opration,String id,String dep_name){
          Connection con;
         con = myconnection.getConnection();
          PreparedStatement ps;
          
          if (opration=='d')// for delete
        {
        try {
            ps=con.prepareStatement("delete from  department where id=?");
           
            
              ps.setString(1, id);//ps.setString(8, gender);
             
             if(ps.executeUpdate()>0)
              { 
               JOptionPane.showMessageDialog(null," Record  Deleted Successfully !! ");
              }
             else
             {
              JOptionPane.showMessageDialog(null," Sorry !! Record  Not Deleted  ");
             }
             
             
             
        } catch (SQLException ex) {
            Logger.getLogger(department.class.getName()).log(Level.SEVERE, null, ex);
        }
      
        }
     }

}
