package wordcount.integration;

import hadoop.WordCountMapper;
import hadoop.WordCountReducer;
import hadoop.WordCountRunner;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.FileInputFormat;
import org.apache.hadoop.mapred.FileOutputFormat;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class ClusterIT extends HadoopClusterBase {

	/**
	 * Just test the machinery works... startup and shutdown.
	 */
	@Test
	public void smokeTest() {
		System.out.println("success!");
	}

	@Test
	public void mapReduceJob() throws Exception {
		createTextFileInHDFS("one two two", new Path(getInputDir(), "input"));
		HashMap<String, String> expected = new HashMap<String, String>();
		expected.put("one", "1");
		expected.put("two", "2");

		JobConf jobConf = createJobConf();
		FileInputFormat.setInputPaths(jobConf, getInputDir());
		FileOutputFormat.setOutputPath(jobConf, getOutputDir());

		Job job = new Job(jobConf, "Word Count");
		job.setJarByClass(WordCountRunner.class);

		job.setMapperClass(WordCountMapper.class);
		job.setCombinerClass(WordCountReducer.class);
		job.setReducerClass(WordCountReducer.class);

		job.setInputFormatClass(TextInputFormat.class);
		job.setOutputFormatClass(TextOutputFormat.class);

		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(LongWritable.class);

		assertTrue(job.waitForCompletion(true));

		FileStatus[] outputs = this.getFileSystem().listStatus(getOutputDir(), getOutputPathFilter());
		for (FileStatus fileStatus : outputs) {
			FSDataInputStream is = getFileSystem().open(fileStatus.getPath());
			try {
				String line = new BufferedReader(new InputStreamReader(is)).readLine();
				while (line != null) {
					String[] result = line.split("\t");
					String word = result[0];
					String count = result[1];

					assertEquals(expected.get(word), count);
					line = new BufferedReader(new InputStreamReader(is)).readLine();
				}
			} finally {
				is.close();
			}
		}
	}
}
