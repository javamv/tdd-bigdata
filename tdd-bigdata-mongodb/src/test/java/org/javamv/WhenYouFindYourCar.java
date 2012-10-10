package org.javamv;

import com.lordofthejars.nosqlunit.annotation.UsingDataSet;
import com.lordofthejars.nosqlunit.core.LoadStrategyEnum;
import com.lordofthejars.nosqlunit.mongodb.ManagedMongoDb;
import com.lordofthejars.nosqlunit.mongodb.MongoDbRule;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;

import static com.lordofthejars.nosqlunit.mongodb.ManagedMongoDb.MongoServerRuleBuilder.newManagedMongoDbRule;
import static com.lordofthejars.nosqlunit.mongodb.MongoDbRule.MongoDbRuleBuilder.newMongoDbRule;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created with IntelliJ IDEA.
 * User: VMoskalenko
 * Date: 10/10/12
 * Time: 7:45 AM
 */
public class WhenYouFindYourCar {

	@ClassRule
	public static ManagedMongoDb managedMongoDb = newManagedMongoDbRule().mongodPath("D:\\distr\\mongodb")
			.targetPath("D:\\tmp\\data")
			.dbRelativePath("mongo")
			.switchOffConsoleLogger()
			.build();

	@Rule
	public MongoDbRule remoteMongoDbRule = newMongoDbRule().defaultManagedMongoDb("test");

	@Test
	@UsingDataSet(locations = "expectedCarData.json", loadStrategy = LoadStrategyEnum.CLEAN_INSERT)
	public void should_find_by_year() {
		CarManager carManager = new CarManager();
		assertThat(carManager.findAllByYear(2009).size(), is(1));
		assertThat(carManager.findAllByYear(2009).get(0).getBrand(), is("Nissan"));
	}
}
