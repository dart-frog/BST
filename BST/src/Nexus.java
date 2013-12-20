
public class Nexus {
	Nexus leftChild = null;
	Nexus rightChild = null;
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
		return rightChild;
	}
	public void setRightChild(int n){
		rightChild.setRightChild(n);
	}
	public void setLeftChild(int n){
		leftChild.setLeftChild(n);
	}
}
