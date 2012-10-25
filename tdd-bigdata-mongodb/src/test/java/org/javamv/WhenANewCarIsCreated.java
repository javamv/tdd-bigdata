package org.javamv;

import com.lordofthejars.nosqlunit.annotation.ShouldMatchDataSet;
import com.lordofthejars.nosqlunit.annotation.UsingDataSet;
import com.lordofthejars.nosqlunit.core.LoadStrategyEnum;
import com.lordofthejars.nosqlunit.mongodb.ManagedMongoDb;
import com.lordofthejars.nosqlunit.mongodb.MongoDbRule;
import org.javamv.Car;
import org.javamv.CarManager;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;

import static com.lordofthejars.nosqlunit.mongodb.ManagedMongoDb.MongoServerRuleBuilder.newManagedMongoDbRule;
import static com.lordofthejars.nosqlunit.mongodb.MongoDbRule.MongoDbRuleBuilder.newMongoDbRule;

/**
 * Created with IntelliJ IDEA.
 * User: VMoskalenko
 * Date: 10/8/12
 * Time: 3:48 PM
 */
// Step 1. Start defining tests class. Name can describe scenario
public class WhenANewCarIsCreated {

	// Step 5.3. If mongo db has not started, you can put this snippet to start it automatically. Remember managed
	// approach
	//@ClassRule
	/*public static ManagedMongoDb managedMongoDb = newManagedMongoDbRule().mongodPath("D:\\distr\\mongodb")
			.targetPath("D:\\tmp\\data")
			.dbRelativePath("mongo")
			.switchOffConsoleLogger()
			.build();*/

	// Step 5.2 Precondition annotation requires rule, which will take annotation parameters and fill database
	//@Rule
	//public MongoDbRule remoteMongoDbRule = newMongoDbRule().defaultManagedMongoDb("test");

	// Step 2. Start with defining your test. Use "_" between words for better readability
	//@Test
	// Step 5.1 Write preconditions before action. This library allows to do this step using annotation
	//@UsingDataSet(locations = "initialCarData.json", loadStrategy = LoadStrategyEnum.CLEAN_INSERT)
	// Step 3. Define what you expect. This library substitute assertThat() with annotation
	//@ShouldMatchDataSet(location = "expectedCarData.json")
	//public void should_be_inserted_into_repository() {
		// Step 4. Write an action to get expected results
		// CarManager carManager = new CarManager("localhost", 27017);
		// carManager.insertNewCar(new Car("Toyota", "Corolla", 2010, 17000, "USD"));
	//}

}
