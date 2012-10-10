package integration;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;


@RunWith(value = Parameterized.class)
public class MultipleClusterIT extends HadoopClusterBase {

	public MultipleClusterIT(int ignore) {
	}

	@Parameters
	public static Collection<Object[]> data() {
		int size = 50;
		Collection<Object[]> results = new ArrayList<Object[]>(size);
		for (int i = 1; i < size; i++) { // zero gets messed up, test separately
			results.add(new Object[] { i });
		}
		return results;
	}

	/**
	 * Just test the machinery works... startup and shutdown.
	 */
	@Test
	public void smokeTest() {
		System.out.println("success!");
	}
}
