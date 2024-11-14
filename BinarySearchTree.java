package algo_04_20195181;

class TreeNode {
	String key;
	TreeNode Lchild;
	TreeNode Rchild;
}

class BinarySearchTree {
	private TreeNode rootNode;
	
	public TreeNode BSTsearch(String K) {
		TreeNode current = rootNode;
		while(current != null) {
			if(current.key == K) {
				return current;
			}
			else if (current.key.compareTo(K) == 1) {
				current = current.Lchild;
			}
			else {
				current = current.Rchild;
			}
		}
		return null;
	}
	
	public void BSTinsert(String K) {
		TreeNode newNode = new TreeNode();
		newNode.key = K;
		newNode.Lchild = null;
		newNode.Rchild = null;
		if(rootNode == null) {
			rootNode = newNode;
			return;
		}
		TreeNode current = rootNode;
		TreeNode parent = null;
		
		while(current != null) {
			if(current.key == K) {
				return;
			}	
			parent = current;
			if(current.key.compareTo(K) == 1 ) {
				current = current.Lchild;
			}
			else {
				current = current.Rchild;
			}
		}
		if(rootNode == null) {
			rootNode = newNode;
		}
		else if(parent.key.compareTo(K) == 1) {
			parent.Lchild = newNode;
		}
		else {
			parent.Rchild = newNode;
		}
	}
	
	private TreeNode maxNode(TreeNode root) {
		if(root == null) return null;
		if(root.Rchild == null ) return root;
		return maxNode(root.Rchild);
	}
	
	private TreeNode delete(TreeNode root, String K) {
		TreeNode delNode = rootNode;
		TreeNode delparentNode = null;
		while(delNode != null && delNode.key != K) {
			delparentNode = delNode;
			
			if(delNode.key.compareTo(K) == 1) {
				delNode = delNode.Lchild;
			}
			else {
				delNode = delNode.Rchild;
			}
		}
		if(delNode == null) {
			return null;
		}
		if(delNode.Lchild == null && delNode.Rchild == null) {
			if(delparentNode.Lchild == delNode) {
				delparentNode.Lchild = null;
			}
			else {
				delparentNode.Rchild = null;
			}
		}
		else if (delNode.Lchild == null || delNode.Rchild == null) {
			if(delNode.Lchild != null) {
				if(delparentNode.Lchild == delNode) {
					delparentNode.Lchild = delNode.Lchild;
				}
				else {
					delparentNode.Lchild = delNode.Rchild;
				}
			}
			else {
				if(delparentNode.Lchild == delNode) {
					delparentNode.Lchild = delNode.Rchild;
				}
				else {
					delparentNode.Rchild  = delNode.Rchild;
				}	
			}
		}
		else {
			TreeNode reNode = maxNode(delNode.Lchild);
			delNode.key = reNode.key;

		}
		return root;
	}
	
	public void BSTdelete(String K) {
		delete(rootNode, K);
	}
	
	public boolean BSTsplit(String x, BinarySearchTree SmallTree, BinarySearchTree LargeTree) {
		TreeNode small = new TreeNode();
		TreeNode large = new TreeNode();
		small = SmallTree.rootNode;
		large = LargeTree.rootNode;
		TreeNode root = this.rootNode;
		
		while(root != null) {
			if(x == root.key) {
				small.Rchild = root.Lchild;
				large.Lchild = root.Rchild;
				small.Rchild= SmallTree.rootNode;
				large.Lchild = LargeTree.rootNode;
				return true;
			}
			else if(x.compareTo(root.key) == -1) {
				large.Lchild = root;
				large = root;
				root = root.Lchild;
			}
			else {
				small.Rchild = root;
				small = root;
				root = root.Rchild;
			}
			SmallTree.rootNode = small.Rchild;
			LargeTree.rootNode = large.Lchild;
			return false;
		}
		return false;
	}
	
	public void printNode(TreeNode n) {
		if(n != null) {
			System.out.print("(");
			printNode(n.Lchild);
			System.out.print(" "+n.key+" ");
			printNode(n.Rchild);
			System.out.print(")");
		}

	}
	
	public void print() {
		TreeNode p = rootNode;
		printNode(p);
		System.out.println();
	}
}
