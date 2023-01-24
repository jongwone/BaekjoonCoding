import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    private static PriorityQueue<Edge> list;
    private static ArrayList<Edge>[] points;
    private static int[] minPath;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int numOfPoint = scan.nextInt();
        int numOfEdge = scan.nextInt();
        int startPoint = scan.nextInt();

        minPath = new int[numOfPoint+1];
        points = new ArrayList[numOfPoint+1];

        for (int i = 1; i <= numOfPoint; i++ ) {
            points[i] = new ArrayList<>();
        }
        Arrays.fill(minPath, Integer.MAX_VALUE);

        int from = 0, to = 0, weight = 0;
        for (int i = 0; i < numOfEdge; i++ ){
            from = scan.nextInt();
            to = scan.nextInt();
            weight = scan.nextShort();
            points[from].add(new Edge(to, weight));
        }
        minPath[startPoint] = 0;

        list = new PriorityQueue<>();
        list.add(new Edge(startPoint, 0));
        run_dijkstra();

        for (int i = 1; i < points.length; i++)
            System.out.println((minPath[i] != Integer.MAX_VALUE ? minPath[i] : "INF"));
    }
    private static void run_dijkstra() {
        while ( !list.isEmpty() ) {
            int i = list.poll().to;
            for (Edge k : points[i]) {
                int distanceCurrent = minPath[i] + k.weight;
                if ( distanceCurrent < minPath[k.to] ) {
                    minPath[k.to] = distanceCurrent;
                    list.add(new Edge(k.to, distanceCurrent));
                }
            }
        }
    }
}
class Edge implements Comparable<Edge>{
    int to, weight;
    Edge(int to, int weight) {
        this.to = to;
        this.weight = weight;
    }
    @Override
    public int compareTo(Edge e) {
        if ( this.weight > e.weight) {
            return 1;
        } else if ( this.weight < e.weight ) {
            return -1;
        }
        return 0;
    }
}
