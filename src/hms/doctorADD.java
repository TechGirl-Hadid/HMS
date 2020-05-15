
package hms;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class doctorADD {
    public static void insertion(char opration,String id,String name,String lname,String age,String phone,String address,String department,String gender)
    {
    Connection con;
         con = myconnection.getConnection();
          PreparedStatement ps;
  
        if (opration=='i')// for insert
        {
        try {
            ps=con.prepareStatement("insert  into doctor(id,name,lname,age,phone,address,department,gender)values(?,?,?,?,?,?,?,?)");
            ps.setString(1, id);
             ps.setString(2, name);
             ps.setString(3, lname);
             ps.setString(4, age);
             ps.setString(5, phone);
             ps.setString(6, address);
             ps.setString(7, department);
             ps.setString(8, gender);
             
             if(ps.executeUpdate()>0)
              { 
               JOptionPane.showMessageDialog(null," Record  Inserted  Successfully !! ");
              }
             else
             {
              JOptionPane.showMessageDialog(null," sorry !! Record  Not  Inserted ");
              
             }
             
             
             
        } catch (SQLException ex) {
            Logger.getLogger(doctorADD.class.getName()).log(Level.SEVERE, null, ex);
        }
      
        }
        
    }
     public void Report1(JTable table,String valuesearch)
     {
     Connection con = myconnection.getConnection();
     PreparedStatement ps;
         try {
             ps=con.prepareStatement("select * from doctor where CONCAT('id','name','lname','age','phone','address','department','gender')like ?");
             ps.setString(1, "%"+valuesearch+"%");
             ResultSet rs=ps.executeQuery();
             DefaultTableModel model =(DefaultTableModel)table.getModel();
             model.setRowCount(0);
             Object [] row;
             while(rs.next())
             {
               row=new Object[8] ;
               row[0]=rs.getString(1);
               row[1]=rs.getString(2);
               row[2]=rs.getString(3);
               row[3]=rs.getString(4);
               row[4]=rs.getString(5);
               row[5]=rs.getString(6);
               row[6]=rs.getString(7);
               row[7]=rs.getString(8);
                model.addRow(row);
            }
             
         } catch (SQLException ex) {
             Logger.getLogger(doctorADD.class.getName()).log(Level.SEVERE, null, ex);
         }
}
     public void update(char opration,String id,String name,String lname,String age,String phone,String address,String department){
          Connection con;
         con = myconnection.getConnection();
          PreparedStatement ps;
          
          if (opration=='u')// for ypdate
        {
        try {
            ps=con.prepareStatement("update doctor set name=?,lname=?,age=?,phone=?,address=?,department=? where id=?");
           
             ps.setString(1, name);
             ps.setString(2, lname);
             ps.setString(3, age);
             ps.setString(4, phone);
             ps.setString(5, address);
             ps.setString(6, department);
              ps.setString(7, id);//ps.setString(8, gender);
             
             if(ps.executeUpdate()>0)
              { 
               JOptionPane.showMessageDialog(null," Record  Updated Successfully !! ");
              }
             else
             {
              JOptionPane.showMessageDialog(null," sorry !! Record  Not Updated  ");
             }
             
             
             
        } catch (SQLException ex) {
            Logger.getLogger(doctorADD.class.getName()).log(Level.SEVERE, null, ex);
        }
      
        }
     }
           public void delete(char opration,String id,String name,String lname,String age,String phone,String address,String department){
          Connection con;
         con = myconnection.getConnection();
          PreparedStatement ps;
          
          if (opration=='d')// for delete
        {
        try {
            ps=con.prepareStatement("delete from  doctor where id=?");
           
            
              ps.setString(1, id);//ps.setString(8, gender);
             
             if(ps.executeUpdate()>0)
              { 
               JOptionPane.showMessageDialog(null," Record  Deleted Successfully !! ");
              }
             else
             {
              JOptionPane.showMessageDialog(null," sorry !! Record  Not Deleted  ");
             }
             
             
             
        } catch (SQLException ex) {
            Logger.getLogger(doctorADD.class.getName()).log(Level.SEVERE, null, ex);
        }
      
        }
     }

}

