package algo_02_20195181;

public class BinaryTreeTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree btree;
		BinaryTree ltree;
		BinaryTree rtree;
		BinaryTree ltree1;
		
		ltree = new BinaryTree(new BinaryTree(), "1", new BinaryTree());
		rtree = new BinaryTree(new BinaryTree(), "2", new BinaryTree());
		btree = new BinaryTree(ltree, "+", rtree);
		ltree = btree;
		rtree = new BinaryTree(new BinaryTree(), "3", new BinaryTree());
		btree = new BinaryTree(ltree, "*", rtree);
		ltree = btree;
		ltree1 = new BinaryTree(new BinaryTree(), "4", new BinaryTree());;
		rtree = new BinaryTree(new BinaryTree(), "5", new BinaryTree());
		btree = new BinaryTree(ltree1, "+", rtree);
		rtree = btree;
		btree = new BinaryTree(ltree, "-", rtree);
		
		
		System.out.println(btree.calculate());
		
	}

}
