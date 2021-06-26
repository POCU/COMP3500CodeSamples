package academy.pocu.comp3500samples.w13.kruskal;

import java.util.ArrayList;

public class Program {
    public static void main(String[] args) {
        String[] nodes = new String[]{
                "0",
                "1",
                "2",
                "3",
                "4",
                "5",
                "6",
                "7"
        };

        Edge[] edges = new Edge[]{
                new Edge("0", "4", 9),
                new Edge("0", "5", 2),
                new Edge("0", "2", 2),
                new Edge("1", "4", 6),
                new Edge("1", "5", 10),
                new Edge("2", "5", 1),
                new Edge("2", "7", 11),
                new Edge("2", "3", 5),
                new Edge("5", "7", 8),
                new Edge("5", "4", 3),
                new Edge("6", "7", 13)
        };

        ArrayList<Edge> mst = Kruskal
                .run(nodes, edges);

        for (Edge e : mst) {
            String edgeString = String
                    .format("(%s, %s)",
                            e.getNode1(),
                            e.getNode2());

            System.out.println(edgeString);
        }
    }
}
