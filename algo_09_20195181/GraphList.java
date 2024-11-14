package algo_09_20195181;

class Node {
	int vertex;
	Node link;
}

class GraphList {
	int n;
	int e;
	Node[] header;
	
	public GraphList(int noOfVertices) {
		n = noOfVertices;
		e = 0;
		header = new Node[n];
	}
	
	public void insertEdge(int i, int j) {
		Node newNode = new Node();
		newNode.vertex = j;
		newNode.link = null;
		if(header[i] == null) {
			header[i] = newNode;
		}
		else {
			newNode.link = header[i];
			header[i] = newNode;
		}
		Node newNode1 = new Node();
		newNode1.vertex = i;
		newNode1.link = null;
		if(header[j] == null) {
			header[j] = newNode1;
		}
		else {
			newNode1.link = header[j];
			header[j] = newNode1;
		}
		e++;
	}
	
	public void removeEdge(int i, int j) {
		Node p = header[i];
		while(p != null) {
			if(p.vertex == j) {
				p.link = null;
			}
			p = p.link;
		}
		
		Node x = header[j];
		while(x != null) {
			if(x.vertex == j) {
				x.link = null;
			}
			x = x.link;
		}
		e--;
	}
	
	public int[] adjacency(int u) {
		int[] adj;
		int deg = 0;
		Node p = header[u];
		while(p != null) {
			p = p.link;
			deg++;
		}
		adj = new int[deg];
		
		int i=0;
		Node x = header[u];
		while(x != null) {
			adj[i] = x.vertex;
			x = x.link;
			i++;
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
