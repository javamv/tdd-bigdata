package org.javamv;

import com.mongodb.*;
import com.sun.org.apache.xml.internal.utils.StringVector;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: VMoskalenko
 * Date: 10/8/12
 * Time: 5:28 PM
 */
public class CarManager {

	public void insertNewCar(Car car) {
		DB database = getDatabase();

		DBObject carDbObject = new BasicDBObject();
		carDbObject.put("brand", car.getBrand());
		carDbObject.put("model", car.getModel());
		carDbObject.put("year", car.getYear());
		carDbObject.put("price", car.getPrice());
		carDbObject.put("currency", car.getCurrency());
		getCarCollection(database).insert(carDbObject);
	}

	private DBCollection getCarCollection(DB database) {
		return database.getCollection(Car.class.getSimpleName());
	}

	private DB getDatabase() {
		Mongo mongo;
		try {
			mongo = new Mongo("localhost", 27017);
		} catch (UnknownHostException e) {
			throw new RuntimeException(e);
		}

		return mongo.getDB("test");
	}

	public List<Car> findAllByYear(int year) {
		DB database = getDatabase();
		DBObject exampleDbObject= new BasicDBObject();
		exampleDbObject.put("year", year);
		List<DBObject> dbObjects = getCarCollection(database).find(exampleDbObject).toArray();
		return convertDbObjectsToCars(dbObjects);
	}

	private List<Car> convertDbObjectsToCars(List<DBObject> dbObjects) {
		List<Car> carList = new ArrayList<Car>(dbObjects.size());
		for (DBObject dbObject: dbObjects) {
			Car car = new Car(
					dbObject.get("brand").toString(),
					dbObject.get("model").toString(),
					new Integer(dbObject.get("year").toString()),
					new Integer(dbObject.get("price").toString()),
					dbObject.get("currency").toString());
			carList.add(car);
		}
		return carList;
	}
}
