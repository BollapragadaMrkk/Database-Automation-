import java.sql.*;
import java.util.*;
public class Dynamic_Jdbc_SelectAll{
    public void select() {
        Scanner sc=new Scanner(System.in);
        String url="jdbc:mysql://localhost:3306/world";
        String user="root";
        String pass="mrkk@123";
        String query="select id,name,age from college";
        
        try(Connection con = DriverManager.getConnection(url,user,pass);
            Statement smnt = con.createStatement();
            ResultSet rs = smnt.executeQuery(query);){
            while(rs.next()){
            System.out.print("ID:" + rs.getInt("id"));
            System.out.print(",Name:"+rs.getString("name"));
            System.out.println(",Age:"+rs.getInt("age"));   
            }
            rs.close();
            smnt.close();
            con.close();
        }
        catch(SQLException se){
            System.out.println("Inside catch");
            System.out.println("Exception:"+se);
            se.printStackTrace();

        }
    }

   
}
