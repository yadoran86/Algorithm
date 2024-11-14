package algo_11_20195181;
import java.util.*;

class Edge {
	int head;
	int tail;
	int weight;
	
	public Edge(int h,int t, int w) {
        head = h;
        tail = t;
        weight = w;
	}
	
	public int compareTo(Object value) {
		
	}
}
class Wgraph {
	int n;
	int e;
	int [][] weight;
	
	public Wgraph(int noOfVertices) {
		n = noOfVertices;
		e = 0;
		weight = new int [n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(i==j) weight[i][j] = 0;
				else weight[i][j] = 9999;
			}
		}
		
	}
	
	public Wgraph() {
		n = 0;
		e = 0;
	}
	
	public void insertEdge(int i, int j, int w) {
		weight[i][j] = w;
		e++;
	}
	
	public void removeEdge(int i, int j) {
		weight[i][j] = 9999;
		e--;
	}
	
	public int[] shortestPath(int v) {//다이스크라
		boolean s[] = new boolean[n];
		int dist[] = new int[n];
		int u;
		
		for(int i=0;i<n;i++) {
			s[i] = false;
			dist[i] = 9999;
		}
		s[v] = true;
		dist[v] = 0;
		for(int i=0;i<n;i++) {
			if(s[i] == false && weight[v][i] != 9999) {
				dist[i] = weight[v][i];
			}
		}
		for(int a=0;a<n-1;a++) {
			int min = 9999;
			int min_ind = -1;
			
			for(int i=0;i<n;i++) {
				if(s[i] == false) {
					if(dist[i] < min) {
						min = dist[i];
						min_ind = i;
					}
				}
			}
		
			s[min_ind] = true;
			for(int i=0;i<n;i++) {
				if(s[i] == false && weight[min_ind][i] != 9999) {
					if(dist[min_ind] + weight[min_ind][i] < dist[i]) {
						dist[i] = dist[min_ind] + weight[min_ind][i];
					}
				}
			}
		}
		return dist;
		
	}

	public int[] negativePath(int v) {//벨몬포드
		for (int i = 0; i < 6; i++) { 
			for (int j = 0; j < 6; j++) {
				System.out.print(weight[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
		
		int dist[] = new int[n];
		int previous[] = new int[n];
		
		for (int i=0;i<n;i++) {
			dist[i] = 9999;
		}
		dist[v] = 0; 
		previous[v] = 0;
		for(int k=0;k<n-1;k++) {
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					if( weight[i][j] != 9999) {
						if(dist[j] > dist[i]+weight[i][j]) {
							dist[j] = dist[i]+weight[i][j];
							previous[j] = i;
						}
					}
				}
			}
		}
		return dist;
	}
	
	public int[][] allShortestPath() {
		int[][]distance = weight;
		int[][]distanceP = new int[n][n];
		int k, i, j;
		for(i=0;i<n;i++) {
			for(j=0;j<n;j++) {
				distanceP[i][j] = distance[i][j];
			}
		}
		for(k=0;k<n;k++) {
			for(i=0;i<n;i++) {
				for(j=0;j<n;j++) {
					if(distanceP[i][j] > (distanceP[i][k]+ distanceP[k][j])) {
						distanceP[i][j] = (distanceP[i][k]+ distanceP[k][j]);
					}
				}
			}
		}
		return distanceP;
	}
}
