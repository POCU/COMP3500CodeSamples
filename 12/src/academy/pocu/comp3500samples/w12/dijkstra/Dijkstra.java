package academy.pocu.comp3500samples.w12.dijkstra;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Dijkstra {
    private Dijkstra() {
    }

    public static HashMap<String, Integer> run(final HashMap<String, Node> nodes, final String from, final HashMap<String, String> outPrev) {
        HashMap<String, Integer> minDists = new HashMap<>();

        final int INF = Integer.MAX_VALUE;
        for (var entry : nodes.entrySet()) {
            String name = entry.getKey();

            minDists.put(name, INF);
        }

        minDists.put(from, 0);

        outPrev.put(from, null);

        PriorityQueue<Candidate> open = new PriorityQueue<>();

        Node s = nodes.get(from);
        Candidate candidate = new Candidate(s, 0);

        open.add(candidate);

        while (!open.isEmpty()) {
            candidate = open.poll();

            Node n = candidate.getNode();
            String nodeName = n.getName();

            int minDist = minDists.get(nodeName);
            int dist = candidate.getDistance();

            if (minDist < dist) {
                continue;
            }

            Map<Node, Integer> roads = n
                    .getRoads();

            for (var e : roads.entrySet()) {
                Node next = e.getKey();

                int weight = e.getValue();
                int newDist = minDist + weight;

                String nextName = next.getName();
                int nextMinDist = minDists
                        .get(nextName);

                if (newDist >= nextMinDist) {
                    continue;
                }

                minDists.put(nextName, newDist);
                outPrev.put(nextName, nodeName);

                Candidate newCandidate = new Candidate(next, newDist);

                open.add(newCandidate);
            }
        }

        return minDists;
    }
}
