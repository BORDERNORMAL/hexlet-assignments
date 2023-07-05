package exercise;

// BEGIN
public class Cottage implements Home {
    private double area;
    private int floorCount;

    public Cottage(double area, int floorCount) {
        this.area = area;
        this.floorCount = floorCount;
    }

    public double getArea() {
        return this.area;
    }

    public String toString() {
        return this.floorCount + " этажный коттедж площадью " + this.getArea() + " метров";
    }

    public int compareTo(Home another){
        if (this.getArea() == another.getArea()) {
            return 0;
        } else if (this.getArea() > another.getArea()) {
            return 1;
        } else {
            return -1;
        }
    }
}
// END
