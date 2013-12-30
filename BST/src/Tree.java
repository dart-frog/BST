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
				else if (parent.getLeftChild() == nex){
					parent.setLeftChildNull();
				}
			}
		}
		//one child
		else if (nex.leftChild != null && nex.rightChild == null){
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
		else if (nex.leftChild == null && nex.rightChild != null){
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
		//two children 
		else{
			if (granddad == nex){
				if (granddad.getLeftChild().getRightChild() == null){
					Nexus h = granddad.getLeftChild();
					h.rightChild = granddad.getRightChild();
					granddad = h;
				}
				else{
					Nexus w = goRight(granddad.getLeftChild());
					delete(w.get());
					w.leftChild = granddad.leftChild;
					w.rightChild = granddad.rightChild;
					granddad = w;
				}			
			}
			else{
				if (nex.getLeftChild().getRightChild() == null){
					Nexus h = nex.getLeftChild();
					h.rightChild = nex.getRightChild();
					Nexus parent = z.get(z.size() -2);
					if (parent.getRightChild() == nex){
						parent.rightChild = h;
					}
					if (parent.getLeftChild() == nex){
						parent.leftChild = h;
					}
				}
				else{
					Nexus w = goRight(nex.getLeftChild());
					delete(w.get());
					w.leftChild = nex.leftChild;
					w.rightChild = nex.rightChild;
					nex = w;
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
	private Nexus goRight(Nexus nex){
		if (nex.getRightChild() == null){
			return nex;
		}
		else{
			return goRight(nex.rightChild);
		}
		
	}
	
}
