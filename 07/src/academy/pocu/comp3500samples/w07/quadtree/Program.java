package academy.pocu.comp3500samples.w07.quadtree;

import java.util.ArrayList;

public class Program {
    public static void main(String[] args) {
        final Point p1 = new Point(1, 4);
        final GameObject gameObject1 = new GameObject(p1, 1);

        final Point p2 = new Point(7, 9);
        final GameObject gameObject2 = new GameObject(p2, 2);

        final Point p3 = new Point(5, 5);
        final GameObject gameObject3 = new GameObject(p3, 3);

        final Point p4 = new Point(3, 4);
        final GameObject gameObject4 = new GameObject(p4, 4);

        final Point p5 = new Point(2, 7);
        final GameObject gameObject5 = new GameObject(p5, 5);

        final Point p6 = new Point(9, 3);
        final GameObject gameObject6 = new GameObject(p6, 6);

        Point topLeft = new Point(0, 0);

        BoundingRect rect = new BoundingRect(topLeft, 10, 10);
        final Quadrant root = new Quadrant(rect);

        assert (root.insert(gameObject1));
        assert (root.insert(gameObject2));
        assert (root.insert(gameObject3));
        assert (root.insert(gameObject4));
        assert (root.insert(gameObject5));
        assert (root.insert(gameObject6));

        topLeft = new Point(0, 2);
        rect = new BoundingRect(topLeft, 8, 2);

        ArrayList<GameObject> gameObjects = root.getGameObjects(rect);

        print(gameObjects);

        topLeft = new Point(2, 1);
        rect = new BoundingRect(topLeft, 6, 8);

        gameObjects = root.getGameObjects(rect);

        print(gameObjects);

        topLeft = new Point(2, 4);
        rect = new BoundingRect(topLeft, 3, 3);

        gameObjects = root.getGameObjects(rect);

        print(gameObjects);
    }

    private static void print(ArrayList<GameObject> gameObjects) {
        System.out.println("--------------------");
        for (int i = 0; i < gameObjects.size(); ++i) {
            GameObject obj = gameObjects.get(i);
            System.out.println(String.format("%d. [%d] (%d, %d)",
                    i + 1,
                    obj.getData(),
                    obj.getPosition().getX(),
                    obj.getPosition().getY()));
        }

        System.out.println(String.format("Count: %d", gameObjects.size()));

        System.out.println("--------------------");
    }
}
