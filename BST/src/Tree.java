import java.util.ArrayList;


public class Tree {
	private Nexus granddad; 
	public Tree(int g){
		granddad = new Nexus(g);
	}
	public void insert(int n){
		tunnel(granddad,n);
	}
	public boolean  exists(int n){
		return drill(granddad,n);
	}
	public void delete(int n){
		ArrayList<Nexus> z = improvisedDrill(granddad, n, new ArrayList<Nexus>());
		
		Nexus nex = z.get(z.size() -1);
		//no children
		if (nex.leftChild ==null && nex.rightChild == null){
			if (granddad == nex){
				granddad = null;
			}
			else{
				Nexus parent = z.get(z.size() -2);
				if (parent.getRightChild() == nex){
					parent.setRightChildNull();
				}
				if (parent.getLeftChild() == nex){
					parent.setLeftChildNull();
				}
			}
		}
		//one child
		if (nex.leftChild != null && nex.rightChild == null){
			if (granddad == nex){
				granddad = nex.getLeftChild();
			}
			else{
				Nexus parent = z.get(z.size() -2);
				if (parent.getRightChild() == nex){
					parent.setRightChild(nex.getLeftChild().get());
				}
				if (parent.getLeftChild() == nex){
					parent.setLeftChild(nex.getLeftChild().get());
				}
			}
		}
		if (nex.leftChild == null && nex.rightChild != null){
			if (granddad == nex){
				granddad = nex.getRightChild();
			}
			else{
				Nexus parent = z.get(z.size() -2);
				if (parent.getRightChild() == nex){
					parent.setRightChild(nex.getRightChild().get());
				}
				if (parent.getLeftChild() == nex){
					parent.setLeftChild(nex.getRightChild().get());
				}
			}
		}
		
	}
	private void tunnel(Nexus nex  ,int n){
		if (n >= nex.get()){
			if (nex.getRightChild() == null){
				nex.setRightChild(n);
			}
			else{
				tunnel(nex.getRightChild(), n);
			}
		}
		else{
			if (nex.getLeftChild() == null){
				nex.setLeftChild(n);
			}
			else{
				tunnel(nex.getLeftChild(), n);
			}
		}
	}
	private boolean drill(Nexus nex ,int n){
		if (nex.get() == n){
			return true;
		}
		
		if (n >= nex.get() ){
			if (nex.getRightChild() == null){
				return false;
			}
			else{
				return drill(nex.getRightChild(), n);
			}
		}
		else{
			if (nex.getLeftChild() == null){
				return false; 
			}
			else{
				return drill(nex.getLeftChild(), n);
			}
		}
		
	}
	private ArrayList<Nexus> improvisedDrill(Nexus nex ,int n, ArrayList<Nexus> x){
		if (nex.get() == n){
			x.add(nex);
			return x;
		}
		
		if (n >= nex.get() ){
			if (nex.getRightChild() == null){
				return null;
			}
			else{
				x.add(nex);
				return improvisedDrill(nex.getRightChild(), n,x);
			}
		}
		else{
			if (nex.getLeftChild() == null){
				return null; 
			}
			else{
				x.add(nex);
				return improvisedDrill(nex.getLeftChild(), n,x);
			}
		}
		
	}
	
}
