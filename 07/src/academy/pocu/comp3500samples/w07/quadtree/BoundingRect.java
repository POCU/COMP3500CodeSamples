package academy.pocu.comp3500samples.w07.quadtree;

public final class BoundingRect {
    private final Point topLeft;
    private final Point bottomRight;

    public BoundingRect(final Point topLeft, final int width, final int height) {
        assert (width >= 0);
        assert (height >= 0);

        this.topLeft = topLeft;
        this.bottomRight = new Point(topLeft.getX() + width,
                topLeft.getY() + height);
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

    public boolean overlaps(final BoundingRect other) {
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
