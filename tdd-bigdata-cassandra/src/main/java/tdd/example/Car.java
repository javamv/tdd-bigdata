package tdd.example;

public class Car {
	private final String brand;
	private final String model;
	private final String year;
	private final int price;
	private final String currency;

	public Car(String brand, String model, String year, int price, String currency) {
		this.brand = brand;
		this.model = model;
		this.year = year;
		this.price = price;
		this.currency = currency;
	}

	public String getBrand() {
		return brand;
	}

	public String getModel() {
		return model;
	}

	public String getYear() {
		return year;
	}

	public int getPrice() {
		return price;
	}

	public String getCurrency() {
		return currency;
	}
}
