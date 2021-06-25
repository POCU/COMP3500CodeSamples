package academy.pocu.comp3500samples.w13.kruskal;

import java.util.ArrayList;

public class Program {
    public static void main(String[] args) {
        String[] nodes = new String[]{
                "A",
                "B",
                "C",
                "D",
                "E",
                "F",
                "G",
                "H"
        };

        Edge[] edges = new Edge[]{
                new Edge("A", "E", 9),
                new Edge("A", "F", 2),
                new Edge("A", "C", 2),
                new Edge("B", "E", 6),
                new Edge("B", "F", 10),
                new Edge("C", "F", 1),
                new Edge("C", "H", 11),
                new Edge("C", "D", 5),
                new Edge("F", "H", 8),
                new Edge("F", "E", 3),
                new Edge("G", "H", 13)
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
