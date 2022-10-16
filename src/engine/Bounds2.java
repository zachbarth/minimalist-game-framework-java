package engine;

public class Bounds2 {

    public final Vector2 position;
    public final Vector2 size;

    /**
     * Creates a new 2D bounds rectangle.
     * @param position The origin of the bounds.
     * @param size     The size of the bounds.
     */
    public Bounds2(Vector2 position, Vector2 size) {
        this.position = position;
        this.size = size;
    }

    /**
     * Creates a new 2D bounds rectangle.
     * @param x      The X component of the origin of the bounds.
     * @param y      The Y component of the origin of the bounds.
     * @param width  The width of the bounds.
     * @param height The height of the bounds.
     */
    public Bounds2(float x, float y, float width, float height) {
        position = new Vector2(x, y);
        size = new Vector2(width, height);
    }

    public String toString() {
        return String.format("(%s, %s)", position.toString(), size.toString());
    }

    public Vector2 getMin() {
        return position;
    }

    public Vector2 getMax() {
        return position.add(size);
    }

    /**
     * @param point The point to test.
     * @return Whether or not a point is within these bounds.
     */
    public boolean Contains(Vector2 point) {
        return getMin().x <= point.x && point.x <= getMax().x && getMin().y <= point.y && point.y <= getMax().y;
    }

    /**
     * @param bounds The bounds to test.
     * @return Whether or not another bounds rectangle overlaps these bounds.
     */
    public boolean Overlaps(Bounds2 bounds) {
        return !(bounds.getMax().x < getMin().x || bounds.getMin().x > getMax().x || bounds.getMax().y < getMin().y || bounds.getMin().y > getMax().y);
    }

}
