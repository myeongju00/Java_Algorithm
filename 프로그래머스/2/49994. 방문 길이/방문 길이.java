import java.util.ArrayList;
import java.util.Objects;

class Solution {
    ArrayList<Edge> edges = new ArrayList<>();
    public int solution(String dirs) {
        int answer = 0;
        Node now = new Node(0, 0);
        for(int i = 0; i < dirs.length(); i++) {
            Node start = now;
            Node end = new Node(now.x, now.y);
            switch(dirs.charAt(i)) {
                case 'U':
                    end.y++;
                    break;
                case 'D':
                    end.y--;
                    break;
                case 'R':
                    end.x++;
                    break;
                case 'L':
                    end.x--;
                    break;
            }
            if(end.x < -5 || end.x > 5 || end.y < -5 || end.y > 5) {
                continue;
            }
            now = end;
            Edge edge1 = new Edge(start, end);
            Edge edge2 = new Edge(end, start);
            if(!edges.contains(edge1) && !edges.contains(edge2)) {
                edges.add(edge1);
                edges.add(edge2);
                answer++;
            }
        }
        return answer;
    }

    public class Node {
        int x;
        int y;
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof Node)) {
                return false;
            }
            Node node = (Node) o;
            return x == node.x && y == node.y;
        }
    }

    public class Edge {
        Node start;
        Node end;
        Edge(Node start, Node end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof Edge)) {
                return false;
            }
            Edge edge = (Edge) o;
            return Objects.equals(start, edge.start) && Objects.equals(end, edge.end);
        }
    }
}