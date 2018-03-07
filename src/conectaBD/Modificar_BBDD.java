package conectaBD;
import java.sql.*;

public class Modificar_BBDD {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			
			//1. Creamos la conexion a la base de datos.
			Connection miConexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/curso_sql","root" , "");		
		
			//2. Creamos un objeto de tipo Statement para enviar consultas a la base de datos
			Statement miStatement=miConexion.createStatement();
			
			
			/* 
			* 3. Creamos una variable de tipo String y almacenamos en ella la instruccion que queremos.
			* INSTRUCCIONES:
			* INSERT INTO PRODUCTOS (CÓDIGOARTÍCULO, NOMBREARTÍCULO, PRECIO) VALUES ('AR78', 'CALCETINES', 25.35)
			* UPDATE PRODUCTOS SET PRECIO=PRECIO*2 WHERE CÓDIGOARTÍCULO='AR77' 
			*/
			String instruccionSQL="DELETE FROM PRODUCTOS WHERE CÓDIGOARTÍCULO='AR77' ";
	
			// 4. Le tenemos que decir al programa que nos ejecute esta intruccion creada.
			//Para ello utilizamos el metodo --> .executeUpdate(parametro) este metodo se utiliza para INSERT, UPDATE, DELETE
			miStatement.executeUpdate(instruccionSQL);
			
				System.out.println("Datos eliminados correctamente.");
			
		}catch(Exception e){
		
			System.out.println("No conecta.");
			e.printStackTrace();	
	}
	}
}
