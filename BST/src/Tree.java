
public class Tree {
	private Nexus granddad; 
	public Tree(Nexus granddad){
		this.granddad = granddad;
	}
	public void add(int n){
	
	}
	public int get(int n){
		return 0;
		
	}
	public void tunnel(Nexus nex  ,int n){
		Nexus x = new Nexus(n);
		if (nex.get() >= x.get()){
			if (nex.getRightChild() == null){
				nex.setRightChild(x.get());
			}
			else{
				tunnel(nex.getRightChild(), n);
			}
		}
	}
	
}
