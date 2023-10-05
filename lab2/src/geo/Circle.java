package geo;

public class Circle extends Geo {
    private double radius;

    public Circle() {
        super();
    }

    public Circle(double r) {
        this.radius = r;
    }

    public Circle(double r, String color) {
        this.radius = r;
        this.setColor(color);
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * radius * Math.PI;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "Circle [" +
                "radius=" + radius +
                ", getArea()=" + String.format("%.2f", getArea()) +
                ", getColor()=" + getColor() +
                ", getPerimeter()=" + String.format("%.2f", getPerimeter()) +
                "]";
    }
}
