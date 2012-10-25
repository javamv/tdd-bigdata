package wordcount.unit;

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
// Step 1. Start defining tests class. Name can describe scenario
public class WordCountTdd {

	// Step 3.1 MapReduceDriver is used to host hadoop map-reduce and validate results
	protected MapReduceDriver<LongWritable, Text, Text, LongWritable, Text, LongWritable> mapReduceDriver;

	// Step 6. Setup MapReduceDriver to have a complete test
/*	@Before
	public void setUp() {
		WordCountMapper mapper = new WordCountMapper();
		WordCountReducer reducer = new WordCountReducer();
		mapReduceDriver = new MapReduceDriver<LongWritable, Text, Text, LongWritable, Text, LongWritable>();
		mapReduceDriver.setMapper(mapper);
		mapReduceDriver.setReducer(reducer);
	}*/

	// Step 2. Start with defining your test. Use "_" between words for better readability
	//@Test
	//public void should_properly_reduce() {
	// Step 5. Start writing preconditions with actual input
	//	mapReduceDriver.withInput(new LongWritable(1), new Text("cat cat dog"));
	// Step 3.2. Write what you want to validate. Remember Assert First pattern
	//	mapReduceDriver.addOutput(new Text("cat"), new LongWritable(2));
	//	mapReduceDriver.addOutput(new Text("dog"), new LongWritable(1));
	// Step 4. Run hadoop map reduce. The test should fail
	//	mapReduceDriver.runTest();
	//}

}
