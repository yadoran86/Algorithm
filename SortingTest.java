package algo_14_20195181;

class Sorting{
	public static void heapSort(int[] a) {
		int n = a.length-1;
		int temp;
		for(int i=n/2;i>=1;i--) {
			heapify(a,i,n);
		}
		for(int i=n-1;i>=1;i--) {
			temp = a[1];
			a[1] = a[i+1];
			a[i+1] = temp;
			heapify(a,1,i);
		}
	}
	
	private static void heapify(int[] a, int h, int m) {
		int ah = a[h];
		int j;
		for(j=2*h; j<=m; j=2*j) {
			if(j<m) {
				if(a[j] < a[j+1]) j = j+1;
			}
			if(ah>=a[j]) break;
			else a[j/2] = a[j];
		}
		a[j/2] = ah;
	}
}

public class SortingTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int test[] = {0, 2, 4, 5, 7, 3, 10, 8, 1, 9, 6};
		Sorting.heapSort(test);
		
		System.out.println();
		
		for(int i=0; i<test.length; i++) {
			System.out.print(test[i] + " ");
		}

	}

}
