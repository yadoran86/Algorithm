package algo_06_20195181;

class Heap {
    private int count; //원소의 개수
    private int size; //전체 크기
    private int[] itemArray;
    
    public Heap() {
        count = 0;
        size = 64;
        itemArray = new int[size];
    }
    
    public Heap(int[] origArray) {
        count = origArray.length-1;
        size = 64;
        itemArray = new int[size];
    	for(int i=0; i<=count; i++) {
    		itemArray[i] = origArray[i];
    	}
    	for(int i = count/2; i>=1; i--) {
    		int p = i;
    		for(int j = 2*p; j<=count; j=2*j) {
    			if(j < count) {
    				if(itemArray[j] < itemArray[j+1]) {
    					j = j+1;
    				}
    			}
    			if(itemArray[p] >= itemArray[j]) break;
    			int temp = itemArray[p];
    			itemArray[p] = itemArray[j];
    			itemArray[j] = temp;
    			p = j;
    		}
    	}
    }
   
    public void insert(int newItem) {
    	int i = count + 1;
    	while(i < size) {
    		if(i==1) break;
    		if(newItem <= itemArray[i/2]) break;
    		itemArray[i] = itemArray[i/2];
    		i = i/2;
    	}
    	itemArray[i] = newItem;
    	count++;
    }

    public int delete() {
    	if(count <= 0) return 0;
    	else {
    	int item = itemArray[1];
    	int temp = itemArray[count];
    	count = count - 1;
    	int i = 1;
    	int j = 2;
    	while(j<=count) {
    		if(j<count) {
    			if(itemArray[j] < itemArray[j+1]) {
    				j = j+1;
    			}
    		}
    		if(temp >= itemArray[j]) break;
    		itemArray[i] = itemArray[j];
    		i = j;
    		j = j*2;
    	}
    	itemArray[i] = temp;
    	return item;
    	}
    }

    public void printHeap() {
        int i;
        for (i = 1; i <= count; i++)
            System.out.print(itemArray[i] + " ");
        System.out.println();
    }
}