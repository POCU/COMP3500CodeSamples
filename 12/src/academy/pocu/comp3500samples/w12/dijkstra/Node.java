package academy.pocu.comp3500samples.w12.dijkstra;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class Node {
    private final String name;
    private final HashMap<Node, Integer> roads = new HashMap<>();

    public Node(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Map<Node, Integer> getRoads() {
        return Collections.unmodifiableMap(this.roads);
    }

    public void addRoad(final Node to, final int distance) {
        this.roads.put(to, distance);
    }

    public int getDistance(final Node to) {
        return this.roads.get(to);
    }
}
