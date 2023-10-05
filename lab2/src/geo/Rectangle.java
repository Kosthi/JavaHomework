package geo;

public class Rectangle extends Geo {
    private final double w;
    private final double h;

    public Rectangle(double w, double h) {
        this.w = w;
        this.h = h;
    }

    @Override
    public double getArea() {
        return w * h;
    }

    @Override
    public double getPerimeter() {
        return 2 * (w + h);
    }

    @Override
    public String toString() {
        return "Rectangle [" +
                "w=" + w +
                ", h=" + h +
                ", getArea()=" + String.format("%.2f", getArea()) +
                ", getColor()=" + getColor() +
                ", getPerimeter()=" + String.format("%.2f", getPerimeter()) +
                "]";
    }
}
