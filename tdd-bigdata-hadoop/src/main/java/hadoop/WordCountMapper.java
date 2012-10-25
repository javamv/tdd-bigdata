package hadoop;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class WordCountMapper extends Mapper<LongWritable, Text, Text, LongWritable> {
	
    @Override
    protected void map(LongWritable offset, Text text, Context context) throws IOException, InterruptedException {
/*       for (String token : text.toString().split("\\s+")) {
          context.write(new Text(token), new LongWritable(1));
       }*/
    }
 }