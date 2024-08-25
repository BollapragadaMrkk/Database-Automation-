import java.util.Scanner;
import java.sql.*;
public class Dynamic_Jdbc_Delete {
    public void delete(){
        Scanner sc = new Scanner(System.in);
        String url = "jdbc:mysql://localhost:3306/world";
        String user = "root";
        String pass = "mrkk@123";
        String q = "";
        int par = 0;
        String name = "";

        System.out.println("\nSelect the item you want to delete");
        System.out.println("1. id 2. name 3. age");
        System.out.println("Enter a number:");
        int del = sc.nextInt();

        if (del == 1) {
            q = "id";
            System.out.println("Enter the id you want to delete:");
            par = sc.nextInt();
        } else if (del == 2) {
            q = "name";
            System.out.println("Enter the name you want to delete:");
            name = sc.next();
        } else if (del == 3) {
            q = "age";
            System.out.println("Enter the age group you want to delete:");
            par = sc.nextInt();
        }

        String query = "";
        if (del == 1 || del == 3) {
            query = "DELETE FROM college WHERE " + q + "=?";
        } else if (del == 2) {
            query = "DELETE FROM college WHERE " + q + "=?";
        }

        try (Connection con = DriverManager.getConnection(url, user, pass);
             PreparedStatement pstmt = con.prepareStatement(query)) {

            if (del == 1 || del == 3) {
                pstmt.setInt(1, par);
            } else if (del == 2) {
                pstmt.setString(1, name);
            }

            int rowsAffected = pstmt.executeUpdate();
            System.out.println(rowsAffected + " row(s) deleted.");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
