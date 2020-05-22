
import java.sql.*;
import java.util.Scanner;



public class Ej9 {
public static void main(String args[]) {
        
		Scanner sc = new Scanner(System.in);
        
		
        try {
			  Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/empresa", "root", "" );
			  Statement st = con.createStatement();
			  System.out.println("Conexión establecida con éxito");
			  
			
			  System.out.println("Introduce el id del empleado1:");
			  int id = sc.nextInt();
			
			   		  System.out.println("Introduce el dia que libra el empleado:"); 
         			  String DL = sc.next();	
         			   
        			   
                       Statement sentencia = con.createStatement();
                       
                       
                       
                       sentencia.executeUpdate("UPDATE empleados SET dia_libre = '"+DL+"'WHERE id_empleado = '"+id+"'  ");
                      
                       System.out.println("La modificacion se ha hecho correctamente!!");			  
                       
                         
                         con.close();

		}catch (SQLException e) {
			  System.out.println(e.getMessage());		
		}
   }

}
