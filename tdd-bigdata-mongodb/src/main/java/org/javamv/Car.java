package org.javamv;

/**
 * Created with IntelliJ IDEA.
 * User: VMoskalenko
 * Date: 10/8/12
 * Time: 5:29 PM
 */
public class Car {

	private String brand;
	private String model;
	private int year;
	private int price;
	private String currency;

	public String getBrand() {
		return brand;
	}

	public String getModel() {
		return model;
	}

	public int getYear() {
		return year;
	}

	public int getPrice() {
		return price;
	}

	public String getCurrency() {
		return currency;
	}

	public Car(String brand, String model, int year, int price, String currency) {
		this.brand = brand;
		this.model = model;
		this.year = year;
		this.price = price;
		this.currency = currency;
	}
}
