
import java.sql.*;
import java.util.Scanner;



public class Ej6 {
public static void main(String args[]) {
        
		Scanner sc = new Scanner(System.in);

		
        try {
			  Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/colegio", "root", "" );
			  Statement st = con.createStatement();
			  System.out.println("Conexión establecida con éxito");
			  
			  System.out.println("Introduce el id del alumno");
			  int id = sc.nextInt();
			  


			  
			  
                         ResultSet resultado = st.executeQuery("SELECT * FROM alumnos where Id_Alumno = '"+id+"' ");


                         
                         
                         
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
                         
                         
                         
                         
                       System.out.println("Introduce el id del alumno a modificar:");
           			   int id_2 = sc.nextInt();
           			   
           			   System.out.println("Introduce el Nombre del alumno:");
         			   String Nom = sc.next();	
         			   System.out.println("Introduce el Apellido del alumno:"); 
         			   String Apll = sc.next();
         			   System.out.println("Introduce el Curso del alumno:"); 
        			   String Cur = sc.next();
        			   System.out.println("Introduce la Nota Final del alumno:"); 
        			   Double NF = sc.nextDouble();
        			   System.out.println("Introduce las Observaciones del alumno:"); 
        			   String Obs = sc.next();
        			   
                       Statement sentencia = con.createStatement();
                       
                       
                       
                       sentencia.executeUpdate("UPDATE alumnos SET Nombre = '"+Nom+"'WHERE id_alumno = '"+id_2+"'  ");
                       sentencia.executeUpdate("UPDATE alumnos SET Apellidos = '"+Apll+"'WHERE id_alumno = '"+id_2+"'  ");
                       sentencia.executeUpdate("UPDATE alumnos SET Curso = '"+Cur+"'WHERE id_alumno = '"+id_2+"'  ");
                       sentencia.executeUpdate("UPDATE alumnos SET nota_final = '"+NF+"'WHERE id_alumno = '"+id_2+"'  ");
                       sentencia.executeUpdate("UPDATE alumnos SET observaciones = '"+Obs+"'WHERE id_alumno = '"+id_2+"'  ");
                       
                       
                       System.out.println("La modificacion se ha hecho correctamente!!");			  
                       
                         
                         con.close();

		}catch (SQLException e) {
			  System.out.println(e.getMessage());		
		}
   }

}
