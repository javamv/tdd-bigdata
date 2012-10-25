package wordcount.unit;

import java.util.ArrayList;

import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import static junit.framework.Assert.*;

/**
 * A demonstration class to get a feel for speed of parameterized tests
 * @author jheintz
 *
 */
@RunWith(value = Parameterized.class)
public class ManyWordTest {

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
	public ManyWordTest(int number) {
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
		int size = 100;
		Collection<Object[]> results = new ArrayList<Object[]>(size);
		for (int i = 1; i < size; i++) { // zero gets messed up, test separately
			results.add(new Object[] { i });
		}
		return results;
	}

	@Test
	public void testDoNothing() {
		assertNotNull(input);
		assertNotNull(value);
		assertTrue(count>0);
	}

}