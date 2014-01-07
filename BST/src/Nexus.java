
public class Nexus {
	public Nexus leftChild = null;
	public Nexus rightChild = null;
	int n;
	public Nexus(int n){
		this.n = n;
	}
	public int get(){
		return n;
	}
	public Nexus getRightChild(){
		return rightChild;
	}
	public Nexus getLeftChild(){
		return leftChild;
	}
	public void setRightChild(int n){
		rightChild = new Nexus(n);
	}
	public void setLeftChild(int n){
		leftChild = new Nexus(n);
	}
	public void setLeftChildNull(){
		leftChild = null;
	}
	public void setRightChildNull(){
		rightChild = null;
	}
	public void setAs(Nexus nex){
		n = nex.get();
		if (nex.getLeftChild() != null){
			leftChild = nex.leftChild;
		}
		if (nex.getRightChild() != null){
			rightChild = nex.rightChild;
		}
		
	}
}
