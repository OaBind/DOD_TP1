public class Shape {
    public int x;
    public int y;
    public int xmin;
    public int ymin;
    public int xmax;
    public int ymax;

    @Override
    public String toString() {
        return "Shape{" +
                "x=" + x +
                ", y=" + y +
                ", xmin=" + xmin +
                ", ymin=" + ymin +
                ", xmax=" + xmax +
                ", ymax=" + ymax +
                ", color=" + color +
                '}';
    }

    public Color color;

    public Shape(int x, int y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }
}
