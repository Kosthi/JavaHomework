package geo;

public abstract class Geo {
    private String color = "Black";

    public Geo() {
    }

    public Geo(String c) {
        this.color = c;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public abstract double getArea();

    public abstract double getPerimeter();
}
