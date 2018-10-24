package com.javarnd.pizza_order_system.dao;

import java.sql.SQLException;

public interface UserDao 
{
	public void insert(String username, String pizzatype, String pizzasize, String toppingtype, int pizzaprice, int toppingprice) throws SQLException;
	
	public void select() throws SQLException;
	
	public void delete() throws SQLException;
}
