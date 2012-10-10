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
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created with IntelliJ IDEA.
 * User: VMoskalenko
 * Date: 10/10/12
 * Time: 7:23 PM
 */
public class WhenPersonSearchesCar {

	@ClassRule
	public static EmbeddedCassandra embeddedCassandra = newEmbeddedCassandraRule().build();

	@Rule
	public CassandraRule cassandraRule = newCassandraRule().defaultEmbeddedCassandra("test");

	@Test
	@UsingDataSet(locations = "expectedCarData.json", loadStrategy = LoadStrategyEnum.CLEAN_INSERT)
	public void should_find_one_car_by_year() {
		CarManager carManager = new CarManager();
		assertThat(carManager.getCarByYearKey(2010).getBrand(), is("Nissan"));
	}

}
