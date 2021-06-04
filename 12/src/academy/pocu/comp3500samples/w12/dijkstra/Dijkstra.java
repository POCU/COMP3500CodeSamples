package academy.pocu.comp3500samples.w12.dijkstra;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Dijkstra {
    private Dijkstra() {
    }

    public static HashMap<String, Integer> calculateShortestDistances(final HashMap<String, Node> nodes, final String from, final HashMap<String, String> outPrevious) {
        final HashMap<String, Integer> shortestDistances = new HashMap<>();

        for (Map.Entry<String, Node> entry : nodes.entrySet()) {
            final String name = entry.getKey();

            shortestDistances.put(name,
                    Integer.MAX_VALUE);
        }

        shortestDistances.put(from, 0);

        Node startingNode = nodes.get(from);

        outPrevious.put(startingNode.getName(),
                null);

        final PriorityQueue<NodeDistance> candidates = new PriorityQueue<>();

        final NodeDistance nodeDistance = new NodeDistance(startingNode, 0);

        candidates.add(nodeDistance);

        while (!candidates.isEmpty()) {
            NodeDistance candidate = candidates.poll();

            final Node node = candidate
                    .getNode();

            final int distance = candidate
                    .getDistance();

            final int shortestDistance = shortestDistances.get(node.getName());

            if (shortestDistance < distance) {
                continue;
            }

            final Map<Node, Integer> roads = node.getRoads();

            for (Map.Entry<Node, Integer> entry
                    : roads.entrySet()) {
                final Node next = entry
                        .getKey();

                final int distanceToNext = entry
                        .getValue();

                final int newDistance = shortestDistance + distanceToNext;

                final int shortestDistanceToNext = shortestDistances
                        .get(next.getName());

                if (newDistance >= shortestDistanceToNext) {
                    continue;
                }

                shortestDistances
                        .put(next.getName(),
                                newDistance);

                outPrevious
                        .put(next.getName(),
                                node.getName());

                final NodeDistance newCandidate = new NodeDistance(next, newDistance);

                candidates.add(newCandidate);
            }
        }

        return shortestDistances;
    }
}
