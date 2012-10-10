package unit;

import hadoop.WordCountMapper;
import hadoop.WordCountReducer;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mrunit.mapreduce.MapReduceDriver;
import org.junit.Before;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: VMoskalenko
 * Date: 10/10/12
 * Time: 1:20 PM
 */
public class WordCountTdd {

	protected MapReduceDriver<LongWritable, Text, Text, LongWritable, Text, LongWritable> mapReduceDriver;

	@Before
	public void setUp() {
		WordCountMapper mapper = new WordCountMapper();
		WordCountReducer reducer = new WordCountReducer();
		mapReduceDriver = new MapReduceDriver<LongWritable, Text, Text, LongWritable, Text, LongWritable>();
		mapReduceDriver.setMapper(mapper);
		mapReduceDriver.setReducer(reducer);
	}

	@Test
	public void should_properly_reduce() {
		mapReduceDriver.withInput(new LongWritable(1), new Text("cat cat dog"));
		mapReduceDriver.addOutput(new Text("cat"), new LongWritable(2));
		mapReduceDriver.addOutput(new Text("dog"), new LongWritable(1));
		mapReduceDriver.runTest();
	}

}
