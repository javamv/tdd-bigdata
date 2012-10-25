package wordcount.unit;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(value = Parameterized.class)
public class ManyWordCountTest extends AbstractWordCount {

	private String input;
	private String value;
	private int count;

	/**
	 * Build input data based on number argument.
	 * 
	 * number=4 would result in "4 4 4 4 "
	 * 
	 * @param number
	 */
	public ManyWordCountTest(int number) {
		count = number;
		value = Integer.toString(number);

		StringBuffer buff = new StringBuffer();
		for (int i = 0; i < number; i++) {
			buff.append(value);
			buff.append(' ');
		}
		
		input = buff.toString();
	}

	@Parameters
	public static Collection<Object[]> data() {
		int size = 1000;
		Collection<Object[]> results = new ArrayList<Object[]>(size);
		for (int i = 1; i < size; i++) { // zero gets messed up, test separately
			results.add(new Object[] { i });
		}
		return results;
	}

	@Test
	public void testMapReduce() {
		mapReduceDriver.withInput(new LongWritable(1), new Text(input));
		mapReduceDriver.addOutput(new Text(value), new LongWritable(count));
		mapReduceDriver.runTest();
	}

}