import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
/**
 *
 * @author Thibault Langlois
 */
public class Test {

	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;
	private final PrintStream originalErr = System.err;

	@Before
	public void setUpStreams() {
		System.setOut(new PrintStream(outContent));
		System.setErr(new PrintStream(errContent));
	}

	@After
	public void restoreStreams() {
		System.setOut(originalOut);
		System.setErr(originalErr);
	}

	@org.junit.Test
	public void test1() throws FileNotFoundException {
		String [] args = {"exemplo1.txt"};
		RunSudoku.main(args);
		assertEquals("O jogo respeita as regras do Sudoku." + System.lineSeparator(), outContent.toString());
	}

	@org.junit.Test
	public void test2() throws FileNotFoundException {
		String [] args = {"exemplo2.txt"};
		RunSudoku.main(args);
		assertEquals("O puzzle seguinte está errado:" + System.lineSeparator() +
				"+-----+-----+-----+" + System.lineSeparator() + 
				"|3 1 6|7 4 9|8 5 2|" + System.lineSeparator() + 
				"|5 7 4|1 8 2|6 3 9|" + System.lineSeparator() + 
				"|8 2 9|3 5 6|1 4 7|" + System.lineSeparator() + 
				"+-----+-----+-----+" + System.lineSeparator() + 
				"|9 3 5|4 1 7|2 8 6|" + System.lineSeparator() + 
				"|2 8 1|6 9 3|5 7 4|" + System.lineSeparator() + 
				"|4 6 7|8 2 5|3 9 1|" + System.lineSeparator() + 
				"+-----+-----+-----+" + System.lineSeparator() + 
				"|6 9 8|2 3 4|7 1 5|" + System.lineSeparator() + 
				"|1 5 2|9 7 8|4 6 3|" + System.lineSeparator() + 
				"|3 4 7|5 6 1|9 2 8|" + System.lineSeparator() + 
				"+-----+-----+-----+" + System.lineSeparator(), outContent.toString());
	}
	@org.junit.Test
	public void test3() throws FileNotFoundException {
		String [] args = {"exemplo3.txt"};
		RunSudoku.main(args);
		assertEquals("O puzzle seguinte está errado:" + System.lineSeparator() + 
				"+-----+-----+-----+" + System.lineSeparator() + 
				"|3 1 6|7 4 9|8 5 3|" + System.lineSeparator() + 
				"|5 7 4|1 8 2|6 3 9|" + System.lineSeparator() + 
				"|8 2 9|3 5 6|1 4 7|" + System.lineSeparator() + 
				"+-----+-----+-----+" + System.lineSeparator() + 
				"|9 3 5|4 1 7|2 8 6|" + System.lineSeparator() + 
				"|2 8 1|6 9 3|5 7 4|" + System.lineSeparator() + 
				"|4 6 7|8 2 5|3 9 1|" + System.lineSeparator() + 
				"+-----+-----+-----+" + System.lineSeparator() + 
				"|6 9 8|2 3 4|7 1 5|" + System.lineSeparator() + 
				"|1 5 2|9 7 8|4 6 2|" + System.lineSeparator() + 
				"|7 4 3|5 6 1|9 2 8|" + System.lineSeparator() + 
				"+-----+-----+-----+" + System.lineSeparator(), outContent.toString());
	}

	@org.junit.Test
	public void test4() throws FileNotFoundException {
		String [] args = {"exemplo4.txt"};
		RunSudoku.main(args);
		assertEquals("O puzzle seguinte está errado:" + System.lineSeparator() +
				"+-----+-----+-----+" + System.lineSeparator() +
				"|3 1 6|7 4 9|8 5 2|" + System.lineSeparator() +
				"|5 7 4|1 8 2|6 3 9|" + System.lineSeparator() +
				"|8 2 3|9 5 6|1 4 7|" + System.lineSeparator() +
				"+-----+-----+-----+" + System.lineSeparator() +
				"|9 3 5|4 1 7|2 8 6|" + System.lineSeparator() +
				"|2 8 1|6 9 3|5 7 4|" + System.lineSeparator() +
				"|4 6 7|8 2 5|3 9 1|" + System.lineSeparator() +
				"+-----+-----+-----+" + System.lineSeparator() +
				"|6 9 8|2 3 4|7 1 5|" + System.lineSeparator() +
				"|1 5 2|9 7 8|4 6 3|" + System.lineSeparator() +
				"|7 4 3|5 6 1|9 2 8|" + System.lineSeparator() +
				"+-----+-----+-----+" + System.lineSeparator(), outContent.toString());
	}
}
