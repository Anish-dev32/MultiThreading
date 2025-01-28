import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static class Edge{
        int source;
        int destination;

        public Edge(int s, int d){
            this.source = s;
            this.destination = d;
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph){
        for(int i=0; i<graph.length; i++){
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0,2));

        graph[1].add(new Edge(1,0));
        graph[1].add(new Edge(1,3));

        graph[2].add(new Edge(2,0));
        graph[2].add(new Edge(2,4));

        graph[3].add(new Edge(3,1));
        graph[3].add(new Edge(3,4));
        graph[3].add(new Edge(3,5));

        graph[4].add(new Edge(4,2));
        graph[4].add(new Edge(4,3));
        graph[4].add(new Edge(4,5));

        graph[5].add(new Edge(5,3));
        graph[5].add(new Edge(5,4));
        graph[5].add(new Edge(5,6));

        graph[6].add(new Edge(6,5));

    }

    public static void bfs(ArrayList<Edge>[] graph, boolean[] visited, int src){
        Queue<Integer> q = new LinkedList<>();

        q.add(src);
        while(!q.isEmpty()){
            int curr = q.remove();
            if(!visited[curr]) {
                System.out.print(curr + " ");
                visited[curr] = true;
                for (int i = 0; i < graph[curr].size(); i++) {
                    Edge e = graph[curr].get(i);
                    q.add(e.destination);
                }
            }
        }
    }

    public static void dfs(ArrayList<Edge>[] graph, boolean[] visited, int curr){
        if(!visited[curr]) {
            System.out.print(curr + " ");
            visited[curr] = true;
            for(int i=0; i<graph[curr].size(); i++){
                Edge e = graph[curr].get(i);
                dfs(graph, visited, e.destination);
            }
        }
    }

    private static void findAllWays(ArrayList<Edge>[] graph, int curr, int target,
                                    boolean[] visited, String path) {
        if(curr == target){
            System.out.println(path);
            return;
        }
        visited[curr] = true;
        for(int i=0; i<graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if(!visited[e.destination]){
                findAllWays(graph, e.destination, target, visited, path+e.destination);
            }
        }
        visited[curr] = false;
    }

    public static void main(String[] args) {
        int V = 7;
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);

        /*Adjacency List
        for(int i=0; i<graph.length; i++){
            System.out.print("for "+i+" : ");
            for(int j=0; j<graph[i].size(); j++){
                Edge e = graph[i].get(j);
                System.out.print(e.destination+" ");
            }
            System.out.println();
        }*/

        boolean visited[] = new boolean[V];
        /* BFS and DFS
        for(int i=0; i<V; i++){
            if(!visited[i]){
                //bfs(graph, visited,i);
                dfs(graph, visited, i);
            }
        }*/

        /* Find all possible ways to traverse from src to target node
        int src = 1;
        int target = 5;
        String path = "";
        findAllWays(graph, src, target, visited, path+src);
        */
    }


}