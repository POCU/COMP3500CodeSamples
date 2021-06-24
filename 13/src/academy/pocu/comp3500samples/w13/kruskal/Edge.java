package academy.pocu.comp3500samples.w13.kruskal;

public final class Edge implements Comparable<Edge> {
    private final String start;
    private final String end;
    private final int weight;

    public Edge(final String start,
                final String end,
                final int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    public String getStart() {
        return this.start;
    }

    public String getEnd() {
        return this.end;
    }

    public int getWeight() {
        return this.weight;
    }

    @Override
    public int compareTo(Edge e) {
        return this.weight - e.weight;
    }
}
