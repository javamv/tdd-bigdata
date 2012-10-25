package org.javamv;

import com.lordofthejars.nosqlunit.annotation.ShouldMatchDataSet;
import com.lordofthejars.nosqlunit.annotation.UsingDataSet;
import com.lordofthejars.nosqlunit.core.LoadStrategyEnum;
import com.lordofthejars.nosqlunit.mongodb.*;
import org.javamv.Car;
import org.javamv.CarManager;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;

import javax.smartcardio.Card;

import static com.lordofthejars.nosqlunit.mongodb.InMemoryMongoDbConfigurationBuilder.inMemoryMongoDb;
import static com.lordofthejars.nosqlunit.mongodb.ManagedMongoDb.MongoServerRuleBuilder.newManagedMongoDbRule;
import static com.lordofthejars.nosqlunit.mongodb.MongoDbRule.MongoDbRuleBuilder.newMongoDbRule;

/**
 * Created with IntelliJ IDEA.
 * User: VMoskalenko
 * Date: 10/8/12
 * Time: 3:48 PM
 */
// 1. Repeat steps described in When A New Car is created
public class WhenANewCarIsCreatedEmbedded {

	// 5.3 For embedded mode you need mongo db in-memory mock
	@ClassRule
	public static InMemoryMongoDb inMemoryMongoDb = new InMemoryMongoDb();

	// 5.2 You can try embedded mode to speed up your test suite
	@Rule
	public MongoDbRule remoteMongoDbRule = new MongoDbRule(inMemoryMongoDb().databaseName("test").build());

	@Test
	@UsingDataSet(locations = "initialCarData.json", loadStrategy = LoadStrategyEnum.CLEAN_INSERT)
	@ShouldMatchDataSet(location = "expectedCarData.json")
	public void should_be_inserted_into_repository() {
		CarManager carManager = new CarManager("0.0.0.0", 2307);
	    carManager.insertNewCar(new Car("Toyota", "Corolla", 2010, 17000, "USD"));
	}

}
