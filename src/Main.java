import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String args[]) {
        ArrayList<Shape> shapes = new ArrayList<Shape>();
        shapes.add(new Circle(new Shape(100, 100, Color.RED),6));
        shapes.add(new Square(new Shape(400, 300, Color.BLUE),10, 50));
        ArrayList<Color> colors = getColors(shapes);
        colors.forEach(color -> {
            System.out.println(color.toString());
        });
        List<Shape> squares = filter(shapes, Square.class);
        List<Circle> circles = filter(shapes, Circle.class).stream().map(
                shape -> {
                    return shape.getClass() == Circle.class ? (Circle) shape : null;
                }
        ).collect(Collectors.toList());
        List<Square> mutatedSquares = toSquares(circles);
        int area = calculateArea(Stream.concat(squares.stream(), mutatedSquares.stream()).collect(Collectors.toList()));
        System.out.println("Area : " + area);
    }

    public static int calculateArea(List<Shape> shapes) {
        // 0: xmin, 1: ymin, 2: xmax, 3: ymax
        int [] result = {Integer.MAX_VALUE, Integer.MAX_VALUE, -1, -1};
        shapes.forEach(shape -> {
            if(shape.xmin < result[0]) result[0] = shape.xmin;
            if(shape.ymin < result[1]) result[1] = shape.ymin;
            if(shape.xmax > result[2]) result[2] = shape.xmax;
            if(shape.ymax > result[3]) result[3] = shape.ymax;
        });
        return (result[2] - result[0]) * (result[3] - result[1]);
    }

    public static ArrayList<Color> getColors(ArrayList<Shape> shapes) {
        ArrayList<Color> colors = new ArrayList<Color>();
        shapes.forEach(shape -> {
            if(!colors.contains(shape.color)) colors.add(shape.color);
        });
        return colors;
    }

    public static List<Shape> filter(ArrayList<Shape> shapes, Class shapeType) {
        return shapes.stream().filter(
                shape -> {
                    return(shape.getClass() == shapeType);
                }
        ).collect(Collectors.toList());
    }

    public static List<Square> toSquares(List<Circle> circles) {
        return circles.stream().map(
                circle -> {
                    return new Square(new Shape(
                            circle.xmin,
                            circle.ymin,
                            circle.color
                    ), circle.radius * 2, circle.radius * 2);
                }
        ).collect(Collectors.toList());
    }
}
