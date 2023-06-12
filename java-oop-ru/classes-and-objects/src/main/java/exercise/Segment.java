package exercise;

// BEGIN
public class Segment {
    private Point beginPoint;
    private Point endPoint;

    public Segment(Point beginPoint, Point endPoint) {
        this.beginPoint = beginPoint;
        this.endPoint = endPoint;
    }

    public Point getBeginPoint() {
        return beginPoint;
    }

    public Point getEndPoint() {
        return endPoint;
    }

    public Point getMidPoint() {
        int x1 = beginPoint.getX();
        int x2 = endPoint.getX();

        int y1 = beginPoint.getY();
        int y2 = endPoint.getY();

        int minx = x1;
        int maxx = x2;

        if (x1 > x2) {
            minx = x2;
            maxx = x1;
        }

        int miny = y1;
        int maxy = y2;

        if (y1 > y2) {
            miny = y2;
            maxy = y1;
        }

        int diffx = maxx - minx;
        int diffy = maxy - miny;

        int midx = diffx / 2;
        int midy = diffy / 2;

        return new Point(minx + midx, miny + midy);
    }
}
// END
