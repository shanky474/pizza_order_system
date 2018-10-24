package com.javarnd.pizza_order_system.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import com.javarnd.pizza_order_system.PizzaDatabaseConnection;
import com.jdbc.pizza_order_system.model.topping;
import com.mysql.jdbc.PreparedStatement;

public class ToppingDaoImpl 
{
	Scanner input = new Scanner(System.in);
	PizzaDatabaseConnection connect = new PizzaDatabaseConnection();
	topping topping = new topping();
	String sql;
	
	//Insert Method
	
	public void insert() throws SQLException
	{
		sql="INSERT INTO topping VALUES (NULL,?,?)";
		PreparedStatement stmt = connect.createPST(sql);
		System.out.println("Enter topping type:");
		topping.setType(input.next());
		System.out.println("Enter price:");
		topping.setPrice(input.nextInt());
		stmt.setString(1, topping.getType());
		stmt.setInt(2, topping.getPrice());
		stmt.executeUpdate();
	}

	//Select Method
	
	public void select() throws SQLException
	{
		sql = "SELECT * FROM topping";
		PreparedStatement stmt = connect.createPST(sql);
		ResultSet rs = stmt.executeQuery();
		while(rs.next())
		{
		System.out.println(rs.getString(1)+"    "+rs.getString(2)+"    "+rs.getString(3));
	    }
	}
	
	//Update Method
	
	public void update() throws SQLException
	{
		System.out.println("Enter the topping id to be updated:");
		int toppingId = input.nextInt();
		System.out.println("Enter the field to be updated:");
		String field = input.next();
		System.out.println("Enter the value with which it is to be updated:");
		sql="UPDATE topping set "+ field +" = ? where pizzaId = ?";
		PreparedStatement stmt = connect.createPST(sql);
		stmt.setInt(1,input.nextInt());
		stmt.setInt(2, toppingId);
		stmt.executeUpdate();
	}

    //Delete Method
	
	public void delete() throws SQLException
	{
		System.out.println("Enter the topping id to be deleted:");
		sql="DELETE FROM topping WHERE toppingId = "+input.nextInt();
		connect.createPST(sql).executeUpdate();
	}

	//Conditional Select Method
	
	public String select(String field, int toppingId) throws SQLException
	{
		sql = "SELECT "+field+" FROM topping where toppingId ="+ toppingId;
		PreparedStatement stmt = connect.createPST(sql);
		ResultSet rs = stmt.executeQuery();
		String str=null;
		while(rs.next())
		str = rs.getString(1);
		return str;
	}
}
