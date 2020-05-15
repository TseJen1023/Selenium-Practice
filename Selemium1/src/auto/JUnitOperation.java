package auto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class JUnitOperation{

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.out.println("Before Class...") ;
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		System.out.println("After Class...") ;
	}

	@BeforeEach
	void setUp() throws Exception {
		System.out.println("Before...") ;
	}

	@AfterEach
	void tearDown() throws Exception {
		System.out.println("After...") ;
	}

	@Test
	void test1() {
		System.out.println("Test1...") ;
		//fail("Not yet implemented 1");
	}
	
	@Test
	void test2() {
		System.out.println("Test2...") ;
		//fail("NOt yet implemented 2") ;
	}

}
