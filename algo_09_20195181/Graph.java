package algo_09_20195181;

public class Graph {
	int n; // 정점의 수
	int e; // 간선의 수
	int [][] weight;
	
	public Graph(int noOfvertices) {
		n = noOfvertices;
		e = 0;
		weight = new int[n][n];
	}
	
	public void insertEdge(int i, int j) {
		weight[i][j] = 1;
		weight[j][i] = 1;
		e++;
	}
	
	public void removeEdge(int i, int j) {
		weight[i][j] = 0;
		weight[j][i] = 0;
		e--;
	}
	
	public int[] adjacency(int u) {
		int[] adj;
		int deg = 0;
		for(int i=0;i<n; i++) {
			if(weight[u][i] == 1) {
				deg++;
			}
		}
		adj = new int[deg];
		int j=0;
		for(int k=0;k<n;k++) {
			if(weight[u][k] == 1) {
				adj[j] = k;
				j++;
			}
		}
		return adj;
	}
	
	public void bfs(int v) {
		System.out.println("BFS");
		boolean[] visited = new boolean[n];
		for(int i=0; i<visited.length; i++) {
			visited[i] = false;
		}
		Queue q = new Queue();
		q.enqueue(v);
		while(!q.isEmpty()) {
			int j = q.dequeue();
			if(visited[j] == false) {
				System.out.print(j+" ");
				visited[j] = true;
			}
			for(int k : adjacency(j)) {
				if(visited[k] == false) {
					q.enqueue(k);
				}
			}
		}
	}
	
	public void dfs(int v) {
		System.out.println("DFS");
		boolean[] visited = new boolean[n];
		for(int i=0; i<visited.length; i++) {
			visited[i] = false;
		}
		Stack s = new Stack();
		s.push(v);
		while(!s.isEmpty()) {
			int j = s.pop();
			if(visited[j] == false) {
				System.out.print(j+" ");
				visited[j] = true;
				for(int k : adjacency(j)) {
					if(visited[k] == false) {
						s.push(k);
					}
				}
			}
		}
	}
}
