package academy.pocu.comp3500samples.w07.quadtree;

import java.util.ArrayList;

public final class Quadrant {
    private static final int MIN_QUAD_DIMENSION = 2;

    private final BoundingRect boundingRect;

    private Quadrant topLeft;
    private Quadrant topRight;
    private Quadrant bottomLeft;
    private Quadrant bottomRight;

    private ArrayList<GameObject> gameObjects = new ArrayList<>();

    public Quadrant(final BoundingRect boundingRect) {
        this.boundingRect = boundingRect;

        createChildren();
    }

    public boolean insert(final GameObject gameObject) {
        final Point point = gameObject.getPosition();

        if (!this.boundingRect.contains(point)) {
            return false;
        }

        this.gameObjects.add(gameObject);

        if (this.topLeft != null) {
            this.topLeft.insert(gameObject);
            this.topRight.insert(gameObject);
            this.bottomLeft.insert(gameObject);
            this.bottomRight.insert(gameObject);
        }

        return true;
    }

    public ArrayList<GameObject> getGameObjects(final BoundingRect rect) {
        if (!this.boundingRect.contains(rect)) {
            return new ArrayList<>();
        }

        if (this.topLeft == null) {
            return this.gameObjects;
        }

        if (this.topLeft.boundingRect.contains(rect)) {
            return this.topLeft
                    .getGameObjects(rect);
        }

        if (this.topRight.boundingRect.contains(rect)) {
            return this.topRight
                    .getGameObjects(rect);
        }

        if (this.bottomRight.boundingRect.contains(rect)) {
            return this.bottomRight
                    .getGameObjects(rect);
        }

        if (this.bottomLeft.boundingRect.contains(rect)) {
            return this.bottomLeft
                    .getGameObjects(rect);
        }

        return this.gameObjects;
    }

    private void createChildren() {
        final int width = this.boundingRect.getWidth();
        final int height = this.boundingRect.getHeight();

        if (width < 2 * MIN_QUAD_DIMENSION
            || height < 2 * MIN_QUAD_DIMENSION) {
            return;
        }

        int x1 = this.boundingRect
                .getTopLeft()
                .getX();
        int y1 = this.boundingRect
                .getTopLeft()
                .getY();
        int x2 = this.boundingRect
                .getBottomRight()
                .getX();
        int y2 = this.boundingRect
                .getBottomRight()
                .getY();

        int midX = (x1 + x2) / 2;
        int midY = (y1 + y2) / 2;

        Point p1 = new Point(x1, y1);
        Point p2 = new Point(midX, midY);

        BoundingRect rect = new BoundingRect(p1,
                p2.getX() - p1.getX(),
                p2.getY() - p1.getY());

        this.topLeft = new Quadrant(rect);

        p1 = new Point(midX, y1);
        p2 = new Point(x2, midY);
        rect = new BoundingRect(p1,
                p2.getX() - p1.getX(),
                p2.getY() - p1.getY());

        this.topRight = new Quadrant(rect);

        p1 = new Point(x1, midY);
        p2 = new Point(midX, y2);
        rect = new BoundingRect(p1,
                p2.getX() - p1.getX(),
                p2.getY() - p1.getY());

        this.bottomLeft = new Quadrant(rect);

        p1 = new Point(midX, midY);
        p2 = new Point(x2, y2);
        rect = new BoundingRect(p1,
                p2.getX() - p1.getX(),
                p2.getY() - p1.getY());

        this.bottomRight = new Quadrant(rect);
    }
}
