package academy.pocu.comp2500samples.w07.quadtree;

public final class Point {
    private int x;
    private int y;

    public Point(final int x, final int y) {
        this.x = x;
        this.y = y;
    }

    public Point(Point other) {
        this.x = other.x;
        this.y = other.y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }
}
