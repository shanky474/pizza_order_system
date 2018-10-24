package com.javarnd.pizza_order_system;

import java.sql.SQLException;
import java.util.Scanner;

import com.javarnd.pizza_order_system.dao.PizzaDaoImpl;
import com.javarnd.pizza_order_system.dao.ToppingDaoImpl;
import com.javarnd.pizza_order_system.dao.UserDaoImpl;

/**
 * Hello world!
 *
 */
public class MainOperations 
{
    public static void main( String[] args )
    {
       new PizzaDatabaseConnection().PizzaDatabaseConnection("pizzadatabase", "root", "root");
       PizzaDaoImpl pizza = new PizzaDaoImpl();
       ToppingDaoImpl topping = new ToppingDaoImpl();
       UserDaoImpl user = new UserDaoImpl();
       Scanner input = new Scanner(System.in);
       String username;
       int pizzaId;
       String pizzasize;
       int toppingId;
       try {
    	System.out.println("-------------------Pizza---------------------");
        pizza.select();
        System.out.println("-------------------Topping---------------------");
        topping.select();
        System.out.println("Enter Username:");
        username=input.next();
        System.out.println("Enter Pizza Id:");
        pizzaId=input.nextInt();
        System.out.println("Enter Pizza Size:");
        pizzasize=input.next();
        System.out.println("Enter Topping Id:");
        toppingId=input.nextInt();
        user.insert(username, pizza.select("type", pizzaId), pizzasize, topping.select("type", toppingId), Integer.parseInt(pizza.select(pizzasize, pizzaId)), Integer.parseInt(topping.select("price", toppingId)));
        System.out.println("---------------------User-------------------"); 
        user.select();
       } catch (SQLException e) {
		e.printStackTrace();
	}
    }
}
