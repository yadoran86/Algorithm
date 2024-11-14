package array_list;

public class List {
	private int size;
	private int array[];
	private static final int MAX = 100;
	public List() {
		size = 0;
		array = new int[MAX];
	}
	
	public boolean isEmpty() {
		if (size == 0) return true;
		else return false;
	}
	
	public int length() {
		return size;
	}
	
	public int retrieve(int j) {
		if (size==0) return -1;
		else return array[j];
	}
	
	public void replace(int j,int item) {
		if(size != 0) {
			array[j] = array[item];
		}
	}
	
	public void delete(int j) {
		if (size != 0 ) {
			for (int n=j; n<size-1; n++) {
				array[n] = array[n+1];
			}
		size--;
		}
	}
	public void insert(int j,int k) {
		for(int n = size-1; n >= j; n--) {
			array[n+1] = array[n];
		}
		array[j] = k;
		size++;
	}
}
