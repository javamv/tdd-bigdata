package wordcount.integration;

import java.io.IOException;

import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.fs.PathFilter;
import org.apache.hadoop.mapred.ClusterMapReduceTestCase;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

/**
 * Configure for JUnit4
 */

@RunWith(BlockJUnit4ClassRunner.class)
public abstract class HadoopClusterBase extends ClusterMapReduceTestCase {
	final static Logger logger = Logger
			.getLogger(HadoopClusterBase.class);

	private PathFilter outputPathFilter = new PathFilter() {
		public boolean accept(Path path) {
			return (path.getName().startsWith("part-"));
		}
	};

	public PathFilter getOutputPathFilter() {
		return outputPathFilter;
	}

	public void setOutputPathFilter(PathFilter outputPathFilter) {
		this.outputPathFilter = outputPathFilter;
	}

	@Before
	public void setUp() throws Exception {
		if (System.getProperty("hadoop.log.dir") == null)
			System.setProperty("hadoop.log.dir", System.getProperty("java.io.tmpdir", "./target"));
		
		if (System.getProperty("hadoop.log.file") == null)
			System.setProperty("hadoop.log.file", "hadoop.log");
		
		if (System.getProperty("hadoop.root.logger") == null)
			System.setProperty("hadoop.root.logger", "DEBUG,console");

		LogManager.getRootLogger().setLevel(Level.toLevel("DEBUG"));
		LogManager.getLogger("org.mortbay").setLevel(Level.toLevel("WARN"));

		super.setUp();
	}

	@After
	public void tearDown() throws Exception {
		super.tearDown();
	}

	public void createTextFileInHDFS(String inputData, Path filePath) throws IOException {
		FileSystem fs = getFileSystem();
		FSDataOutputStream out = null;
		try {
			out = fs.create(filePath, false);
			out.write(inputData.getBytes(), 0, inputData.getBytes().length);
			out.close();
		} finally {
			if (out != null) {
				out.close();
			}
		}
	}
}