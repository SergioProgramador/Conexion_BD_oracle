package conectaBD;
import java.sql.*;
public class Conecta_Productos {
	public static void main(String[] args) {
		
		try {
			
			//NO HACE FALTA EN OCASIONES
			try {
				//Registrar el Driver
			    Class.forName("com.mysql.jdbc.Driver");
			    
			} catch (ClassNotFoundException ex) {
				
			    System.out.println("Error al registrar el driver de MySQL: " + ex);
			}
			
			//La clase DriverManager tiene un metodo getConnection()
			//1. CREAR CONEXION A LA BASE DE DATOS 	("driver correspondiente:// ruta y el puerto", "usuario", "MySQL10")
			
				Connection miConexion=DriverManager.getConnection("jdbc:mysql://localhost/curso_sql","root" , "");		
			
			//2. CREAMOS UN OBJETO DE TIPO STATEMENT PARA ENVIAR CONSULTAS SQL A LA BASE DE DATOS
				
				Statement miStatement=miConexion.createStatement();
			
			//La interfaz ResultSet tiene un metodo executeQuery()
			//3. EJECUTAR SQL
				
				ResultSet miResultSet=miStatement.executeQuery("SELECT * FROM PRODUCTOS");
				
			//4. RECORRER EL RESULTSET
				
				while(miResultSet.next()) {
					
					System.out.println(miResultSet.getString("CÓDIGOARTÍCULO") + " " + miResultSet.getString("NOMBREARTÍCULO") + " " + miResultSet.getString("PRECIO"));
					
				}	
				
				
				
		}catch(Exception e){
			
			System.out.println("No conecta.");
			
			e.printStackTrace();
			
		}
		

	}

}
