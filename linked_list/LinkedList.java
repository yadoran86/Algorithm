package linked_list;

public class LinkedList {
	private ListNode firstNode;
	
	public LinkedList() {
		firstNode = null;
	}
	public ListNode firstNode() {
		return firstNode;
	}
	
	public void insert(ListNode p, Object x) {
		ListNode node = new ListNode(x);
		node.put_link(p.get_link());
		p.put_link(node);
	}
	
	public void append(Object x) {
		if(firstNode == null){
			firstNode = (new ListNode(x));
			return;
		}
		ListNode node = firstNode;
		while(node.get_link() != null)
			node = node.get_link();
		node.put_link(new ListNode(x));
	}
	
	public void delete(ListNode p) {
		ListNode node = p.get_link();
		p.put_link(node.get_link());
	}
	
	public ListNode listSearch(Object data) {
		ListNode p;
		p = firstNode;
		while (p!=null) {
			if(data.equals(p.get_name()))
				return p;
			p = p.get_link();
		}
		return p;
	}
	
	public void print() {
		ListNode p;
		System.out.print("(");
		p = firstNode;
		while(p!=null) {
			System.out.print(p.get_name());
			p = p.get_link();
			if(p!=null) {
				System.out.print(",");
			}
		}
		System.out.print(")");
	}
}