package tdd.example;

import me.prettyprint.cassandra.serializers.StringSerializer;
import me.prettyprint.cassandra.service.template.ColumnFamilyResult;
import me.prettyprint.cassandra.service.template.ColumnFamilyTemplate;
import me.prettyprint.cassandra.service.template.ColumnFamilyUpdater;
import me.prettyprint.cassandra.service.template.ThriftColumnFamilyTemplate;
import me.prettyprint.hector.api.Cluster;
import me.prettyprint.hector.api.Keyspace;
import me.prettyprint.hector.api.factory.HFactory;

/**
 * Created with IntelliJ IDEA.
 * User: VMoskalenko
 * Date: 10/10/12
 * Time: 12:20 PM
 */
public class CarManager {
//
//
//	public void insertNewCar(Car car) {
//		ColumnFamilyTemplate<String, String> template = prepareCarTemplate();
//		ColumnFamilyUpdater<String, String> updater = buildCassandraUpdater(car, template);
//		template.update(updater);
//	}
//
//	private ColumnFamilyTemplate<String, String> prepareCarTemplate() {
//		Cluster cluster = HFactory.getOrCreateCluster("test", "localhost");
//		Keyspace keySpace = HFactory.createKeyspace("car", cluster);
//		return new ThriftColumnFamilyTemplate<String, String>(
//				keySpace,
//				"yearOfProduction",
//				StringSerializer.get(),
//				StringSerializer.get()
//		);
//	}
//
//	private ColumnFamilyUpdater<String, String> buildCassandraUpdater(Car car, ColumnFamilyTemplate<String, String> template) {
//		ColumnFamilyUpdater<String, String> updater = template.createUpdater(car.getYear());
//		updater.setString("brand", car.getBrand());
//		updater.setString("model", car.getModel());
//		updater.setString("price", Integer.toString(car.getPrice()));
//		updater.setString("currency", car.getCurrency());
//		return updater;
//	}
//
//	public Car getCarByYearKey(Integer year) {
//		ColumnFamilyTemplate<String, String> template = prepareCarTemplate();
//		ColumnFamilyResult<String, String> result = template.queryColumns(year.toString());
//		return new Car(result.getString("brand"), result.getString("model"), result.getKey(), new Integer(result.getString("price")), result.getString("currency"));
//	}
}
