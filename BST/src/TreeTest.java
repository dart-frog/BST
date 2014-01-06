import static org.junit.Assert.*;

import java.util.ArrayList;

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
		//assertEquals("test proper construct", true, validateTree(t)); 
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
	@Test
	public void deleteTest2(){
		Tree t = new Tree(5);
		t.insert(3);
		t.insert(2);
		t.insert(8);
		t.insert(6);
		t.insert(12);
		t.insert(11);
		t.insert(4);
		t.delete(5);
		assertEquals("can delete granddad", false, t.exists(5));
	}
	@Test
	public void deleteTest3(){
		Tree t = new Tree(5);
		t.insert(3);
		t.insert(2);
		t.insert(8);
		t.insert(6);
		t.insert(12);
		t.insert(11);
		t.insert(4);
		t.delete(3);
		assertEquals("can delete two child node", false, t.exists(3));
		assertEquals("four still exists", true, t.exists(4));
	}
	@Test
	public void sortTest(){
		Tree t = new Tree(5);
		t.insert(3);
		t.insert(2);
		t.insert(8);
		t.insert(6);
		t.insert(12);
		t.insert(11);
		t.insert(4);
		t.delete(8);
		t.delete(6);
		System.out.print(t.sort());
		assertEquals("can sort a binary tree", true, t.sort());
	}
	private Boolean validateTree(Tree t){
		ArrayList<Integer> x = t.sort();
		for (int i = 1; i < x.size(); i++){
			if (x.get(i) < x.get(i -1))
					return false;
		}
		return true;
	}
	

}
