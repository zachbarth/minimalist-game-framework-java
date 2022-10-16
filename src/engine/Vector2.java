package engine;

public class Vector2 {

    public final float x, y;

    public static final Vector2 zero = new Vector2(0, 0);

    public Vector2(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return String.format("(%f, %f)", x, y);
    }

    /**
     * @return The length of this vector.
     */
    public float length() {
        return (float) Math.sqrt(x * x + y * y);
    }

    /**
     * @param degrees The angle to rotate (in degrees).
     * @return A copy of this vector rotated clockwise around the origin.
     */
    public Vector2 Rotated(float degrees) {
        float radians = (float) (degrees * Math.PI / 180);
        float sin = (float) Math.sin(radians);
        float cos = (float) Math.cos(radians);
        return new Vector2(
                x * cos - y * sin,
                x * sin + y * cos);
    }

    /**
     * @return A copy of this vector normalized so that its length is one. If the length is zero it will be unchanged.
     */
    public Vector2 normalized() {
        float length = length();
        if (length == 0) {
            return Vector2.zero;
        } else {
            return this.div(length);
        }
    }

    /**
     * @return The dot product of this and another vector.
     */
    public float dot(Vector2 vector) {
        return x * vector.x + y * vector.y;
    }

    /**
     * @return The Z component of the cross product of this and another vector.
     */
    public float cross(Vector2 vector) {
        return x * vector.y - y * vector.x;
    }

    public Vector2 add(Vector2 vector) {
        return new Vector2(x + vector.x, y + vector.y);
    }

    public Vector2 sub(Vector2 vector) {
        return new Vector2(x - vector.x, y - vector.y);
    }

    public Vector2 mul(float scalar) {
        return new Vector2(scalar * x, scalar * y);
    }

    public Vector2 div(float scalar) {
        return new Vector2(x / scalar, y / scalar);
    }

}
