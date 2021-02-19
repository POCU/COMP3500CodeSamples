package academy.pocu.comp2500samples.w07.quadtree;

public final class BoundingBox {
    private Point topLeft;
    private Point bottomRight;

    public BoundingBox(final Point topLeft, final Point topRight) {
        this.topLeft = topLeft;
        this.bottomRight = topRight;
    }

    public Point getTopLeft() {
        return this.topLeft;
    }

    public Point getBottomRight() {
        return this.bottomRight;
    }

    public boolean contains(final Point point) {
        final int pX = point.getX();
        final int pY = point.getY();

        return pX >= this.topLeft.getX()
                && pX <= this.bottomRight.getX()
                && pY >= this.topLeft.getY()
                && pY <= this.bottomRight.getY();
    }

    public boolean overlaps(final BoundingBox other) {
        if (this.topLeft.getX() > other.bottomRight.getX()
                || other.topLeft.getX() > this.bottomRight.getX()) {
            return false;
        }

        if (this.topLeft.getY() > other.bottomRight.getY()
                || other.topLeft.getY() > this.bottomRight.getY()) {
            return false;
        }

        return true;
    }
}
