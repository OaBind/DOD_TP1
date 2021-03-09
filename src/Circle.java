public class Circle extends Shape{
    public int radius;

    public Circle(Shape shape, int radius) {
        super(shape.x, shape.y, shape.color);
        this.radius = radius;
        this.defineCoordonates();
    }

    public void defineCoordonates() {
        this.xmin = this.x - this.radius;
        this.ymin = this.y - this.radius;
        this.xmax = this.x + this.radius;
        this.ymax = this.y + this.radius;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                ", x=" + x +
                ", y=" + y +
                ", xmin=" + xmin +
                ", ymin=" + ymin +
                ", xmax=" + xmax +
                ", ymax=" + ymax +
                ", color=" + color +
                '}';
    }
}
