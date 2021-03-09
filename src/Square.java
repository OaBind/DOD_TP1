public class Square extends Shape{
    public int width;
    public int height;

    public Square(Shape shape, int width, int height) {
        super(shape.x, shape.y, shape.color);
        this.width = width;
        this.height = height;
        this.defineCoordonates();
    }

    public void defineCoordonates() {
        this.xmin = this.x;
        this.ymin = this.y;
        this.xmax = this.xmin + this.width;
        this.ymax = this.ymin + this.height;
    }

    @Override
    public String toString() {
        return "Square{" +
                "width=" + width +
                ", height=" + height +
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
