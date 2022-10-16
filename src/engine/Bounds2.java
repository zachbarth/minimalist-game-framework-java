package engine;

public class Bounds2 {

    public final Vector2 Position;
    public final Vector2 Size;

    /**
     * Creates a new 2D bounds rectangle.
     * @param position The origin of the bounds.
     * @param size     The size of the bounds.
     */
    public Bounds2(Vector2 position, Vector2 size) {
        Position = position;
        Size = size;
    }

    /**
     * Creates a new 2D bounds rectangle.
     * @param x      The X component of the origin of the bounds.
     * @param y      The Y component of the origin of the bounds.
     * @param width  The width of the bounds.
     * @param height The height of the bounds.
     */
    public Bounds2(float x, float y, float width, float height) {
        Position = new Vector2(x, y);
        Size = new Vector2(width, height);
    }

    public String toString() {
        return String.format("(%s, %s)", Position.toString(), Size.toString());
    }

    public Vector2 getMin() {
        return Position;
    }

    public Vector2 getMax() {
        return Position.add(Size);
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
