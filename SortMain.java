package algo_12_20195181;

public class SortMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// selection
		int[] a = {5,2,8,3,1};
		System.out.println("������ �迭 ���� : ");
		int i;
		for(i=0; i<a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
		
		Sorting.selectionSort(a);
		System.out.println("���ĵ� �迭 ���� : ");
		for(i=0; i<a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
		
		//-------------------------------------------------------
		
		//bubble
		int[] b = {5,2,11,8,3,1,7};
		System.out.println("������ �迭 ���� : ");
		for(i=0; i<b.length; i++) {
			System.out.print(b[i] + " ");
		}
		System.out.println();
		
		Sorting.bubbleSort(b);
		System.out.println("���ĵ� �迭 ���� : ");
		for(i=0; i<b.length; i++) {
			System.out.print(b[i] + " ");
		}
		System.out.println();

	}

}
