import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.println("Select an operation you want to perform:");
        System.out.println("1.Select all 2.select specifics 3.Insert");

        int selection=sc.nextInt();

        if(selection==1){
            Dynamic_Jdbc_SelectAll all=new Dynamic_Jdbc_SelectAll();
            all.select();
        }
        if(selection==2){
            Dynamic_jdbc_Select spec=new Dynamic_jdbc_Select();
            spec.normal();
        }if(selection==3){
            Dynamic_Jdbc_Insert ins=new Dynamic_Jdbc_Insert();
            ins.insert();
        }else if(selection==4){
            Dynamic_Jdbc_Delete del=new Dynamic_Jdbc_Delete();
            del.delete();
        }


    }
}
