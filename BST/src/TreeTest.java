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
		t.insert(11);
		t.delete(12);
		t.delete(4);
		assertEquals("no child delete method", false, t.exists(12));
		assertEquals("left child delete method", false, t.exists(12));
		assertEquals("11 is still left", true, t.exists(11));
		assertEquals("right child delete method", false, t.exists(4));
		assertEquals("2 is still left", true, t.exists(2));
	}

}
