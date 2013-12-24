
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
		return leftChild;
	}
	public void setRightChild(int n){
		rightChild = new Nexus(n);
	}
	public void setLeftChild(int n){
		leftChild = new Nexus(n);
	}
}
