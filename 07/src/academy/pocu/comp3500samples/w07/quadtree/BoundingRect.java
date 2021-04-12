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

    public int getWidth() {
        final int x1 = this.topLeft
                .getX();
        final int x2 = this.bottomRight
                .getX();

        return Math.abs(x1 - x2);
    }

    public int getHeight() {
        final int y1 = this.topLeft
                .getY();
        final int y2 = this.bottomRight
                .getY();

        return Math.abs(y1 - y2);
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

    public boolean contains(final BoundingRect other) {
        final int x1 = this.topLeft.getX();
        final int x2 = this.bottomRight.getX();
        final int y1 = this.topLeft.getY();
        final int y2 = this.bottomRight.getY();

        final int otherX1 = other.topLeft.getX();
        final int otherX2 = other.bottomRight.getX();
        final int otherY1 = other.topLeft.getY();
        final int otherY2 = other.bottomRight.getY();

        return x1 <= otherX1
                && x2 >= otherX2
                && y1 <= otherY1
                && y2 >= otherY2;
    }
}
