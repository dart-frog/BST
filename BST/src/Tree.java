import java.util.ArrayList;


public class Tree {
	private Nexus granddad; 
	/**
	 * creates a binary search tree
	 * @param g the root node
	 */
	public Tree(int g){
		granddad = new Nexus(g);
	}
	/**
	 * inserts a node into the tree
	 * @param n the node you want to insert
	 */
	public void insert(int n){
		tunnel(granddad,n);
	}
	/**
	 * Checks if a given node exists within the tree
	 * @param n the node you want to check
	 * @return weather the given node exists
	 */
	public boolean  exists(int n){
		return drill(granddad,n);
	}
	/**
	 * sorts a binary search tree
	 * @return an array of the sorted elements 
	 */
	public ArrayList<Integer> sort(){
		return GetInOrderTraversal(new ArrayList(), granddad);
	}
	/**
	 * deletes a given node
	 * @param n the node you want to delete
	 */
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
					parent.rightChild = nex.leftChild;
				}
				if (parent.getLeftChild() == nex){
					parent.leftChild = nex.leftChild;
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
					parent.rightChild = nex.rightChild;
				}
				if (parent.getLeftChild() == nex){
					parent.leftChild = nex.rightChild;
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
	private ArrayList<Integer> GetInOrderTraversal(ArrayList<Integer> s, Nexus node){
		if (node.getLeftChild() != null){
			s.addAll(GetInOrderTraversal(new ArrayList<Integer>(),node.getLeftChild()));
		}
		s.add(node.get());
		if (node.getRightChild() != null){
			s.addAll(GetInOrderTraversal(new ArrayList<Integer>(),node.getRightChild()));
			
			
		}
		return s;
	}
	
}
