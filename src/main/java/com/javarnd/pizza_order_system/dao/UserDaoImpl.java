package com.javarnd.pizza_order_system.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.javarnd.pizza_order_system.PizzaDatabaseConnection;
import com.jdbc.pizza_order_system.model.pizza;
import com.jdbc.pizza_order_system.model.topping;
import com.jdbc.pizza_order_system.model.user;
import com.mysql.jdbc.PreparedStatement;

public class UserDaoImpl 
{
	Scanner input = new Scanner(System.in);
	PizzaDatabaseConnection connect = new PizzaDatabaseConnection();
	user user = new user();
	String sql;
	
	//Insert Method
	
	public void insert(String username, String pizzatype, String pizzasize, String toppingtype, int pizzaprice, int toppingprice) throws SQLException
	{
		sql="INSERT INTO user VALUES (NULL,?,?,?,?,?)";
		PreparedStatement stmt = connect.createPST(sql);
		user.setUsername(username);
		user.setPizzatype(pizzatype);
		user.setPizzasize(pizzasize);
		user.setToppingtype(toppingtype);
		user.setTotalprice(pizzaprice+toppingprice);
		stmt.setString(1, user.getUsername());
		stmt.setString(2, user.getPizzatype());
		stmt.setString(3, user.getPizzasize());
		stmt.setString(4, user.getToppingtype());
		stmt.setInt(5, user.getTotalprice());
		stmt.executeUpdate();  
	}

	//Select Method
	
	public void select() throws SQLException
	{
		sql = "SELECT * FROM user";
		PreparedStatement stmt = connect.createPST(sql);
		ResultSet rs = stmt.executeQuery();
		while(rs.next())
		{
		System.out.println(rs.getString(1)+"    "+rs.getString(2)+"    "+rs.getString(3)+"    "+rs.getString(4)+"    "+rs.getString(5)+"    "+rs.getString(6));
	    }
	}
	

    //Delete Method
	
	public void delete() throws SQLException
	{
		System.out.println("Enter the user id to be deleted:");
		sql="DELETE FROM user WHERE toppingId = "+input.nextInt();
		connect.createPST(sql).executeUpdate();
	}

}
