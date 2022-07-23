import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
 
public class Main{
	
	static final int INF = 9999999;
	static List<List<Node>> graph = new ArrayList<>();
	static int[] result;
 
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
		String[] info = br.readLine().split(" ");
		int startIndex = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < Integer.parseInt(info[0])+1; i++) {
			graph.add(new ArrayList<>());
		}
		result = new int[Integer.parseInt(info[0])+1];
		Arrays.fill(result, INF);
		
	
		for (int i = 0; i < Integer.parseInt(info[1]); i++) {
			String[] temp = br.readLine().split(" ");
			graph.get(Integer.parseInt(temp[0])).add(new Node(Integer.parseInt(temp[1]), Integer.parseInt(temp[2])));
		}
		
		dijkstra(startIndex);
		
		for (int i = 1; i < result.length; i++) {
			if(result[i] == INF) {
				bw.write("INF");
				bw.newLine();
			}else {
				bw.write(String.valueOf(result[i]));
				bw.newLine();
			}
		}
		bw.flush();
		
	}
	
	// 다익스트라 알고리즘
	static void dijkstra(int index) {
		
		PriorityQueue<Node> pq =  new PriorityQueue<>();
		result[index] = 0;
		pq.offer(new Node(index, 0));
		
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			int nodeIndex = node.index;
			int distance = node.distacne;
			
			if(distance > result[nodeIndex]) {
				continue;
			}
			
			for (Node linkedNode : graph.get(nodeIndex)) {
				if(distance + linkedNode.distacne < result[linkedNode.index]) {
					result[linkedNode.index] = distance + linkedNode.distacne;
					pq.offer(new Node(linkedNode.index, result[linkedNode.index]));
				}
			}
		}
	}
	
	static class Node implements Comparable<Node>{
		int index;			// 노드 번호
		int distacne;		// 이동 할 노드까지의 거리
 
		Node(int index, int distacne) {
			this.index = index;
			this.distacne = distacne;
		}
		
		@Override
		public int compareTo(Node o) {
		return Integer.compare(this.distacne, o.distacne);
		}
	}
	
}