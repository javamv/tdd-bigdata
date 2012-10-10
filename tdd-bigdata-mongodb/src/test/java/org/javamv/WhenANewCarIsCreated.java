package org.javamv;

import com.lordofthejars.nosqlunit.annotation.ShouldMatchDataSet;
import com.lordofthejars.nosqlunit.annotation.UsingDataSet;
import com.lordofthejars.nosqlunit.core.LoadStrategyEnum;
import com.lordofthejars.nosqlunit.mongodb.ManagedMongoDb;
import com.lordofthejars.nosqlunit.mongodb.MongoDbRule;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;

import javax.smartcardio.Card;

import static com.lordofthejars.nosqlunit.mongodb.ManagedMongoDb.MongoServerRuleBuilder.newManagedMongoDbRule;
import static com.lordofthejars.nosqlunit.mongodb.MongoDbRule.MongoDbRuleBuilder.newMongoDbRule;

/**
 * Created with IntelliJ IDEA.
 * User: VMoskalenko
 * Date: 10/8/12
 * Time: 3:48 PM
 */
public class WhenANewCarIsCreated {

	@ClassRule
	public static ManagedMongoDb managedMongoDb = newManagedMongoDbRule().mongodPath("D:\\distr\\mongodb")
			.targetPath("D:\\tmp\\data")
			.dbRelativePath("mongo")
			.switchOffConsoleLogger()
			.build();

	@Rule
	public MongoDbRule remoteMongoDbRule = newMongoDbRule().defaultManagedMongoDb("test");

	@Test
	@UsingDataSet(locations = "initialCarData.json", loadStrategy = LoadStrategyEnum.CLEAN_INSERT)
	@ShouldMatchDataSet(location = "expectedCarData.json")
	public void should_be_inserted_into_repository() {
		CarManager carManager = new CarManager();
	    carManager.insertNewCar(new Car("Toyota", "Corolla", 2010, 17000, "USD"));
	}

}
