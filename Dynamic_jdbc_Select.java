import java.sql.*;
import java.util.Scanner;

public class Dynamic_jdbc_Select{
    public static void normal(){
        Scanner sc=new Scanner(System.in);
        String url="jdbc:mysql://localhost:3306/world";
        String user="root";
        String pass="mrkk@123";

        System.out.println("1.id "+"2.name "+"3.age "+"4.all");
        int parameter=sc.nextInt();
        
        String col="";

        if(parameter==1){
            col="id";
        }else if(parameter==2){
            col="name";
        }else if(parameter==3){
            col="age";   
        }else if(parameter==4){
            col="id,name,age";
        }

        String query="";
        int one=0;
        String var=""; 
        if(parameter==1 || parameter==3){ 
        System.out.println("Enter the number:");
        one=sc.nextInt();
        query="select * from college where "+col+"="+one;}
        else if(parameter==2){ 
            System.out.println("Enter the name:");
            var=sc.next();
            query="select * from college where "+col+"="+"'"+var+"'";}
        
        try(Connection con = DriverManager.getConnection(url,user,pass);
            Statement smnt = con.createStatement();
            ResultSet rs=smnt.executeQuery(query);)
            {
                while(rs.next()){
                    System.out.print("ID:" + rs.getInt("id"));
                    System.out.print(",Name:"+rs.getString("name"));
                    System.out.println(",Age:"+rs.getInt("age"));   
                    }
                
        }
        catch(SQLException se){
            se.printStackTrace();
        }
    }
}