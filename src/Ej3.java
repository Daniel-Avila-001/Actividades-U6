import java.sql.DriverManager;
import java.util.Scanner;
import java.sql.*;



public class Ej3 {
	
		public static void main(String[]args) throws SQLException {
			
			try {
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/colegio", "root", "");
						
				Statement st = con.createStatement();
				System.out.println("Conexion establecida con éxito");
				
				//datos a insertar
				Scanner sc = new Scanner(System.in);
				System.out.println("Introduce el id del alumno:");
				int id_alumno = sc.nextInt();
				System.out.println("Introduce el nombre:");
				String Nombre = sc.next();
				System.out.println("Introduce el apellido:");
				String Apellidos = sc.next();
				System.out.println("Introduce el curso:");
				String Curso = sc.next();
				System.out.println("Introduce la nota final:");
				double nota_final  = sc.nextDouble();
				System.out.println("Introduce las observaciones:");
				String observaciones = sc.next();
				
				//filas y columnas
				String query = "INSERT INTO alumnos(id_alumno, Nombre, Apellidos, Curso, nota_final, observaciones)"
						
						+"Values ('"+id_alumno+"', '"+Nombre+"', '"+Apellidos+"', '"+Curso+"', '"+nota_final+"', '"+observaciones+"')";
				
				st.executeUpdate (query);
				
				System.out.println("Un nuevo usuario se ha registrado");
				
				st.close();
				con.close();
					
			} catch (SQLException e) {
					System.out.println(e.getMessage());
			}
			
		}


	

}
