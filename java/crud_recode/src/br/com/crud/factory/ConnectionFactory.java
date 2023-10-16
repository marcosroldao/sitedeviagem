package br.com.crud.factory;

 

import java.sql.Connection;

 

import java.sql.DriverManager;

 

 

public class ConnectionFactory {

 

	

 

	private static final String USERNAME = "root";

 

	

 

	private static final String PASSWORD = "1234567$";

 

	

 

	private static final String DATABASE_url = "jdbc:mysql://localhost:3306/crud";

 

	

 

	public static Connection creatConnectionToMySQL() throws

 

	Exception{

 

		Class.forName("com.mysql.cj.jdbc.Driver");

		//	Class.forName("com.mysql.cj.jdbc.Driver");

 

		

 

		Connection connection = DriverManager.getConnection(DATABASE_url, USERNAME, PASSWORD);

 

		return connection;

 

		

 

	}

 

	public static void main(String[]args)throws Exception{

 

		Connection con = creatConnectionToMySQL();

 

		

 

		if(con != null) {

 

			System.out.println("conexão obtida com sucesso !" + con);

 

			

 

		}

 

	}

 

	

 

 

}

 
 



 