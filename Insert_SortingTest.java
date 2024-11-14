package algo_13_20195181;

class Insert_Sorting {
	public static void insertionSort(int[] a) {
		boolean move;
		int i,j,k;
		for(i=1; i<a.length; i++) {
			k = a[i];
			j = i;
			if(a[j-1]>k) {
				move = true;
			}
			else {
				move = false;
			}
			while(move) {
				a[j] = a[j-1];
				j--;
				if(j>0 && a[j-1]>k) {
					move = true;
				}
				else {
					move = false;
				}
			}
			a[j] = k;
		}
	}
	
}

public class Insert_SortingTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int test[] = {6, 1, 7, 8, 5, 3, 2};
		
		Insert_Sorting.insertionSort(test);
		
		for(int i=0; i<7; i++) {
			System.out.print(test[i] + " ");
		}
	}

}
