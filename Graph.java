package algo_12_20195181;

class Node {
	int vertex;
	Node link;
}

public class Graph {
	Queue[] Q;
	Queue zeroPredQ;
	int[] sortedList;
	int[] indegree;
	int n;
	
	public Graph(int vertices) {
		n = vertices;
		Q = new Queue[n];
		zeroPredQ = new Queue();
		sortedList = new int[n];
		for(int i=0;i<n;i++) {
			Q[i] = new Queue();
		}
		indegree = new int[n];
	}
	
	public void topologicalSort() {
		int i,v,successor;
		for(i=0;i<n;i++) {
			if(indegree[i] == 0) {
				zeroPredQ.enqueue(i);
			}
		}
		if(zeroPredQ.isEmpty()) {
			System.out.println("network has a cycle");
			return;
		}
		
		while(!zeroPredQ.isEmpty()) {
			v = zeroPredQ.dequeue();
			sortedList[v] = v;
			if(Q[v].isEmpty()) continue;
			else successor = Q[v].dequeue();
			while(true) {
				indegree[successor]--;
				if(indegree[successor] == 0)
					zeroPredQ.enqueue(successor);
				if(!Q[v].isEmpty()) successor = Q[v].dequeue();
				else break;
			}
		}
		System.out.println("topological order is : ");
		for(int j=0;j<n;j++) {
			System.out.print(sortedList[j]+" ");
		}
		
	}
	
	public void insertEdge(int i, int j) {
		Q[i].enqueue(j);
		indegree[j]++;
	}
}
