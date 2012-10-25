package wordcount.unit;

import hadoop.WordCountMapper;
import hadoop.WordCountReducer;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mrunit.mapreduce.MapDriver;
import org.apache.hadoop.mrunit.mapreduce.MapReduceDriver;
import org.apache.hadoop.mrunit.mapreduce.ReduceDriver;
import org.junit.Before;

public class AbstractWordCount {

	protected MapReduceDriver<LongWritable, Text, Text, LongWritable, Text, LongWritable> mapReduceDriver;
	protected MapDriver<LongWritable, Text, Text, LongWritable> mapDriver;
	protected ReduceDriver<Text, LongWritable, Text, LongWritable> reduceDriver;

	@Before
	public void setUp() {
		WordCountMapper mapper = new WordCountMapper();
		WordCountReducer reducer = new WordCountReducer();
		mapDriver = new MapDriver<LongWritable, Text, Text, LongWritable>();
		mapDriver.setMapper(mapper);
		reduceDriver = new ReduceDriver<Text, LongWritable, Text, LongWritable>();
		reduceDriver.setReducer(reducer);
		mapReduceDriver = new MapReduceDriver<LongWritable, Text, Text, LongWritable, Text, LongWritable>();
		mapReduceDriver.setMapper(mapper);
		mapReduceDriver.setReducer(reducer);
	}

}