package tdd.example;

import com.lordofthejars.nosqlunit.annotation.ShouldMatchDataSet;
import com.lordofthejars.nosqlunit.annotation.UsingDataSet;
import com.lordofthejars.nosqlunit.cassandra.CassandraRule;
import com.lordofthejars.nosqlunit.cassandra.EmbeddedCassandra;
import com.lordofthejars.nosqlunit.core.LoadStrategyEnum;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;

import static com.lordofthejars.nosqlunit.cassandra.CassandraRule.CassandraRuleBuilder.newCassandraRule;
import static com.lordofthejars.nosqlunit.cassandra.EmbeddedCassandra.EmbeddedCassandraRuleBuilder.newEmbeddedCassandraRule;

/**
 * Created with IntelliJ IDEA.
 * User: VMoskalenko
 * Date: 10/10/12
 * Time: 11:33 AM
 */
public class WhenPersonCreateNewCar {

	//@ClassRule
	//public static EmbeddedCassandra embeddedCassandra = newEmbeddedCassandraRule().build();
//
//	@Rule
//	public CassandraRule cassandraRule = newCassandraRule().defaultEmbeddedCassandra("test");
//
//	@Test
//	@UsingDataSet(locations = "initialCarData.json", loadStrategy = LoadStrategyEnum.CLEAN_INSERT)
//	@ShouldMatchDataSet(location = "expectedCarData.json")
//	public void should_be_inserted_into_repository() {
//		CarManager carManager = new CarManager();
//		carManager.insertNewCar(new Car("Toyota", "Corolla", "2009", 17000, "USD"));
//	}

}
