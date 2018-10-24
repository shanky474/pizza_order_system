package com.javarnd.pizza_order_system;

import java.sql.DriverManager;
import com.mysql.jdbc.Connection;
import java.sql.SQLException;
import com.mysql.jdbc.PreparedStatement;

public class PizzaDatabaseConnection 
{
static Connection con=null;

public static Connection PizzaDatabaseConnection(String db_name, String user_name, String password)
{
	try
	{
	Class.forName("com.mysql.jdbc.Driver");  
	con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/"+db_name+"?",user_name,password);
	}
	catch(Exception e)
	{
	 e.printStackTrace();	
	}
	return con;
	}

public PreparedStatement createPST(String sql) throws SQLException
{	
	PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);
	return stmt;
}

}
