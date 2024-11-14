package algo_03_20195181;

public class BTNode {
	String data;
	BTNode Lchild;
	BTNode Rchild;
	
	public BTNode() {
	}
	
	public BTNode(String dt) {
		data = dt;
		Lchild = null;
		Rchild = null;
	}
	
	public BTNode(BTNode lc, String dt, BTNode rc) {
		data = dt;
		Lchild = lc;
		Rchild = rc;
	}
}

class BinaryTree{
	BTNode root;
	public BinaryTree() {
		root = null;
	}
	
	public BinaryTree(BinaryTree ltree, String data, BinaryTree rtree) {
		root = new BTNode(data);
		root.Lchild = ltree.root;
		root.Rchild = rtree.root;
	}
	
	public boolean isEmpty() {
		if(root == null) {
			return true;
		}
		return false;
	}
	
	public BinaryTree leftSubTree() {
		BinaryTree lsubtree = new BinaryTree();
		lsubtree.root = root.Lchild;
		return lsubtree;
	}
	
	public BinaryTree rightSubTree() {
		BinaryTree rsubtree = new BinaryTree();
		rsubtree.root = root.Rchild;
		return rsubtree;
	}
	
	public String rootData() {
		return root.data;
	}
	
	public void inorder() {
		System.out.println("\nInorder");
		theInorder(root);
		
		System.out.println("\nInorderlter");
		inorderlter();
	}
	
	public void preorder() {
		System.out.println("preorder");
		thePreorder(root);
		
		System.out.println("\npreorderlter");
		preorderlter();
	}
	
	public void postorder() {
		System.out.println("postorder");
		thePostorder(root);
	}
	private void theInorder(BTNode t) {
		if( t != null) {
			theInorder(t.Lchild);
			System.out.println(t.data);
			theInorder(t.Rchild);
		}
	}
	private void thePreorder(BTNode t) {
		if( t != null) {
			System.out.println(t.data);
			thePreorder(t.Lchild);
			thePreorder(t.Rchild);
		}
	}
	private void thePostorder(BTNode t) {
		if( t != null) {
			thePostorder(t.Lchild);
			thePostorder(t.Rchild);
			System.out.println(t.data);
		}
	}
	private void inorderlter() {
		Stack s = new Stack();
		BTNode p = root;
		while (p != null || !s.empty()) {
			if(p != null) {
				s.push(p);
				p = p.Lchild;
			}
			else {
				p = (BTNode) s.pop();
				System.out.println(p.data);
				p = p.Rchild;
				
			}
		}
	}
	private void preorderlter() {
		Stack s = new Stack();
		BTNode p = root;
		while (p != null || !s.empty()) {
			if(p != null) {
				System.out.println(p.data);
				s.push(p);
				p = p.Lchild;
			}
			else {
				p = (BTNode) s.pop();
				p = p.Rchild;
				
			}
		}
	}
	public void levelorder() {
		System.out.println("levelorder");
		BTNode t = root;
		Queue q = new Queue();
		q.enqueue(t);
		while ( !q.isEmpty()) {
			t = (BTNode) q.dequeue();
			System.out.println(t.data);
			if(t.Lchild != null) {
					q.enqueue(t.Lchild);
			}
			if(t.Rchild != null) {
				q.enqueue(t.Rchild);
			}

		}
	}
	public BinaryTree copy() {
		BinaryTree newTree = new BinaryTree();
		newTree.root = theCopy(root);
		return newTree;
	}
	private BTNode theCopy(BTNode t) {
		if(t != null) {
			BTNode l = theCopy(t.Lchild);
			BTNode r = theCopy(t.Rchild);
			BTNode s = new BTNode(l, t.data, r);
			return s;
		}
		else return null;

	}
	public boolean equals(BinaryTree tr) {
		return theEquals(this.root, tr.root);
	}
	private boolean theEquals(BTNode s, BTNode t) {
		if( s == null && t==null ) return true;
		else if( s != null && t != null) {
			if( s.data.equals(t.data)) {
				if( theEquals(s.Lchild, t.Lchild)) {
					return theEquals(s.Rchild, t.Rchild);	
				}
				else return false;
			}
			else return false;
		}
		else return false;
	}
}
