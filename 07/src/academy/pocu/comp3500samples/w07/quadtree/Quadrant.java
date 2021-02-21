package academy.pocu.comp3500samples.w07.quadtree;

import java.util.ArrayList;

public final class Quadrant {
    private static final int MAX_GAME_OBJECTS_COUNT = 3;

    private final BoundingBox boundingBox;

    private Quadrant topLeftQuadrant;
    private Quadrant topRightQuadrant;
    private Quadrant bottomLeftQuadrant;
    private Quadrant bottomRightQuadrant;

    private ArrayList<GameObject> gameObjects = new ArrayList<>();

    public Quadrant(final BoundingBox boundingBox) {
        this.boundingBox = boundingBox;
    }

    public boolean insert(final GameObject gameObject) {
        if (gameObject == null) {
            return false;
        }

        final Point point = gameObject.getPoint();
        if (!this.boundingBox.contains(point)) {
            return false;
        }

        if (this.gameObjects.size() < MAX_GAME_OBJECTS_COUNT) {
            this.gameObjects.add(gameObject);
            return true;
        }

        if (this.topLeftQuadrant == null) {
            createQuadrants();
        }

        return this.topLeftQuadrant
                    .insert(gameObject)
                || this.topRightQuadrant
                    .insert(gameObject)
                || this.bottomLeftQuadrant
                    .insert(gameObject)
                || this.bottomRightQuadrant
                    .insert(gameObject);
    }

    public ArrayList<GameObject> getGameObjects(final BoundingBox box) {
        ArrayList<GameObject> gameObjects = new ArrayList<>();

        if (!this.boundingBox.overlaps(box)) {
            return gameObjects;
        }

        for (int i = 0; i < this.gameObjects.size(); ++i) {
            final GameObject object = this.gameObjects.get(i);

            if (box.contains(object.getPoint())) {
                gameObjects.add(object);
            }
        }

        if (this.topLeftQuadrant == null) {
            return gameObjects;
        }

        gameObjects.addAll(this.topLeftQuadrant
                .getGameObjects(box));

        gameObjects.addAll(this.topRightQuadrant
                .getGameObjects(box));

        gameObjects.addAll(this.bottomLeftQuadrant
                .getGameObjects(box));

        gameObjects.addAll(this.bottomRightQuadrant
                .getGameObjects(box));

        return gameObjects;
    }

    private void createQuadrants() {
        Point topLeft = this.boundingBox.getTopLeft();
        Point bottomRight = this.boundingBox.getBottomRight();

        int midX = (topLeft.getX() + bottomRight.getX()) / 2;
        int midY = (topLeft.getY() + bottomRight.getY()) / 2;

        Point p1 = new Point(topLeft);
        Point p2 = new Point(midX, midY);
        BoundingBox box = new BoundingBox(p1, p2);
        this.topLeftQuadrant = new Quadrant(box);

        p1 = new Point(midX, topLeft.getY());
        p2 = new Point(bottomRight.getX(), midY);
        box = new BoundingBox(p1, p2);
        this.topRightQuadrant = new Quadrant(box);

        p1 = new Point(topLeft.getX(), midY);
        p2 = new Point(midX, bottomRight.getY());
        box = new BoundingBox(p1, p2);
        this.bottomLeftQuadrant = new Quadrant(box);

        p1 = new Point(midX, midY);
        p2 = new Point(bottomRight);
        box = new BoundingBox(p1, p2);
        this.bottomRightQuadrant = new Quadrant(box);
    }
}
