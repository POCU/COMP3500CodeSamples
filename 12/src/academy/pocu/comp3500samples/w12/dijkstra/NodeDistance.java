package academy.pocu.comp3500samples.w12.dijkstra;

public final class NodeDistance implements Comparable<NodeDistance> {
    private final Node node;
    private final int distance;

    public NodeDistance(final Node node, final int distance) {
        this.node = node;
        this.distance = distance;
    }

    public Node getNode() {
        return this.node;
    }

    public int getDistance() {
        return this.distance;
    }

    @Override
    public int compareTo(NodeDistance o) {
        return this.getDistance() - o.distance;
    }
}
