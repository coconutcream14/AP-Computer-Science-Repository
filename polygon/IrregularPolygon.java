package polygon;

import java.awt.geom.*; // for Point2D.Double
import java.util.ArrayList; // for ArrayList
import gpdraw.*; // for DrawingTool
import java.lang.Math;

public class IrregularPolygon {
    private ArrayList<Point2D.Double> myPolygon = new ArrayList<Point2D.Double>();

    // constructor
    public IrregularPolygon() {}

    // public methods
    public void add(Point2D.Double aPoint)
    {
        // TODO: Add a point to the IrregularPolygon.
        myPolygon.add(aPoint);
    }

    public double perimeter() {
        // TODO: Calculate the perimeter.
        double distance = 0; //distance = Math.sqrt(((x2 - x1)^2) + ((y2 - y1)^2))
        double total = 0;
        Point2D.Double point1;
        Point2D.Double point2;
        for(int i = 0; i < myPolygon.size() - 1; i++){
            point1 = myPolygon.get(i);
            point2 = myPolygon.get(i + 1);
            distance = point1.distance(point2);
            total += distance;
        }
        point1 = myPolygon.get(0);
        point2 = myPolygon.getLast();
        distance = point1.distance(point2);
        total += distance;
        return total;
    }

    public double area() {
        // TODO: Calculate the area.
        Double area = 0.0;
        return area;
    }

    public void draw()
    {
        // Wrap the DrawingTool in a try/catch to allow development without need for graphics.
        try {
            // TODO: Draw the polygon.
            // Documents: https://pavao.org/compsci/gpdraw/html/gpdraw/DrawingTool.html
            //DrawingTool myDrawingTool = new DrawingTool(new SketchPad(500, 500));
            //myDrawingTool.move(50, 50);
        } catch (java.awt.HeadlessException e) {
            System.out.println("Exception: No graphics support available.");
        }
    }

}
