package academy.pocu.comp3500samples.w07.quadtree;

public class GameObject {
    private final Point point;
    private final int data;

    public GameObject(final Point point, int data) {
        this.point = point;
        this.data = data;
    }

    public int getData() {
        return this.data;
    }

    public Point getPoint() {
        return this.point;
    }
}
