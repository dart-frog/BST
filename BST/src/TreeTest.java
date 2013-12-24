import static org.junit.Assert.*;

import org.junit.Test;


public class TreeTest {

	@Test
	public void test() {
		Tree t = new Tree(5);
		t.insert(4);
		t.insert(2);
		t.insert(8);
		t.insert(6);
		t.insert(12);
		assertEquals("test exists method" , true , t.exists(12));
	}
	@Test
	public void deleteTest(){
		Tree t = new Tree(5);
		t.insert(4);
		t.insert(2);
		t.insert(8);
		t.insert(6);
		t.insert(12);
		t.delete(12);
		assertEquals("test delete method", false, t.exists(12));
	}

}
