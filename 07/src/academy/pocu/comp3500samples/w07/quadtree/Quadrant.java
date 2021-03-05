package academy.pocu.comp3500samples.w07.quadtree;

import java.util.ArrayList;

public final class Quadrant {
    private static final int MAX_DIMENSION_LENGTH = 2;

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

        int leftX = this.boundingRect.getTopLeft().getX();
        int rightX = this.boundingRect.getBottomRight().getX();
        int leftY = this.boundingRect.getTopLeft().getY();
        int rightY = this.boundingRect.getBottomRight().getY();

        if (Math.abs(leftX - rightX) <= MAX_DIMENSION_LENGTH
            && Math.abs(leftY - rightY) <= MAX_DIMENSION_LENGTH) {
            this.gameObjects.add(gameObject);
            return true;
        }

        Point topLeft = this.boundingRect.getTopLeft();
        Point bottomRight = this.boundingRect.getBottomRight();

        int midX = (topLeft.getX() + bottomRight.getX()) / 2;
        int midY = (topLeft.getY() + bottomRight.getY()) / 2;

        Point p1 = new Point(topLeft);
        Point p2 = new Point(midX, midY);
        BoundingRect box = new BoundingRect(p1,
                p2.getX() - p1.getX(),
                p2.getY() - p1.getY());

        if (box.contains(point)) {
            if (this.topLeftQuadrant == null) {
                this.topLeftQuadrant = new Quadrant(box);
            }

            return this.topLeftQuadrant
                    .insert(gameObject);
        }

        p1 = new Point(midX, topLeft.getY());
        p2 = new Point(bottomRight.getX(), midY);
        box = new BoundingRect(p1,
                p2.getX() - p1.getX(),
                p2.getY() - p1.getY());

        if (box.contains(point)) {
            if (this.topRightQuadrant == null) {
                this.topRightQuadrant = new Quadrant(box);
            }

            return this.topRightQuadrant
                    .insert(gameObject);
        }

        p1 = new Point(topLeft.getX(), midY);
        p2 = new Point(midX, bottomRight.getY());
        box = new BoundingRect(p1,
                p2.getX() - p1.getX(),
                p2.getY() - p1.getY());

        if (box.contains(point)) {
            if (this.bottomLeftQuadrant == null) {
                this.bottomLeftQuadrant = new Quadrant(box);
            }

            return this.bottomLeftQuadrant
                    .insert(gameObject);
        }

        p1 = new Point(midX, midY);
        p2 = new Point(bottomRight);
        box = new BoundingRect(p1,
                p2.getX() - p1.getX(),
                p2.getY() - p1.getY());

        if (box.contains(point)) {
            if (this.bottomRightQuadrant == null) {
                this.bottomRightQuadrant = new Quadrant(box);
            }

            return this.bottomRightQuadrant
                    .insert(gameObject);
        }

        assert false : "Should never happen";
        return false;
    }

    public ArrayList<GameObject> getGameObjects(final BoundingRect box) {
        ArrayList<GameObject> gameObjects = new ArrayList<>();

        if (!this.boundingRect.overlaps(box)) {
            return gameObjects;
        }

        for (int i = 0; i < this.gameObjects.size(); ++i) {
            final GameObject object = this.gameObjects.get(i);

            if (box.contains(object.getPoint())) {
                gameObjects.add(object);
            }
        }

        if (this.topLeftQuadrant != null) {
            gameObjects.addAll(this.topLeftQuadrant
                    .getGameObjects(box));
        }

        if (this.topRightQuadrant != null) {
            gameObjects.addAll(this.topRightQuadrant
                    .getGameObjects(box));
        }

        if (this.bottomLeftQuadrant != null) {
            gameObjects.addAll(this.bottomLeftQuadrant
                    .getGameObjects(box));
        }

        if (this.bottomRightQuadrant != null) {
            gameObjects.addAll(this.bottomRightQuadrant
                    .getGameObjects(box));
        }

        return gameObjects;
    }
}
