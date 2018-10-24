package com.javarnd.pizza_order_system.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.javarnd.pizza_order_system.PizzaDatabaseConnection;
import com.jdbc.pizza_order_system.model.pizza;
import com.mysql.jdbc.PreparedStatement;

public class PizzaDaoImpl 
{
	Scanner input = new Scanner(System.in);
	PizzaDatabaseConnection connect = new PizzaDatabaseConnection();
	pizza pizza = new pizza();
	String sql;
	
	//Insert Method
	
	public void insert() throws SQLException
	{
		sql="INSERT INTO pizza VALUES (NULL,?,?,?,?)";
		PreparedStatement stmt = connect.createPST(sql);
		System.out.println("Enter pizza type:");
		pizza.setType(input.next());
		System.out.println("Enter small size price:");
		pizza.setSmall(input.nextInt());
		System.out.println("Enter medium size price:");
		pizza.setMedium(input.nextInt());
		System.out.println("Enter large size price:");
		pizza.setLarge(input.nextInt());
		stmt.setString(1, pizza.getType());
		stmt.setInt(2, pizza.getSmall());
		stmt.setInt(3, pizza.getMedium());
		stmt.setInt(4, pizza.getLarge());
		stmt.executeUpdate();
	}

	//Select Method
	
	public void select() throws SQLException
	{
		sql = "SELECT * FROM pizza";
		PreparedStatement stmt = connect.createPST(sql);
		ResultSet rs = stmt.executeQuery();
		while(rs.next())
		{
		System.out.println(rs.getString(1)+"    "+rs.getString(2)+"    "+rs.getString(3)+"    "+rs.getString(4)+"    "+rs.getString(5));
	    }
	}
	
	//Update Method
	
	public void update() throws SQLException
	{
		System.out.println("Enter the pizza id to be updated:");
		int pizzaId = input.nextInt();
		System.out.println("Enter the field to be updated:");
		String field = input.next();
		System.out.println("Enter the value with which it is to be updated:");
		sql="UPDATE pizza set "+ field +" = ? where pizzaId = ?";
		PreparedStatement stmt = connect.createPST(sql);
		stmt.setInt(1,input.nextInt());
		stmt.setInt(2, pizzaId);
		stmt.executeUpdate();
	}

    //Delete Method
	
	public void delete() throws SQLException
	{
		System.out.println("Enter the pizza id to be deleted:");
		sql="DELETE FROM pizza WHERE pizzaId = "+input.nextInt();
		connect.createPST(sql).executeUpdate();
	}

	//Conditional Select Method
	
	public String select(String field, int pizzaId) throws SQLException
	{
		sql = "SELECT "+field+" FROM pizza where pizzaId ="+ pizzaId;
		PreparedStatement stmt = connect.createPST(sql);
		ResultSet rs = stmt.executeQuery();
		String str=null;
		while(rs.next())
		str = rs.getString(1);
		return str;
	}
}
