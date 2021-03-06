package academy.pocu.comp3500samples.w07.quadtree;

import java.util.ArrayList;

public final class Quadrant {
    private static final int MAX_UNIT_QUAD_DIMENSION_LENGTH = 2;

    private final BoundingRect boundingRect;

    private Quadrant topLeftQuadrant;
    private Quadrant topRightQuadrant;
    private Quadrant bottomLeftQuadrant;
    private Quadrant bottomRightQuadrant;

    private ArrayList<GameObject> gameObjects = new ArrayList<>();

    public Quadrant(final BoundingRect boundingRect) {
        this.boundingRect = boundingRect;
    }

    public boolean insert(final GameObject gameObject) {
        if (gameObject == null) {
            return false;
        }

        final Point point = gameObject.getPoint();
        if (!this.boundingRect.contains(point)) {
            return false;
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

        int width = Math.abs(x1 - x2);
        int height = Math.abs(y1 - y2);

        if (width <= MAX_UNIT_QUAD_DIMENSION_LENGTH
            && height <= MAX_UNIT_QUAD_DIMENSION_LENGTH) {
            this.gameObjects.add(gameObject);
            return true;
        }

        int midX = (x1 + x2) / 2;
        int midY = (y1 + y2) / 2;

        Point p1 = new Point(x1, y1);
        Point p2 = new Point(midX, midY);
        BoundingRect rect = new BoundingRect(p1,
                p2.getX() - p1.getX(),
                p2.getY() - p1.getY());

        if (rect.contains(point)) {
            if (this.topLeftQuadrant == null) {
                this.topLeftQuadrant = new Quadrant(rect);
            }

            return this.topLeftQuadrant
                    .insert(gameObject);
        }

        p1 = new Point(midX, y1);
        p2 = new Point(x2, midY);
        rect = new BoundingRect(p1,
                p2.getX() - p1.getX(),
                p2.getY() - p1.getY());

        if (rect.contains(point)) {
            if (this.topRightQuadrant == null) {
                this.topRightQuadrant = new Quadrant(rect);
            }

            return this.topRightQuadrant
                    .insert(gameObject);
        }

        p1 = new Point(x1, midY);
        p2 = new Point(midX, y2);
        rect = new BoundingRect(p1,
                p2.getX() - p1.getX(),
                p2.getY() - p1.getY());

        if (rect.contains(point)) {
            if (this.bottomLeftQuadrant == null) {
                this.bottomLeftQuadrant = new Quadrant(rect);
            }

            return this.bottomLeftQuadrant
                    .insert(gameObject);
        }

        p1 = new Point(midX, midY);
        p2 = new Point(x2, y2);
        rect = new BoundingRect(p1,
                p2.getX() - p1.getX(),
                p2.getY() - p1.getY());

        if (rect.contains(point)) {
            if (this.bottomRightQuadrant == null) {
                this.bottomRightQuadrant = new Quadrant(rect);
            }

            return this.bottomRightQuadrant
                    .insert(gameObject);
        }

        assert false : "Should never happen";
        return false;
    }

    public ArrayList<GameObject> getGameObjects(final BoundingRect rect) {
        ArrayList<GameObject> gameObjects = new ArrayList<>();

        if (!this.boundingRect.overlaps(rect)) {
            return gameObjects;
        }

        for (int i = 0; i < this.gameObjects.size(); ++i) {
            final GameObject object = this.gameObjects.get(i);

            if (rect.contains(object.getPoint())) {
                gameObjects.add(object);
            }
        }

        if (this.topLeftQuadrant != null) {
            gameObjects.addAll(this.topLeftQuadrant
                    .getGameObjects(rect));
        }

        if (this.topRightQuadrant != null) {
            gameObjects.addAll(this.topRightQuadrant
                    .getGameObjects(rect));
        }

        if (this.bottomLeftQuadrant != null) {
            gameObjects.addAll(this.bottomLeftQuadrant
                    .getGameObjects(rect));
        }

        if (this.bottomRightQuadrant != null) {
            gameObjects.addAll(this.bottomRightQuadrant
                    .getGameObjects(rect));
        }

        return gameObjects;
    }
}
