import java.sql.*;
import java.util.*;

public class Dynamic_Jdbc_Insert {
    public static void insert() {
        Scanner sc=new Scanner(System.in);

        System.out.println("How many rows do you want to create?");
        int number=sc.nextInt();

        String url="jdbc:mysql://localhost:3306/world";
        String user="root";
        String pass="mrkk@123";
        
        try(Connection con=DriverManager.getConnection(url,user,pass);
            Statement smnt=con.createStatement();)
            {
            for(int i=1;i<=number;i++){

                System.out.println("Enter Id:");
                int id=sc.nextInt();
    
                System.out.println("Enter Name:");
                String name=sc.next();
    
                System.out.println("Enter Age:");
                int age=sc.nextInt();

                String query="insert into college values("+id+","+"'"+name+"'"+","+age+")";
                smnt.executeUpdate(query); 

                System.out.println("Row Created");
                
            }
            con.close();
        }
        catch(SQLException se){
            se.printStackTrace();

        }
        System.out.println("Inserted Values");
        
    }
}
