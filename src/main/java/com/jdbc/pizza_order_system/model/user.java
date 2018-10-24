package com.jdbc.pizza_order_system.model;

public class user 
{
String username;
String pizzatype;
String pizzasize;
public String getPizzasize() {
	return pizzasize;
}
public void setPizzasize(String pizzasize) {
	this.pizzasize = pizzasize;
}
String toppingtype;
int totalprice;
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPizzatype() {
	return pizzatype;
}
public void setPizzatype(String pizzatype) {
	this.pizzatype = pizzatype;
}
public String getToppingtype() {
	return toppingtype;
}
public void setToppingtype(String toppingtype) {
	this.toppingtype = toppingtype;
}
public int getTotalprice() {
	return totalprice;
}
public void setTotalprice(int totalprice) {
	this.totalprice = totalprice;
}

}
