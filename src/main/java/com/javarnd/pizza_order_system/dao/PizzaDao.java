package com.javarnd.pizza_order_system.dao;

import java.sql.SQLException;

public interface PizzaDao 
{

	public void insert() throws SQLException;
	
	public void select() throws SQLException;
	
	public void update() throws SQLException;
	
	public void delete() throws SQLException;
	
}
