package javaSandbox;

import edu.duke.FileResource;
import edu.duke.Point;
import edu.duke.Shape;

/**
 * PerimeterRunner
 */
public class PerimeterRunner {

    public double getParimeter(Shape s) {
        double totalParim = 0;
        Point prevPt = s.getLastPoint();

        for (Point currPt : s.getPoints()) {
            double currDist = prevPt.distance(currPt);
            totalParim = totalParim + currDist;
            prevPt = currPt;
        }
        return totalParim;
    }

    public void testPerimeter() {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getParimeter(s);
        System.out.println("perimeter = " + length);
    }

    public static void main(String[] args) {
        PerimeterRunner pr = new PerimeterRunner();
        pr.testPerimeter();
    }
}