package wordcount.unit;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * See the <a href="https://cwiki.apache.org/confluence/display/MRUNIT/Index">MRUnit Wiki</a> for more information.
 */
public class WordCountTest extends AbstractWordCount {
   @Test
   public void testMapper() {
      mapDriver.withInput(new LongWritable(1), new Text("cat cat dog"));
      mapDriver.withOutput(new Text("cat"), new LongWritable(1));
      mapDriver.withOutput(new Text("cat"), new LongWritable(1));
      mapDriver.withOutput(new Text("dog"), new LongWritable(1));
      mapDriver.runTest();
   }

   @Test
   public void testReducer() {
      List<LongWritable> values = new ArrayList<LongWritable>();
      values.add(new LongWritable(1));
      values.add(new LongWritable(1));
      reduceDriver.withInput(new Text("cat"), values);
      reduceDriver.withOutput(new Text("cat"), new LongWritable(2));
      reduceDriver.runTest();
   }

   @Test
   public void testMapReduce() {
      mapReduceDriver.withInput(new LongWritable(1), new Text("cat cat dog"));
      mapReduceDriver.addOutput(new Text("cat"), new LongWritable(2));
      mapReduceDriver.addOutput(new Text("dog"), new LongWritable(1));
      mapReduceDriver.runTest();
   }
}
