
import java.sql.*;
import java.util.Scanner;



public class Ej5 {

public static void main(String args[]) {
        
		Scanner sc = new Scanner(System.in);

		
        try {
			  Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/colegio", "root", "" );
			  Statement st = con.createStatement();
			  System.out.println("Conexión establecida con éxito");
			  
			  System.out.println("Introduce el id del alumno");
			  int id = sc.nextInt();
			  
                         
			  
			  
                         ResultSet resultado = st.executeQuery("SELECT * FROM alumnos where id_alumno = '"+id+"' ");


                         
                         while (resultado.next()) {
                        	 
                        	   int id_alumno = resultado.getInt("id_alumno");
                               String Nombre =resultado.getString("Nombre");
                               String Apellidos = resultado.getString("Apellidos");
                               String Curso = resultado.getString("Curso");
                               Double nota_final = resultado.getDouble("nota_final");
                               String observaciones = resultado.getString("observaciones");
                               
                               System.out.println("La informacion del alumno pedido es:");   
                               System.out.println("ID del alumno: "+id_alumno);
                               System.out.println("Nombre: "+Nombre);
                               System.out.println("Apellido: "+Apellidos);
                               System.out.println("Curso: "+Curso);
                               System.out.println("Nota final: "+nota_final);
                               System.out.println("Observaciones: "+ observaciones);
                               System.out.println("");
                        	 
                          }


                         
                         
                       System.out.println("Introduce el id del alumno que desea eliminar");
           			   int id_2 = sc.nextInt(); 
                         
           			   
           			   
                       Statement sentencia = con.createStatement();
                       String query = ("DELETE FROM alumnos WHERE Id_Alumno = '"+id_2+"'");
                       st.executeUpdate(query);
                       			  
                       			  


                       System.out.println("El alumno se ha borrado");
                         
                         con.close();

		}catch (SQLException e) {
			  System.out.println(e.getMessage());		
		}
   }
	
}
